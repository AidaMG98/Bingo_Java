/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author aida
 */
public class Bombo {

    private final ArrayList<Integer> lista; // ArrayList donde iran las bolas
    private final int numBolas; // Número entero de bolas que tendrá el bingo 
    private int contador; // Número de entro para saber las bolas que quedan

    // Constructor sin parametros que inicializamos la lista, el contador y 
    // el núemor de bolas que vamos a tener en el bombo
    public Bombo() {
        this.lista = new ArrayList<>();
        this.contador = 0;
        this.numBolas = 90;
    }

    // Métedo público para llenar el bombo de bolas
    public void llenarBombo() {
        // Aqui indicamos que si el contador es igual a 0 se llena el bombo
        // pero si sacamos bolas y después llenamos otra vez el bombo nos 
        // indicara que el bombo ya estaba lleno. Hasta que no termine de 
        // sacara bolas, no se volvera a poder rellenarse
        if (this.contador == 0) {
            for (int i = 1; i <= this.numBolas; i++) {
                this.lista.add(i);
            }
            // Mensaje para indicar que bombo se ha llenado
            System.out.println("EL BOMBO SE HA LLENO");
        } else {
            System.out.println("EL BOMBO YA ESTABA LLENO");
        }
    }

    // Método publico para sacar bolas del bombo.
    public void sacarBola() {
        // Creamos un atributo Random(llamado, atl) y un número entero
        // para saber la posición de la bola
        Random alt = new Random();
        int posicion;
        // Si el contador es distinto al número de bolas indicará 
        // que no quedan bolas
        if (this.contador != this.numBolas) {
            // Aqui tenemos un bucle para indicar que si la posicion es mayor al
            // tamaño de la lista que saque otro número.
            do {
                // La posición se va a crear con un número aleatorio con los números 
                // de bolas (this.numBolas).
                posicion = alt.nextInt(this.numBolas);
            } while (posicion >= this.lista.size());
            
            // Aquí mostramos el número que ha salido.
            System.out.println(this.lista.get(posicion));
            // Y despúes lo eliminamos de la lista.
            this.lista.remove(posicion);
            contador++; 
        } else {
            // Este texto sale cuando seab terminado las bolas.
            System.out.println("NO QUEDAN BOLAS");
            // Se volverá a inicializar el contador a 0
            contador = 0;
        }

    }
    // Método publico para saber cuantas bolas quedan por salir.
    public void numeroDeBolas() {
        // Si el contador no es igual al numero de bolas que hay en la lista 
        if (this.contador == this.numBolas) {
            // Nos mostrará este texto.
            System.out.println("NO QUEDAN BOLAS");
        } else {
            // Si el contador no es igual al numero de bolas que hay en la lista
            // mostrará este mensaje en el que calculamos el número de bolas que faltan.
            System.out.println("Quedan " + (this.numBolas - this.contador));
        }
    }
    
    // To String para mostrar la lista de bolas.
    @Override
    public String toString() {
        return "Bombo{" + "bolas=" + lista + '}';
    }

}
