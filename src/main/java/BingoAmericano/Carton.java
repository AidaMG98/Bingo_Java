/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.awt.Point;

/**
 *
 * @author herma
 */
public abstract class Carton {
    int[][] matriz;
    int filas;
    int columnas;

    public Carton(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }
    
    public abstract void generarCarton();
    
    public Point tacharNumero(int numero){
        return null;
    
    }
    
    public boolean esLinea(int numeroFila){
        return false;
    
    }
    
    public boolean esbingo(){
        return false;
    }
    
}
