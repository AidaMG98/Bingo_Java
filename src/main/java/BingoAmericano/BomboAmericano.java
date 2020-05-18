/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.util.Collections;

/**
 *
 * @author herma
 */
public final class BomboAmericano extends Bombo {

    private static final int CANTIDADBOLAS = 75;

    public BomboAmericano() {
        llenarBombo();

    }

    @Override
    public void llenarBombo() {
        for (int i = 1; i <= CANTIDADBOLAS; i++) {
            this.getListaBombo().add(i);
        }
        Collections.shuffle(super.getListaBombo());
    }
}
