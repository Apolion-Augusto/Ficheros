package Actividad03.Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import Actividad03.Logica.*;
import Actividad03.Exception.*;

public class GestorCSV {

	public void leerFichero(String nombreFicheroOrigen, List<Coche> coches) {
		
		BufferedReader buffer = null;
		int contadorLinea = 0;

		/*Creamos un canal de comunicación con la info permanente(File) pero en este caso solo de 
		 * lectura(FileReader) para que no bloqueé el fichero*/
		try {
			buffer= new BufferedReader(new FileReader(nombreFicheroOrigen));
			/*Cabecera*/
			String linea = buffer.readLine();
			contadorLinea ++;
			while((linea = buffer.readLine()) != null) {
					contadorLinea++;
					
					Coche coche = new Coche();
					
					try {
						coche = Coche.serialize(linea);
						validarClave(coches, coche.getId());
						coches.add(coche);
					} catch (ExcepcionPersistencia e) {
						System.out.println(e.toString());
					} catch (ExcepcionLogica e) {
						System.out.println(e.toString());
					}			
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error fichero origen no encontrado");
		} catch (IOException e) {
			System.out.println("Error en la lectura del fichero");
		} finally {
			try {
				buffer.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el fichero");
			}
		} 		
	}

	private void validarClave(List<Coche> coches, int id) throws ExcepcionLogica {

		/*Si encuentra un id igual lanza la excepción*/
		for(int i= 0; i < coches.size(); i++) {
			if(coches.get(i).getId() == id) throw new ExcepcionLogica("Error: id duplicado");
		}

	}

	public void guardarFichero(String nombreFicheroDestino, List<Coche> coches) {
		
		File file = new File(nombreFicheroDestino);
		if(file != null) {
			if(file.exists()) {
				System.out.println("El fichero existe");
				System.out.println("Cuidado. Se va aS sobreescribir");
			}
		}
		
		BufferedWriter buffer = null;
		
		try {
			/*Se abre un canal de comunicación con el disco mediante un FileWriter*/
			buffer = new BufferedWriter(new FileWriter(file));
			
			for(int i = 0; i < coches.size(); i++) {
				Coche coche = coches.get(i);
				String linea = Coche.serialize(coche);
				buffer.write(linea);
			}
		} catch (IOException e) {
			System.out.println("Error de escritura del fichero");
		} finally {
			try {
				buffer.close();
			} catch (IOException e) {
				System.out.println("Error en el cierre del fichero");
			}
		}
		
	}

	
	
}
