/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.util.List;

/**
 *
 * @author herma
 */
public abstract class Bombo {
    List listaBombo;

    public Bombo(List listaBombo) {
        this.listaBombo = listaBombo;
    }
    
    public int sacarBola(){
        return 0;
    }
    
    public void llenarBombo(){
    
    }
    
    public int bolasDentro(){
        return 0;
    
    }
    
    public boolean vacio(){
        return false;
    
    }
}
