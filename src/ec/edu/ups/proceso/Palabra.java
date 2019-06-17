package ec.edu.ups.proceso;

import java.util.Objects;

/**
 *
 * @author DELL
 */
public class Palabra {

    private String palabra;
    private int repetidas;

    public Palabra(String palabra) {
        this.palabra = palabra;
        repetidas = 1;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getRepetidas() {
        return repetidas;
    }

    public void setRepetidas(int repetidas) {
        this.repetidas = repetidas;
    }

    public void addRepetidas() {
        repetidas++;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.palabra);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Palabra other = (Palabra) obj;
        if (!Objects.equals(this.palabra, other.palabra)) {
            return false;
        }
        return true;
    }

}
