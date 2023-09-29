package eduardo.caballer.ejercicio2clase.Modelos;

import java.io.Serializable;

public class Moto implements Serializable {
    private String marca;
    private String modelo;
    private String cilindrada;

    public Moto() {
    }

    public Moto(String marca, String modelo, String cilindrada) {
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Moto: " + "\n" +
                " marca = " + marca + "\n" +
                " modelo = " + modelo + "\n" +
                " cilindrada = " + cilindrada;
    }
}
