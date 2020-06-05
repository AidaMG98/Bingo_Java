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

    /*Atributo*/
    private final List<Integer> listaBombo;

    /*Constructor*/
    public Bombo() {
        this.listaBombo = new ArrayList<>();
    }

    /*Método de sacarBola (Saca la primera bola y la elimina)*/
    public int sacarBola() {
        return listaBombo.remove(0);
    }

    /*Método de LlenarBombo (Se mete la lista dentro de un for con la cantidad de bolas
    de cada tipo de bombo y se va añadiendo valores a la lista de forma ordenada. 
    Luego se desordena)*/
    public abstract void llenarBombo();

    /*Método de bolasDentro (Indica el tamaño de lista)*/
    public int bolasDentro() {
        return listaBombo.size();
    }

    /*Método que comprueba si esta vacio el bombo*/
    public boolean vacio() {
        return listaBombo.isEmpty();
    }

    /*Getter*/
    public List<Integer> getListaBombo() {
        return listaBombo;
    }

    /*toString*/
    @Override
    public String toString() {
        return " " + listaBombo;
    }
}
