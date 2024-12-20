package Actividad03.Logica;


import Actividad03.Exception.ExcepcionPersistencia;

public class Coche {

	private int id;
	private String marca;
	private String modelo;
	
	public Coche(int id, String marca, String modelo) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
	}

	/*Consructor sin parámetros que se usa para crear obetos Coche vacíos*/
	public Coche() {
	
	}

	public int getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	public static Coche serialize(String linea) throws ExcepcionPersistencia {
		
		String[] trozos = linea.split(";");
		
		Coche coche = new Coche();
		
		if(trozos.length != 3) throw new ExcepcionPersistencia("Error en el número de parámetros");
		else {
			try {
				/*Se protege siempre esta acción*/
				coche = new Coche(Integer.parseInt(trozos[0]), trozos[1], trozos[2]);
			} catch (Exception e) {
				throw new ExcepcionPersistencia("Error: el campo id no tiene un número");
			}
		}
		return coche;
	}
	
	public static String serialize(Coche coche) {
		return coche.getId() + ";" + coche.getMarca() + ";" + coche.getModelo() + "\n";
	}
}
