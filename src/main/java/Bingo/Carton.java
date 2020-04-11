/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.Random;

/**
 *
 * @author aida
 */
public class Carton extends Bombo {

    // Creamos los atributos de la clase
    int[][] matrizNumeros;
    String[][] matrizMarca;

    // Añadimos el construcor
    public Carton() {
        this.matrizNumeros = new int[3][9];
        this.matrizMarca = new String[3][9];
    }

    // Añadimos el método generarCarton en el se va a crear el cartón
    public void generarCarton() {
        Random alt = new Random();

        for (int i = 0; i < this.matrizNumeros.length; i++) {

            for (int j = 0; j < this.matrizNumeros[i].length; j++) {
                int numero;

                switch (j) {
                    case 0:
                        do {
                            numero = alt.nextInt(9) + 1;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        this.matrizNumeros[i][j] = numero;
                        break;
                    case 1:
                        do {
                            numero = alt.nextInt(9) + 11; // Genera nuermos desde el 10 al 19
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        this.matrizNumeros[i][j] = numero;
                        break;
                    case 2:
                        do {
                            numero = alt.nextInt(9) + 21;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        this.matrizNumeros[i][j] = numero;
                        break;
                    case 3:
                        do {
                            numero = alt.nextInt(9) + 31;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        this.matrizNumeros[i][j] = numero;
                        break;
                    case 4:
                        do {
                            numero = alt.nextInt(9) + 41;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);

                        this.matrizNumeros[i][j] = numero;
                        break;
                    case 5:
                        do {
                            numero = alt.nextInt(9) + 51;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        this.matrizNumeros[i][j] = numero;
                        break;
                    case 6:
                        do {
                            numero = alt.nextInt(9) + 61;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        this.matrizNumeros[i][j] = numero;
                        break;
                    case 7:
                        do {
                            numero = alt.nextInt(9) + 71;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        this.matrizNumeros[i][j] = numero;
                        break;
                    case 8:
                        do {
                            numero = alt.nextInt(9) + 82;
                        } while (numero == this.matrizNumeros[0][j] || numero == this.matrizNumeros[1][j] || numero == this.matrizNumeros[2][j]);
                        this.matrizNumeros[i][j] = numero;
                        break;
                }
            }
        }

        // METODO BURBUJA PARA UNA MATRIZ
        for (int i = 0; i< this.matrizNumeros.length - 1; i++) {
            for (int j = 0; j < this.matrizNumeros[i].length; j++) {

                int valor;

                if (this.matrizNumeros[i + 1][j] < this.matrizNumeros[i][j]) {
                    valor = this.matrizNumeros[i + 1][j];
                    this.matrizNumeros[i + 1][j] = this.matrizNumeros[i][j];
                    this.matrizNumeros[i][j] = valor;
                }

                if (this.matrizNumeros[2][j] < this.matrizNumeros[0][j]) {
                    valor = this.matrizNumeros[2][j];
                    this.matrizNumeros[2][j] = this.matrizNumeros[0][j];
                    this.matrizNumeros[0][j] = valor;
                }

            }
        }
//        this.eliminarNumero();

    }

    public void mostrarCarton() {
        System.out.println("\033[34m" + "---------------------------------CARTÓN---------------------------------");
        for (int[] matrizNumero : matrizNumeros) {
            for (int j = 0; j < matrizNumero.length; j++) {

                switch (matrizNumero[j]) {
                    case 0:
                        System.out.print("\033[34m" + " | " + " " + " | ");
                        break;
                    case 99:
                        System.out.print("\033[34m" + " | " + "\033[31m" + "X" + "\033[34m" +" | ");
                        break;
                    default:
                        System.out.print("\033[34m" + " | " + String.valueOf(matrizNumero[j]) + " | ");
                        break;
                }
            }
            System.out.println("");
            System.out.println("\033[34m" + "------------------------------------------------------------------------");
        }

    }

    public void tacharCasilla(int numero) {
        System.out.println("EL NÚMERO QUE HA SALIDO ES EL: " + numero);
        for (int[] matrizNumero : this.matrizNumeros) {
            for (int j = 0; j < matrizNumero.length; j++) {
                if (matrizNumero[j] == numero) {
                    matrizNumero[j] = 99;
                }
            }
        }

    }

    // SIN COMRPOBAR HASTA TERMINAR EL GENERAR BINGO
    public boolean comprobarLinea() {
        for (int i = 0; i < this.matrizNumeros.length; i++) {
            for (int j = 0; j < this.matrizNumeros[i][j]; j++) {
                int contador = 0;
                if (this.matrizNumeros[0][j] == 99) {
                    contador++;
                }
                if (this.matrizNumeros[1][j] == 99) {
                    contador++;
                }
                if (this.matrizNumeros[2][j] == 99) {
                    contador++;
                }
                if (contador == 9) {
                    return true;
                }

            }
        }
        return false;
    }

    // SIN COMRPOBAR HASTA TERMINAR EL GENERAR BINGO
    public boolean comprobarBingo() {
        for (int i = 0; i < this.matrizNumeros.length; i++) {
            for (int j = 0; j < this.matrizNumeros[i][j]; j++) {
                int contador = 0;
                if (this.matrizNumeros[i][j] == 99) {
                    contador++;
                }
                if (contador == 15) {
                    return true;
                }

            }
        }
        return false;
    }

}
