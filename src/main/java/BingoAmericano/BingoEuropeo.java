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
    private final CartonEuropeo carton;
    private final BomboEuropeo bombo;

    public BingoEuropeo(CartonEuropeo carton, BomboEuropeo bombo, String id, LocalDate fecha, String nombre) {
        super(id, fecha, nombre);
        this.carton = carton;
        this.bombo = bombo;
    }

    public BomboEuropeo getBombo() {
        return bombo;
    }

    public CartonEuropeo getCarton() {
        return carton;
    }

    @Override
    public String toString() {
        return "BingoEuropeo{" + "carton=" + carton + ", bombo=" + bombo + '}';
    }
    
}
