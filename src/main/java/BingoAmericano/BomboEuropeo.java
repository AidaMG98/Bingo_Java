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
public final class BomboEuropeo extends Bombo {
    /*Atributo*/
    private static final int CANTIDADBOLAS = 90;

    /*Constructor*/
    public BomboEuropeo() {
    }
    
    /*Getter*/
    public static int getCANTIDADBOLAS() {
        return CANTIDADBOLAS;
    }
    
    /*Método de llenarBombo*/
    @Override
    public void llenarBombo() {
        for (int i = 1; i <= CANTIDADBOLAS; i++) {
            this.getListaBombo().add(i);
        }
        Collections.shuffle(super.getListaBombo());
    }
}
