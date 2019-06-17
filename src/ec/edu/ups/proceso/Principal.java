package ec.edu.ups.proceso;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class Principal {
    
    public static void main(String[] josze) {
        List<Palabra> nuevasPalabras = new ArrayList<>();
        //Ruta para leer los textos
        String rutaLec = "C:\\Users\\DELL\\Documents\\ProyectosProgra\\PracticaNPL_BOW\\src\\ec\\edu\\ups\\archivos";
        //Ruta para escribir los resultados en otro archivo de texto
        String rutaEsc = "C:\\Users\\DELL\\Documents\\ProyectosProgra\\PracticaNPL_BOW\\src\\ec\\edu\\ups\\resultado\\Resultado.txt";
        LecturaArchivos leeTexto = new LecturaArchivos(nuevasPalabras);
        File textoLec = new File(rutaLec);
        File[] textos = textoLec.listFiles();
        //Empieza la lectura de textos
        for (int i = 0; i < textos.length; i++) {
            if (textos[i].isFile()) {
                String nombre = textos[i].getName();
                leeTexto.leerTexto(nombre);
            }
        }
        try {
            //Empieza la escritura de resultados
            FileWriter textoRes = new FileWriter(rutaEsc, false);
            BufferedWriter escribe = new BufferedWriter(textoRes);
            escribe.append("<Palabra> = <número de repeticiones>");
            escribe.newLine();
            for (int i = 0; i < nuevasPalabras.size(); i++) {
                escribe.append(nuevasPalabras.get(i).getPalabra() + " = " + nuevasPalabras.get(i).getRepetidas());
                escribe.newLine();
            }
            escribe.close();
            textoRes.close();
        } catch (FileNotFoundException ex1) {
            System.err.println("No se encontró la ruta " + rutaEsc);
        } catch (IOException ex2) {
            System.err.println("Error de escritura " + ex2.getMessage());
        } finally {
            System.out.println("Revise el texto Resultado");
        }
    }
}
