package Ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio05 {
    /*Realizar un programa en java que a partir de una ruta
    de fichero de texto plano indique si el fichero existe o no.*/

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Introduzca la ruta: ");
        String ruta = sc.nextLine();
        File file = new File(ruta);

        if(file.exists()==false) {
            System.out.println("El fichero no existe");
        } else {
            System.out.println("El fichero existe");
        }
    }
}
