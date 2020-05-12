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
public class BingoAmericano extends Bingo {
    private CartonAmericano carton;
    private BomboAmericano bombo;

    public BingoAmericano(CartonAmericano carton, BomboAmericano bombo, String id, LocalDate fecha, String nombre) {
        super(id, fecha, nombre);
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
