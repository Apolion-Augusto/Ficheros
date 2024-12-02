package Actividad02.Persistencia;

import Actividad02.Logica.Conjunto;
import Actividad02.Logica.Restaurante;

import java.io.*;
import java.util.Set;

public class GestorCSV {

    public String ficheroConIndices(String ruta, String ficheroOrigen) {
        File rutaFile = new File(ruta);

        if(!rutaFile.exists()){
            return "La ruta no existe";
        }
        if(!rutaFile.isDirectory()){
            return "La ruta no es un directorio";
        }

        File ficheroOrigenFile = new File(ruta, ficheroOrigen);
        if(!ficheroOrigenFile.exists()){
            return "El fichero origen no existe";
        }

        if(!ficheroOrigenFile.isFile()){
            return "El fichero origen no es un fichero";
        }

        String text = "Lectura de fichero\n";

        BufferedReader buffer = null;
        try {
            buffer = new BufferedReader(new FileReader(ficheroOrigenFile));

            int contLineas = 0;
            String linea = "";

            while((linea = buffer.readLine()) != null){
                contLineas++;
                text += "[" + contLineas + "]\t" + linea + "\n";
            }

            text+= "Numero total lineas : "+contLineas;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR. Fichero no encontrado." +e.getMessage());
        } catch (IOException e){
            System.out.println("ERROR. I/O." +e.getMessage());
        } finally {
            try {
                buffer.close();
            } catch (IOException e) {
                System.out.println("ERROR. I/O." +e.getMessage());
            }
        }
        return text.toString();
        }

    public void cargarDatos(String ruta, String ficheroOrigen, Conjunto conjunto) {
        BufferedReader buffer = null;
        String linea = "";
        int contLineas = 0;

        try{
            buffer = new BufferedReader(new FileReader(new File(ruta, ficheroOrigen)));
            linea = buffer.readLine(); //Cabecera
            contLineas++;

            while((linea = buffer.readLine()) != null){
                String [] trozos = linea.split(",");
                contLineas++;

                if(trozos.length == 5){
                    Restaurante r =
                            new Restaurante
                                    (trozos[0], trozos[1],
                                            trozos[2], trozos[3], trozos[4]);
                    conjunto.addRestaurante(r);
                }else{
                    System.out.println("ERROR. Mal formato DATOS. Linea: "+contLineas);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR. Fichero no encontrado." +e.getMessage());
        } catch (IOException e){
            System.out.println("ERROR. I/O." +e.getMessage());
        } finally {
            try {
                buffer.close();
            } catch (IOException e) {
                System.out.println("ERROR. I/O." +e.getMessage());
            }
        }

    }

    public void guardarDatos(String ruta, String ficheroDestino, Conjunto conjunto) {
        BufferedWriter buffer = null;

        try{
            buffer = new BufferedWriter(new FileWriter(new File(ruta, ficheroDestino)));
            Set<Restaurante> conjuntoRestaurantes = conjunto.getConjunto();

            String cabecera = "NOMBRE;DIRECCION;CIUDAD;PROVINCIA;CP\n";
            buffer.write(cabecera);

            for(Restaurante r : conjuntoRestaurantes){
                String linea = r.getNombre()+";"+r.getDireccion()+";"+r.getCiudad()+";"+r.getProvincia()+";"+r.getCp()+"\n";
                buffer.write(linea);
            }


        } catch (IOException e) {
                System.out.println("ERROR. Escritura Fichero" +e.getMessage());

        } finally {
            try {
                buffer.close();
            } catch (IOException e) {
                System.out.println("ERROR. I/O." +e.getMessage());
            }
        }
        }
    }
