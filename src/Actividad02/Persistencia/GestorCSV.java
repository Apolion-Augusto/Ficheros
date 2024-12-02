package Actividad02.Persistencia;

import java.io.*;

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
    }
