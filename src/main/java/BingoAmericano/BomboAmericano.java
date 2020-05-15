/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.util.List;
import java.util.Random;

/**
 *
 * @author herma
 */
public final class BomboAmericano extends Bombo {

    static final int CANTIDADBOLAS = 75;
    private static int restar = CANTIDADBOLAS;

    public BomboAmericano(List listaBombo) {
        super(listaBombo);
    }

    @Override
    public int sacarBola() {
        
        Random alt = new Random();
        int posicion; 
        posicion = (int) listaBombo.remove(alt.nextInt(this.restar));
        this.restar--;
        return posicion;
    }

    @Override
    public void llenarBombo() {
        int bolas = 75;
        
        if (CANTIDADBOLAS == bolas) {
            for (int i = 1; i <= bolas; i++) {
                this.listaBombo.add(i);
            }
            
            System.out.println("EL BOMBO SE HA LLENO");
        } else {
            System.out.println("EL BOMBO YA ESTABA LLENO");
        }
    }
    
    @Override
     public int bolasDentro(){
        return this.restar;
    }
    
    @Override
      public boolean vacio(){
          return listaBombo.isEmpty();
    }
    
}
