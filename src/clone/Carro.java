/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clone;

/**
 *
 * @author Laynecito
 */
public class Carro {

    private String marca;
    private int precio;

    public Carro(String marca, int precio) {
        this.marca = marca;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean equals(Object obj) {
        Carro otro = (Carro) obj;
        return (otro.getPrecio() == this.precio) && (otro.getMarca().equals(this.marca));
    }

    protected Object clone() {
        return new Carro(marca, precio);
    }

    @Override
    public String toString() {
        return "Carro{" + "marca=" + marca + ", precio=" + precio + '}';
    }
}
