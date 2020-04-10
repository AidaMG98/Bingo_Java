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
        // Atributo random que vamos a usar para generar el cartón
        Random alt = new Random();

        // Linea de decoración
        System.out.println("\033[34m" + "---------------------------------CARTÓN---------------------------------");
        // Hacemos un bucle que tendrá dentro otro bulcle, al trarase de una 
        // matriz necesitamos dos bucles para poder rellenarlo
        for (int i = 0; i < this.matrizNumeros.length; i++) {

            for (int j = 0; j < this.matrizNumeros[i].length; j++) {
                // En el interior del segundo bucle hemos vamos a usar el atriburo random
                // para añadir los numeros que tendrá cada hueco de la matriz
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

////         Este bucle controla que no exista en la misma columnas valores que 
////         esten repetidos o que sean menores al numero que tenga encima o debajo
//        for (int i = 0; i < matrizNumeros.length; i++) {
//
//            for (int j = 0; j < matrizNumeros[i].length; j++) {
//
//                if (this.matrizNumeros[0][j] >= this.matrizNumeros[1][j]) {
//                    this.matrizNumeros[1][j] = 0;
//                } else {
//                    this.matrizNumeros[0][j] = 0;
//                }
//
//                if (this.matrizNumeros[1][j] >= this.matrizNumeros[2][j]) {
//                    this.matrizNumeros[2][j] = 0;
//                } else {
//                    this.matrizNumeros[1][j] = 0;
//                }
//
//                if (this.matrizNumeros[2][j] >= this.matrizNumeros[0][j]) {
//                    this.matrizNumeros[0][j] = 0;
//                } else {
//                    this.matrizNumeros[2][j] = 0;
//                }
//            }
//        }
//
//        // Este bucle lo que va a controlar es que no tengamos más de 5 número
//        // por filas. creamos dos bucles ya que se trata de una matriz.
////        for (int i = 0; i < this.matrizNumeros.length; i++) {
////            for (int j = 0; j < 4; j++) {
////                // Añadimos un atributo de tipo entero que genera un valor entre
////                // 0 y 8 
////                int tmp = alt.nextInt(9);
////                // En este bucle comprobaremos que ninguno de los valores sea 0
////                // Si es 0 volverá a generar otro número
////                
////                // NO FUNCIONA
//////                if  (this.matrizNumeros[0][j] == 0 && this.matrizNumeros[1][j] == 0 && this.matrizNumeros[2][j] == 0){
//////                        this.matrizNumeros[i][j] = 99;
//////                    } 
////                
////                while (this.matrizNumeros[i][tmp] == 0) {                    
////                    tmp = alt.nextInt(9);
////                }
////                // Una vez lo comprobamos que el valor no sea 0 el valor que salga 
////                // de manera Random volvera esa posición a 0 para no confundirla.
////                this.matrizNumeros[i][tmp] = 0;
////            }
////        }
        // Este bucle genera el cartón
        for (int[] matrizNumero : matrizNumeros) {
            for (int j = 0; j < matrizNumero.length; j++) {
                // Creamos una condicion para que cuando la matriz tenga como 
                // valor 0 se ponga texto en blanco con el método 
                // String.valueOf() 
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
