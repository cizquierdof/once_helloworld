package es.taes;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
 

  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource";
  static final String DB_URL = "jdbc:mysql://localhost:3306/carlos";

  // Database credentials
  static final String USER = "root";
  static final String PASS = "root";

  public static void main(String[] args) throws Exception {

    Scanner scn = new Scanner(System.in);
    boolean salir = true;
    Connection conn = null;
    Statement stmt = null;

    try {
      Class.forName(JDBC_DRIVER);
    System.out.println("Connecting to database...");
    conn = DriverManager.getConnection(DB_URL, USER, PASS);
    System.out.println("Creating statement...");
    stmt = conn.createStatement();
    } catch (SQLException e) {
      System.out.println("Error al conectar con la base de datos");
      return;
    }
    // Register JDBC driver and create connection
    

    String query = "";

    Registro reg = new Registro();

    // consulta al usuario si quiere añadir empleados
    // continua añadiendo empleados hasta que le diga que no
    do {

      System.out.println("Indica operación:    ");
      System.out.println("\t n: nuevo empleado");
      System.out.println("\t l: lista empleados");
      System.out.println("\t b: borra empleado");
      System.out.println("\t s: salir");
      System.out.print("> ");
      String entrada = scn.nextLine().toLowerCase();

      switch (entrada) {
      case "n": // añade registro
        reg.addRegistro(); // implementa datos registro
        query = reg.insertQuery();
        stmt.executeUpdate(query); // inserta el registro
        break;
      case "l": // lista registros
        query = "SELECT id, first, last, age FROM Employees";
        ResultSet rs = stmt.executeQuery(query);
        // Extract data from result set
        while (rs.next()) {
          // Retrieve by column name
          int id = rs.getInt("id");
          int age = rs.getInt("age");
          String first = rs.getString("first");
          String last = rs.getString("last");

          System.out.print("ID: " + id);
          System.out.print(", Age: " + age);
          System.out.print(", First: " + first);
          System.out.println(", Last: " + last);
        }
        rs.close();
        break;
      case "b":
        String s= reg.borraRegistro();
        if(s!=""){
          stmt.executeUpdate("DELETE FROM employees WHERE id="+s);
        }
        break;
      case "s":
        salir = false;
        break;
      default:
      System.out.println(AnsiColors.WHITE_BACKGROUND+AnsiColors.BLACK+
                          "Opción no válida"+AnsiColors.RESET);
        break;
      }

    } while (salir);

    // clear environment
    stmt.close();
    conn.close();
  }

}
