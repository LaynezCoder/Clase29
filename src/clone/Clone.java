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
public class Clone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carro miCarro = new Carro("Mazda", 2004);
        Carro otroCarro = (Carro) miCarro.clone();
//        Carro otroCarro = new Carro("Mercedez", 2025);
        if (miCarro.equals(otroCarro)) {
            System.out.println("Iguales");
        } else {
            System.out.println("No iguales");
        }
    }
}
