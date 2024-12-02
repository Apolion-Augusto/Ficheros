package Actividad03.Logica;

import java.util.LinkedList;
import java.util.List;

import Actividad03.Persistencia.*;

public class Concesionario {

	private List<Coche> coches;

	public Concesionario(String nombreFicheroOrigen) {
		
		GestorCSV gestor = new GestorCSV();
		
		/*Dif entre inicializar la lista aquí en la declaración. Consumo de recursos, si se hace 
		 * aquí solo se crea la lista cuando se crea el objeto, si se hace en la declaración se crea
		 * nada más empezar la aplicación*/
		this.coches = new LinkedList<Coche>();
				
		gestor.leerFichero(nombreFicheroOrigen, this.coches);
		/*Elimina todos aquellos registros que están duplicados*/
		
	}

	
	public String listarCoches() {
		String mensaje = "Coches:\n";
		for(int i = 0; i < this.coches.size(); i++) {
			mensaje += "\t" + this.coches.get(i).toString() + "\n";
		}
		return mensaje;
	}


	public void guardarDatos(String nombreFicheroDestino) {
		GestorCSV gestor = new GestorCSV();
		gestor.guardarFichero(nombreFicheroDestino, this.coches);
		
	}
	
	
	
}
