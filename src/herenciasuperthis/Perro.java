/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciasuperthis;

public class Perro extends Animal {

    private boolean pulgas;

    public Perro(int patas, int ojos, boolean pulgas) {
        super(patas, ojos);
        this.pulgas = pulgas;
    }

    public void setPulgas(boolean pulgas) {
        this.pulgas = pulgas;
    }

    public boolean getPulgas() {
        return pulgas;
    }

    // Acceso a campos y métodos del padre
    public void cambiaPadre() {
        this.patas = 3;
        // this.ojos = 5; // ERROR
        setPatas(4);
        setOjos(2);
    }
}
