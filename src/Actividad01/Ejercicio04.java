package Actividad01;

import java.io.File;
import java.util.Scanner;

public class Ejercicio04 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Introduzca la ruta: ");
        String ruta = sc.nextLine();
        
        crearEstrucuturaFicheros(ruta);
    }

    private static void crearEstrucuturaFicheros(String ruta) {

        File mainDirectory = new File(ruta);
        if(!mainDirectory.exists()) {
            if(mainDirectory.mkdir()) {
                System.out.println("Directorio creado");
            }else {
                System.out.println("No se ha creado el directorio");
            }
        }

        File binDir = new File(mainDirectory, "bin");
        File usrDir = new File(mainDirectory, "usr");

        if(binDir.mkdir()) {
            System.out.println("Directorio bin creado :"+binDir.getPath());
        }
        if(usrDir.mkdir()) {
            System.out.println("Directorio usr creado :"+usrDir.getPath());
        }
    }
}
