/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author herma
 */
public final class CartonAmericano extends Carton {

    static public final int FILAS = 5;
    static public final int COLUMNAS = 5;
    Patron premio;

    public CartonAmericano() {
        super(FILAS, COLUMNAS);
        this.premio = getPatron();
    }
    
    public Patron getPatron() {
         Random aletorio = new Random();
        int numero = aletorio.nextInt(5) + 1;

        switch (numero) {
            case 1:
                return Patron.PATRON_C;
            case 2:
                return Patron.PATRON_E;
            case 3:
                return Patron.PATRON_F;
            case 4:
                return Patron.PATRON_O;
            default:
                return Patron.PATRON_U;
        }
    }

     @Override
    public void generarCarton() {
         for (int i = 0; i < super.getMatriz().length; i++) {
             for (int j = 0; j < super.getMatriz()[i].length; j++) {
                 super.getMatriz()[i][j]= 1;
             }
         }
        
    }
    
    @Override
    public String toString() {
        String titulo = ("  B    I    N    G    O");
        String carton = "\n";
         for (int i = 0; i < this.matriz.length; i++) {
             for (int j = 0; j < this.matriz[i].length; j++) {
                 carton += "| " +this.matriz[i][j] + " |";
             }
             carton += "\n";
        }
        
        return titulo + carton;
    }
    
}
