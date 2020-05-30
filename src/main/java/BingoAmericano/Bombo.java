/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author herma
 */
public abstract class Bombo {
    private final List<Integer> listaBombo;

    public Bombo() {
        this.listaBombo = new ArrayList<>();
    }
    
    public int sacarBola(){
        return listaBombo.remove(0);
    }
    
    public abstract void llenarBombo();
    
    public int bolasDentro(){
        return listaBombo.size();
    }
    
    public boolean vacio(){
        return listaBombo.isEmpty();
    }

    public List<Integer> getListaBombo() {
        return listaBombo;
    }

    @Override
    public String toString() {
        return  " "+listaBombo;
    }
}
