package Ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio01 {
    /* Ejercicio 1
    Escribir un programa en Java que para cualquier ruta indicada por el usuario, muestre:
        • Si el fichero existe o no
		• Si se trata de un directorio o de un fichero
	 */

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Introduzca la ruta: ");
        String ruta = sc.nextLine();
        File file = new File(ruta);

        if(file.exists()==false) {
            System.out.println("El fichero no existe");
        } else {
            if(file.isDirectory()==true) {
                System.out.println("Es un directorio");
            } else {
                System.out.println("Es un fichero");
            }
        }
    }

}

