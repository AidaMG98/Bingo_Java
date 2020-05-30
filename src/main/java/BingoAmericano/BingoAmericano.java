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
    private final CartonAmericano carton;
    private final BomboAmericano bombo;

    public BingoAmericano(CartonAmericano carton, BomboAmericano bombo, LocalDate fecha, String nombre) {
        super(fecha, nombre);
        this.carton = carton;
        this.bombo = bombo;
    }

    public BomboAmericano getBombo() {
        return bombo;
    }

    public CartonAmericano getCarton() {
        return carton;
    }

    @Override
    public String toString() {
        return "BingoAmericano{" + "carton=" + carton + ", bombo=" + bombo + '}';
    }
    
}
