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
public class Animal {

    protected int patas;
    private int ojos;

    public Animal(int patas, int ojos) {
        this.patas = patas;
        this.ojos = ojos;
    }

    public int getPatas() {
        return patas;
    }

    public void setPatas(int patas) {
        this.patas = patas;
    }

    public int getOjos() {
        return ojos;
    }

    public void setOjos(int ojos) {
        this.ojos = ojos;
    }

    public String habla() {
        return "Soy un animal";
    }
}
