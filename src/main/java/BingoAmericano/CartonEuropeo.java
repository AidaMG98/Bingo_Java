/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.util.Random;

/**
 *
 * @author herma
 */
public final class CartonEuropeo extends Carton {
    /*Atributos*/
    static public final int FILAS = 3;
    static public final int COLUMNAS = 9;

    /*Constructor*/
    public CartonEuropeo() {
        super(FILAS, COLUMNAS);
        generarCarton();
    }

    /*Método de generarCarton en el que va a ir sumando 1 a la j y va a ir poniendo números por fila si sale el mismo núemero saca otro.
    Una vez tenga todos los números colocados los ordenan por columnas de menor a mayor, esto lo hace comparando las posiciones que hay en cada columnas.
    Por ultimo va a poner a 0 tres posiciones de cada filas y luego va a volver a comprará por columnas para que no queda una columna completa a 0 */
    @Override
    public void generarCarton() {
        Random alt = new Random();

        for (int i = 0; i < this.getMatriz().length; i++) {
            for (int j = 0; j < super.getMatriz()[i].length; j++) {
                int numero = j;
                super.getMatriz()[i][j] = numero;
                switch (j) {
                    case 0:
                        do {
                            numero = alt.nextInt(9) + 1;
                        } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j]);
                        super.getMatriz()[i][j] = numero;
                        break;
                    case 1:
                        do {
                            numero = alt.nextInt(9) + 11;
                        } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j]);
                        super.getMatriz()[i][j] = numero;
                        break;
                    case 2:
                        do {
                            numero = alt.nextInt(9) + 21;
                        } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j]);
                        super.getMatriz()[i][j] = numero;
                        break;
                    case 3:
                        do {
                            numero = alt.nextInt(9) + 31;
                        } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j]);
                        super.getMatriz()[i][j] = numero;
                        break;
                    case 4:
                        do {
                            numero = alt.nextInt(9) + 41;
                        } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j]);
                        super.getMatriz()[i][j] = numero;
                        break;
                    case 5:
                        do {
                            numero = alt.nextInt(9) + 51;
                        } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j]);
                        super.getMatriz()[i][j] = numero;
                        break;
                    case 6:
                        do {
                            numero = alt.nextInt(9) + 61;
                        } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j]);
                        super.getMatriz()[i][j] = numero;
                        break;
                    case 7:
                        do {
                            numero = alt.nextInt(9) + 71;
                        } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j]);
                        super.getMatriz()[i][j] = numero;
                        break;
                    case 8:
                        do {
                            numero = alt.nextInt(9) + 82;
                        } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j]);
                        super.getMatriz()[i][j] = numero;
                        break;
                }
            }
        }

        for (int i = 0; i < this.getMatriz().length - 1; i++) {
            for (int j = 0; j < this.getMatriz()[i].length; j++) {
                int valor;

                if (this.getMatriz()[i + 1][j] < this.getMatriz()[i][j]) {
                    valor = this.getMatriz()[i + 1][j];
                    this.getMatriz()[i + 1][j] = this.getMatriz()[i][j];
                    this.getMatriz()[i][j] = valor;
                }

                if (this.getMatriz()[2][j] < this.getMatriz()[0][j]) {
                    valor = this.getMatriz()[2][j];
                    this.getMatriz()[2][j] = this.getMatriz()[0][j];
                    this.getMatriz()[0][j] = valor;
                }
            }
        }
        
        int fila0 = 0, fila1 = 0, fila2 = 0 , valor;

        for (int[] matrizNumero : this.getMatriz()) {
            for (int j = 0; j < matrizNumero.length; j++) {
                while (this.getMatriz()[0][j] != 0 && this.getMatriz()[1][j] != 0 && this.getMatriz()[2][j] != 0) {
                    valor = alt.nextInt(3);
                    switch (valor) {
                        case 0:
                            if (fila0 < 3) {
                                this.getMatriz()[0][j] = 0;
                                fila0++;
                            }
                            break;
                        case 1:
                            if (fila1 < 3) {
                                this.getMatriz()[1][j] = 0;
                                fila1++;
                            }
                            break;
                        case 2:
                            if (fila2 < 3) {
                                this.getMatriz()[2][j] = 0;
                                fila2++;
                            }
                            break;
                    }
                }
            }
        }
    }
    
    /*toString en el que creamos tres atributos uno para poner el titulo otro para la casilla y otro para el fin del cartón
    de pendiendo del valor que tenga la posición pondrá un espacio, una "X" o el numero que tiene que ir en esa posición*/
    @Override
    public String toString() {
        String titulo = ("\033[34m" + "-------------------------------CARTÓN-------------------------------");
        String casilla = "";
        String fin = "\033[34m" + "--------------------------------------------------------------------";

        for (int i = 0; i < super.getMatriz().length; i++) {
            for (int j = 0; j < super.getMatriz()[i].length; j++) {
                switch (super.getMatriz()[i][j]) {
                    case 0:
                        casilla += ("\033[34m" + " | " + " " + " | ");
                        break;
                    case 99:
                        casilla += ("\033[34m" + " | " + "\033[31m" + "X" + "\033[34m" + " | ");
                        break;
                    default:
                        casilla += ("\033[34m" + " | " + super.getMatriz()[i][j] + " | ");
                        break;
                }
            }
            casilla += "\n";
        }

        return titulo + "\n" + casilla + fin;
    }
}
