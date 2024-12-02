package Ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio02 {
    /*Crear un programa en Java que borre
    el fichero cuya ruta ha sido introducida por el usuario*/


    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Introduzca la ruta: ");
        String ruta = sc.nextLine();
        File file = new File(ruta);

        if(file.exists()==false) {
            System.out.println("El fichero no existe");
        }else{
            System.out.println("El fichero existe");
            if(file.delete()==true) {
                System.out.println("El fichero se ha borrado");
            }else{
                System.out.println("El fichero no se ha borrado");
            }
        }
    }
}
