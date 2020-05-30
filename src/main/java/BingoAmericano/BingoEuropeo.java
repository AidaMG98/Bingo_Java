/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.time.LocalDate;

/**
 *
 * @author herma
 */
public final class BingoEuropeo extends Bingo {
    private CartonEuropeo carton;
    private BomboEuropeo bombo;

    public BingoEuropeo(CartonEuropeo carton, BomboEuropeo bombo, LocalDate fecha, String nombre) {
        super(fecha, nombre);
        this.carton = carton;
        this.bombo = bombo;
    }

    public CartonEuropeo getCarton() {
        return carton;
    }

    public void setCarton(CartonEuropeo carton) {
        this.carton = carton;
    }

    public BomboEuropeo getBombo() {
        return bombo;
    }

    public void setBombo(BomboEuropeo bombo) {
        this.bombo = bombo;
    }

 
    @Override
    public String toString() {
        return super.toString() +"\n" + carton + "\nBolas: " + bombo;
    }

}
