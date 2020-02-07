package es.taes;

import java.util.Scanner;

/**
 * Persona
 */
public class Registro {

    private String nombre;
    private String apellidos;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

     public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

       @Override
    public String toString() {
        return "Persona [edad=" + edad + ", nombre=" + nombre + "]";
    }

    public void addRegistro() {
        
        Scanner s=new Scanner(System.in);
           
        System.out.println("Introduce los datos del nuevo empleado.");
        System.out.print("Nombre: ");
        this.setNombre(s.nextLine());
        System.out.print("Apellido: ");
        this.setApellidos(s.nextLine());
        System.out.print("Edad: ");
        String str=s.nextLine();
        this.setEdad(Integer.parseInt( str));
        //TODO: añadir comprobación de que la entrada es válida
    
      }

      public String  borraRegistro(){
          Scanner scn=new Scanner(System.in);

          System.out.println(AnsiColors.RED_BACKGROUND+AnsiColors.WHITE+ 
                            "BORRAR REGISTRO"+AnsiColors.RESET);
          System.out.println("Id:");
          String id=scn.nextLine();
          System.out.println(AnsiColors.RED_BACKGROUND+
                                AnsiColors.WHITE+
                                "¿BORRAR REGISTRO "+id+"? "+
                                AnsiColors.RESET);
            if(scn.nextLine().toLowerCase().equals("s")){

                System.out.println("Registro "+ id+" borrado");
            } else id="";
            return id;

      }

      public String insertQuery(){
          return "INSERT INTO Employees (first, last, age) VALUES('"
                    +this.nombre+"','"
                    +this.apellidos+"', "
                    +this.edad+") ";
      }

}