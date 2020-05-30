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
public final class BingoAmericano extends Bingo {

    private CartonAmericano carton;
    private BomboAmericano bombo;

    public BingoAmericano(CartonAmericano carton, BomboAmericano bombo, LocalDate fecha, String nombre) {
        super(fecha, nombre);
        this.carton = carton;
        this.bombo = bombo;
    }

    public void setBombo(BomboAmericano bombo) {
        this.bombo = bombo;
    }

    public BomboAmericano getBombo() {
        return bombo;
    }

    public void setCarton(CartonAmericano carton) {
        this.carton = carton;
    }

    public CartonAmericano getCarton() {
        return carton;
    }

    @Override
    public String toString() {
        return super.toString() +"\n" + carton + "\nBolas: " + bombo;
    }

}
