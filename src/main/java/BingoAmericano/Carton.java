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
    private int filas;
    private int columnas;

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
        for (int i = 0; i < this.matriz.length; i++) {
            int contarFila1 = 0;
            int contarFila2 = 0;
            int contarFila3 = 0;
            for (int j = 0; j < this.matriz[i].length; j++) {

                if (this.matriz[0][j] == 99) {
                    return true;
                }
                if (this.matriz[1][j] == 99) {
                    return true;
                }
                if (this.matriz[2][j] == 99) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean esbingo() {
        int contador = 0;
        for (int[] matriz1 : this.matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                if (matriz1[j] == 99) {
                    contador++;
                }
                if (contador == 15) {
                    System.out.println("BINGO....!!!");
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    @Override
    public String toString() {
        return "Carton{" + "matriz=" + matriz + ", filas=" + filas + ", columnas=" + columnas + '}';
    }


    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    

}
