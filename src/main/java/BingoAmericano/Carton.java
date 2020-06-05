/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

//import java.awt.Point;
/**
 *
 * @author herma
 */
public abstract class Carton {

    /*Atributos*/
    private final int[][] matriz;
    private final int filas;
    private final int columnas;

    /*Constructor*/
    public Carton(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.matriz = new int[filas][columnas];
    }

    /*Getter*/
    public int[][] getMatriz() {
        return matriz;
    }

    /*Método generarCarton*/
    public abstract void generarCarton();

    /*Método tacharNumero (si el número que pasamos es igual que el que tenemos en la posicón x dicho valor se pondrá a 99)*/
    public int tacharNumero(int numero) {

        for (int[] matrizNumero : this.matriz) {
            for (int j = 0; j < matrizNumero.length; j++) {
                if (matrizNumero[j] == numero) {
                    matrizNumero[j] = 99;
                }
            }
        }
        return numero;
    }

    /*  Método esLinea (Cremaos un switch en el que vamos a mirar si la fila "x"
       tiene liena contando el numero de 99 y 0 que tiene la fila
       si el contador tiene el mismo valor que la fila da true si no da false)*/
    public boolean esLinea(int numeroFila) {
        int contarFila = 0;

        switch (numeroFila) {
            case 1:

                for (int j = 0; j < this.getMatriz()[0].length; j++) {
                    if (this.getMatriz()[0][j] == 99 || this.getMatriz()[0][j] == 0) {
                        contarFila++;
                    }
                }

                if (contarFila == this.filas) {
                    return true;
                }
                break;
            case 2:
                for (int j = 0; j < this.getMatriz()[1].length; j++) {
                    if (this.getMatriz()[1][j] == 99 || this.getMatriz()[1][j] == 0) {
                        contarFila++;
                    }
                }

                if (contarFila == this.filas) {
                    return true;
                }
                break;
            case 3:
                for (int j = 0; j < this.getMatriz()[2].length; j++) {
                    if (this.getMatriz()[2][j] == 99 || this.getMatriz()[2][j] == 0) {
                        contarFila++;
                    }
                }

                if (contarFila == this.filas) {
                    return true;
                }
                break;
        }

        return false;
    }

    /*Método esBingo (Primero vamos a ir mirando que todas las posiciones de la matriz sean o 99 o 0
    si es cierto le añadimos 1 y si el contador es igual a la multiplicación de las filas por las 
    columnas dará true)*/
    public boolean esbingo() {
        int contador = 0;

        for (int i = 0; i < this.getMatriz().length; i++) {
            for (int j = 0; j < this.getMatriz()[i].length; j++) {
                if (this.getMatriz()[i][j] == 99 || this.getMatriz()[i][j] == 0) {
                    contador++;
                }
            }
        }

        return contador == (this.filas * this.columnas);
    }

}
