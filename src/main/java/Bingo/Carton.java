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

//           Método burbuja
//                for (int i = 0; i < numeros.length - 1; i++) {
//                    for (int j = i + 1; j < numeros.length; j++) {
//                        if (numeros[i] > numeros[j]) {
//                            tmp = numeros[i];
//                            numeros[i] = numeros[j];
//                            numeros[j] = tmp;
//                        }
//                    }
//                }
                System.out.print("\033[34m" + " | " + matrizNumeros[i][j] + " | ");
            }
            System.out.println("");
            System.out.println("\033[34m" + "------------------------------------------------------------------------");
        }

    }

}
