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

    /*Atributo*/
    private static final int CANTIDADBOLAS = 75;

    /*Constructor*/
    public BomboAmericano() {
        
    }
    
    /*Getter*/
    public static int getCANTIDADBOLAS() {
        return CANTIDADBOLAS;
    }

    /*Método de llenar Bombo*/
    @Override
    public void llenarBombo() {
        for (int i = 1; i <= CANTIDADBOLAS; i++) {
            this.getListaBombo().add(i);
        }
        Collections.shuffle(super.getListaBombo());
    }
}
