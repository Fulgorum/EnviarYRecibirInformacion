package eduardo.caballer.ejercicio2clase.Modelos;

import java.io.Serializable;

public class Bici implements Serializable {
    private String Marca;
    private String pulgadas;

    public Bici() {
    }

    public Bici(String marca, String pulgadas) {
        Marca = marca;
        this.pulgadas = pulgadas;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(String pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return "Bici: " + "\n" +
                "Marca = " + Marca + "\n" +
                "pulgadas = " + pulgadas;
    }
}
