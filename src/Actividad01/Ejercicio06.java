package Actividad01;

import java.io.File;
import java.util.Scanner;

public class Ejercicio06 {
    /*Crea un programa que muestre por pantalla el listado de
    ficheros y directorios a partir del directorio que le pasemos
    por la entrada estándar, de la siguiente forma:
    Si es directorio pondremos d-NOMDIR y cuando sea archivo
    normal f-NOMFICH. Indicar si el fichero es de lectura o escritura
    mediante (L/E). Si el directorio que le pasamos no existe se tendrá
    que indicar con un mensaje de error*/

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Introduzca la ruta: ");
        String ruta = sc.nextLine();

        File dir = new File(ruta);
        if(dir.exists()) {
            System.out.println("Lista de ficheros y directorios: ");
            File[] files = dir.listFiles();
            for(File file: files) {
                if(file.isDirectory()) {
                    System.out.println("d-"+file.getName());
                }else {
                    System.out.println("f-"+file.getName());
                }
            }
        }else{
            System.out.println("El directorio no existe");
        }
    }
}
