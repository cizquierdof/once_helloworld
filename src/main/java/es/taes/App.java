package es.taes;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

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
        boolean salir=false;
        Connection conn = null;
        Statement stmt = null;
 // Register JDBC driver
 Class.forName(JDBC_DRIVER);
System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        Registro reg=new Registro();

        //consulta al usuario si quiere añadir empleados
        //continua ñadiendo empleados hasta que le diga que no
        do{
        System.out.println("¿Añadir nuevo empeado? s/n");
        String entrada=scn.nextLine().toLowerCase();
        if(entrada=="s"){
          reg.addRegistro();  //recopila registro
           // Open a connection
        

               

        
        stmt.executeUpdate(reg.insertQuery());  //inserta el registro

        }while(salir)


       
        // Execute a query
        System.out.println("Creating statement...");
        
        String sql;
        sql = "SELECT id, first, last, age FROM Employees";

        

        ResultSet rs = stmt.executeQuery(sql);

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
      // Clean-up environment
      rs.close();
      stmt.close();
      conn.close();

    } while(salir);

    scn.close();
  }


}
