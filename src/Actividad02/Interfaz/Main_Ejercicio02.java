package Actividad02.Interfaz;

import Actividad02.Logica.Conjunto;
import Actividad02.Logica.Restaurante;
import Actividad02.Persistencia.GestorCSV;

import java.util.List;

public class Main_Ejercicio02 {

    /*Partiendo del fichero de restaurantes.csv, crear un programa
    de Java que muestre los datos de todos aquellos restaurantes
    cuyo código postal empiece por 6.*/


    public static void main(String[] args) {

        String ruta = "E:\\2DAM\\AccesoADatos\\Tema_02\\IntelliJ\\Ficheros\\src\\Actividad02\\Datos";
        String ficheroOrigen = "restaurantes.csv";
        String ficheroDestino = "restauranteOut.csv";

        GestorCSV gestor = new GestorCSV();
        Conjunto conjunto = new Conjunto();
        gestor.cargarDatos(ruta, ficheroOrigen, conjunto);

        List <Restaurante> lista = conjunto.listaRestaurantes();

        System.out.println("Los restaurantes con codigo postal 6 son: \n");
        for(Restaurante r : lista) {
            if(r.getCp().startsWith("6")) {
                System.out.println(r.toString());
            }
        }


    }
}
