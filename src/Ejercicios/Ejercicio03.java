package Ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio03 {
    /*Escribir un programa que muestre los archivos (SOLO LOS ARCHIVOS)
    de un directorio introducido por el usuario*/

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Introduzca la ruta: ");
        String ruta = sc.nextLine();
        File Directorio = new File(ruta);

        if(Directorio.exists()==false){
            System.out.println("El directorio no existe");
        }else{
            File[] archivos = Directorio.listFiles();
            for(int i=0;i<archivos.length;i++){
                System.out.println(archivos[i].getName());
            }
        }

    }
}
