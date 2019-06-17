package ec.edu.ups.proceso;

import java.util.List;

/**
 *
 * @author DELL
 */
public class CuentaPalabras {

    List<Palabra> listaPalabras;

    public CuentaPalabras(List<Palabra> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    public void buscarPalabras(String linea) {
        //i = comienzo de substring
        int i = 0;
        //f = final de substring
        for (int f = 0; f < linea.length(); f++) {
            if (linea.charAt(f) == ' ' || f == (linea.length() - 1)) {
                String palabra = linea.substring(i, f);
                if (f == linea.length() - 1) {
                    palabra = linea.substring(i, f + 1);
                }
                palabra.toUpperCase();
                //Retoma desde el final del anterior substring + 1
                i = f + 1;
                if (!palabra.equals(" ")) {
                    Palabra nuevaPalabra = new Palabra(palabra);
                    if (listaPalabras.contains(nuevaPalabra)) {
                        for (Palabra palabraRep : listaPalabras) {
                            if (palabraRep.getPalabra().equals(palabra)) {
                                palabraRep.addRepetidas();
                            }
                        }
                    } else {
                        listaPalabras.add(nuevaPalabra);
                    }
                }
            }
        }
    }
}
