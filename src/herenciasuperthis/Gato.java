/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciasuperthis;

public class Gato extends Animal {

    /**
     * @param patas
     * @param ojos
     */
    public Gato(int patas, int ojos) {
        super(patas, ojos);
    }

    // Herencia con reemplazo de método
    public String habla() {
        return "Soy un Gato";
    }
}
