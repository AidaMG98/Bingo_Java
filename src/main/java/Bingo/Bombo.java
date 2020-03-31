/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author aida
 */
public class Bombo {

    private final ArrayList<Integer> bolas;
    private int contador;

    public Bombo() {
        this.bolas = new ArrayList<>();

    }

    public void llenarBombo() {
        for (int i = 1; i <= 90; i++) {
            this.bolas.add(i);
        }
        // Para comprobar que esta funcionando
        System.out.println(bolas);
    }

    public void sacarBola() {
        Random alt = new Random();
        if (contador > bolas.size()) {
            System.out.println("NO QUEDAN BOLAS");
        } else {
            int posicion = alt.nextInt(89) + 1;
            do{
                posicion = alt.nextInt(89) + 1;
            } while(bolas.indexOf(0) == posicion);
            
            System.out.println(bolas.get(posicion));
            bolas.set(posicion, 0);
        }
        System.out.println(bolas);
        contador++;

    }

    @Override
    public String toString() {
        return "Bombo{" + "bolas=" + bolas + '}';
    }

}
