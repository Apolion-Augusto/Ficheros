package Actividad02.Interfaz;

import Actividad02.Logica.Conjunto;
import Actividad02.Logica.Restaurante;
import Actividad02.Persistencia.GestorCSV;

public class Main_Ejercicio03 {
    /*Partiendo del fichero de restaurantes.csv, crear un programa
    de Java que permita al usuario añadir datos nuevos a ese
     fichero, utilizando el mismo formato que los ya existentes.*/

    public static void main(String[] args) {
        String ruta = "E:\\2DAM\\AccesoADatos\\Tema_02\\IntelliJ\\Ficheros\\src\\Actividad02\\Datos";
        String ficheroOrigen = "restaurantes.csv";
        String ficheroDestino = "restauranteOut.csv";

        GestorCSV  gestor = new GestorCSV();
        Conjunto conjunto = new Conjunto();
        gestor.cargarDatos(ruta, ficheroOrigen, conjunto);

        conjunto.addRestaurante(new Restaurante("Restaurante 7", "Calle 7", "Sevilla", "Sevilla", "41007"));
        conjunto.addRestaurante(new Restaurante("Restaurante 8", "Calle 8", "Sevilla", "Sevilla", "41008"));
        conjunto.addRestaurante(new Restaurante("Restaurante 9", "Calle 9", "Sevilla", "Sevilla", "41009"));

        gestor.guardarDatos(ruta, ficheroDestino, conjunto);

    }
}
