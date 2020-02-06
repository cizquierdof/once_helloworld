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
        System.out.println("Nombre:");
        this.setNombre(s.nextLine());
        System.out.println("Apellido:");
        this.setApellidos(s.nextLine());
        System.out.println("Edad:");
        this.setEdad(Integer.parseInt( s.nextLine()));
        //TODO: añadir comprobación de que la entrada es válida
    
        //s.close();
           
      }

      public String insertQuery(){
          return "INSERT INTO Employees (first, last, age) VALUES('"
                    +this.nombre+"','"
                    +this.apellidos+"', "
                    +this.edad+") ";
      }

}