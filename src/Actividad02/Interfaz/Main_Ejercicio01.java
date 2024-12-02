package Actividad02.Interfaz;
/*Ejercicio 1
Partiendo del fichero de restaurantes.csv, crear un programa
de Java que muestre sus líneas, identificando cada una de
ellas mediante un índice.*/

import Actividad02.Persistencia.GestorCSV;

public class Main_Ejercicio01 {
    public static void main(String[] args) {

        String ruta = "E:\\2DAM\\AccesoADatos\\Tema_02\\IntelliJ\\Ficheros\\src\\Actividad02\\Datos";
        String ficheroOrigen = "restaurantes.csv";
        String ficheroDestino = "restauranteOut.csv";

        GestorCSV gestor = new GestorCSV();
        String cadena = gestor.ficheroConIndices(ruta, ficheroOrigen);
        System.out.println(cadena);
    }





}
