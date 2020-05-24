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

    private final int[][] matriz;
    private final int filas;
    private final int columnas;

    public Carton(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas];
    }

    public abstract void generarCarton();

    public Point tacharNumero(int numero) {
        for (int[] matrizNumero : this.matriz) {
            for (int j = 0; j < matrizNumero.length; j++) {
                if (matrizNumero[j] == numero) {
                    matrizNumero[j] = 99;
                }
            }
        }
        return null;
    }

    public boolean esLinea(int numeroFila) {
        int contarFila1 = 0, contarFila2 = 0, contarFila3 = 0;
        
        for (int i = 0; i < this.matriz.length; i++) {            
            for (int j = 0; j < this.matriz[i].length; j++) {

                if (this.matriz[0][j] == 0) {
                    contarFila1++;
                }
                if (this.matriz[1][j] == 0) {
                    contarFila2++;
                }
                if (this.matriz[2][j] == 0) {
                    contarFila3++;
                }
            }
        }
        
        for (int i = 0; i < this.getMatriz().length; i++) {
            for (int j = 0; j < this.getMatriz()[i].length; j++) {
                if (contarFila1 == (filas) || contarFila2 == (filas) || contarFila3 == (filas)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean esbingo() {
        int contador = 0;

        for (int i = 0; i < this.getMatriz().length; i++) {
            for (int j = 0; j < this.getMatriz()[i].length; j++) {
                if (this.getMatriz()[i][j] == 0) {
                    contador++;
                }
            }
        }

        for (int i = 0; i < this.getMatriz().length; i++) {
            for (int j = 0; j < this.getMatriz()[i].length; j++) {
                if (this.getMatriz()[i][j] == 99) {
                    contador++;
                }
            }
        }

        for (int i = 0; i < this.getMatriz().length; i++) {
            for (int j = 0; j < this.getMatriz()[i].length; j++) {
                if (contador == (filas * columnas)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}
