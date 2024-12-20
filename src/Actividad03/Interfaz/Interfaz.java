/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Actividad03.Interfaz;
import Actividad03.Logica.*;

/**
 *
 * @author Usuario
 */
public class Interfaz {

    String nombreFicheroOrigen;
    String nombreFicheroDestino;

    public Interfaz(){
        String rutafichero = System.getProperty("user.dir")+"\\src\\Actividad03\\Data\\";
        nombreFicheroOrigen = rutafichero+"coches.csv";        
        nombreFicheroDestino = rutafichero+"cochesDestino.csv";
    }
    
    /**
     * Prints a menu for the user and performs operations related to the
     * Concesionario class.
     * The operations include:
     * - Listing all the data from the file
     * - Creating new Coche objects
     * - Listing all the Coche objects of a certain marca
     * - Saving the data to a file
     */
    public void menu(){
        Concesionario concesionario = new Concesionario(nombreFicheroOrigen);
        System.out.println("Listado de la informacion");
        System.out.println(concesionario.listarCoches());

        //Uncomment to create new Coche objects
        //concesionario.NuevoCoche("nissan","xtrail");
        //concesionario.NuevoCoche("seat","leon");
        //concesionario.NuevoCoche("opel","astra");

        //Uncomment to print the listado de la informacion
        //System.out.println("Listado de la informacion");
        //System.out.println(concesionario.listarCoches());

        //Uncomment to print the listado marca seat
        //System.out.println("Listado marca seat");
        //System.out.println(concesionario.listarCochesPorMarca("seat"));

        concesionario.guardarDatos(nombreFicheroDestino);

    }
    /**
     * The main method serves as the entry point for the application.
     * It creates an instance of the Interfaz class, which initializes
     * file paths and potentially performs operations related to
     * the Concesionario class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Interfaz interfaz = new Interfaz();
        interfaz.menu();
    }
    
}
