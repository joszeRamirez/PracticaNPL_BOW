package ec.edu.ups.proceso;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author DELL
 */
public class LecturaArchivos {

    List<Palabra> nuevasPalabras;
    CuentaPalabras cp;

    public LecturaArchivos(List<Palabra> nuevasPalabras) {
        this.nuevasPalabras = nuevasPalabras;
        cp = new CuentaPalabras(nuevasPalabras);
    }

    public void leerTexto(String nombre) {
        try {
            FileReader archivo = new FileReader(nombre);
            BufferedReader lectura = new BufferedReader(archivo);
            String linea = "";
            while (linea != null) {
                linea = lectura.readLine();
                if (linea != null) {
                    cp.buscarPalabras(linea);
                }
            }
        } catch (FileNotFoundException Ex) {
            System.err.println("No se ha encontrado " + nombre);
        } catch (IOException Ex) {
            System.err.println("Error de lectura");
        }
    }
}
