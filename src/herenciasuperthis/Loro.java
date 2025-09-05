/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciasuperthis;

/**
 *
 * @author Laynecito
 */
public class Loro extends Animal {

    public Loro(int patas, int ojos) {
        super(patas, ojos);
    }

    // Refinamiento
    public String habla() {
        return "Soy un Loro y " + super.habla();
    }
}
