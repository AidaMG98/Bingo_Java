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
        // Linea de decoración
        System.out.println("\033[34m" + "---------------------------------CARTÓN---------------------------------");
        // Hacemos un bucle que tendrá dentro otro bulcle, al trarase de una 
        // matriz necesitamos dos bucles para poder rellenarlo
        for (int i = 0; i < this.matrizNumeros.length; i++) {

            for (int j = 0; j < this.matrizNumeros[i].length; j++) {
                // En el interior del segundo bucle hemos creado un atriburo random
                // para añadir los numeros que tendrá cada hueco de la matriz
                Random alt = new Random();
                // Este bucle While lo que hace es que no deje ningun hueco a 0 
                // para que se generén numeros en todo.
                while (this.matrizNumeros[i][j] == 0) {
                    // Dentro del bucle While creamos un atributo entero que se encarga de 
                    // dar valor a la matriz
                    int numero = alt.nextInt(90) + 1;
                    // Después tenemos una condicón para ir colocando los números, si
                    // el número es menor a 9 se colocará en la primera columna y así
                    // con todas las demás columnas hasta 79, si el número es mayor a
                    // 79 se colocará en la ultima columna
                    if (numero <= 9) {
                        this.matrizNumeros[i][0] = numero;
                    } else if (numero > 9 && numero <= 19) {
                        this.matrizNumeros[i][1] = numero;
                    } else if (numero > 19 && numero <= 29) {
                        this.matrizNumeros[i][2] = numero;
                    } else if (numero > 29 && numero <= 39) {
                        this.matrizNumeros[i][3] = numero;
                    } else if (numero > 39 && numero <= 49) {
                        this.matrizNumeros[i][4] = numero;
                    } else if (numero > 49 && numero <= 59) {
                        this.matrizNumeros[i][5] = numero;
                    } else if (numero > 59 && numero <= 69) {
                        this.matrizNumeros[i][6] = numero;
                    } else if (numero > 69 && numero <= 79) {
                        this.matrizNumeros[i][7] = numero;
                    } else {
                        this.matrizNumeros[i][8] = numero;
                    }
                }

            }
        }

        // Este bucle controla que no exista en la misma columnas valores repetidos
        for (int i = 0; i < matrizNumeros.length; i++) {

            for (int j = 0; j < matrizNumeros[i].length; j++) {

                if (this.matrizNumeros[0][j] >= this.matrizNumeros[1][j]) {
                    this.matrizNumeros[1][j] = 0;
                } else {
                    this.matrizNumeros[0][j] = 0;
                }

                if (this.matrizNumeros[1][j] >= this.matrizNumeros[2][j]) {
                    this.matrizNumeros[2][j] = 0;
                } else {
                    this.matrizNumeros[1][j] = 0;
                }
                
                if (this.matrizNumeros[2][j] >= this.matrizNumeros[0][j]) {
                    this.matrizNumeros[0][j] = 0;
                } else {
                    this.matrizNumeros[2][j] = 0;
                }
            }
        }

        // Este bucle genera el cartón
        for (int[] matrizNumero : matrizNumeros) {
            for (int j = 0; j < matrizNumero.length; j++) {
                // Con String.valueOf() hacemos que se vuelva texto
                if (matrizNumero[j] == 0) {
                    System.out.print("\033[34m" + " | " + "X" + " | ");
                } else {
                    System.out.print("\033[34m" + " | " + String.valueOf(matrizNumero[j]) + " | ");
                }
            }
            System.out.println("");
            System.out.println("\033[34m" + "------------------------------------------------------------------------");
        }
    }
}
