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

    private ArrayList<Integer> lista; // ArrayList donde iran las bolas
    private int numBolas; // Número entero de bolas que tendrá el bingo 

    // Constructor sin parametros que inicializamos la lista, el contador y 
    // el núemor de bolas que vamos a tener en el bombo
    public Bombo() {
        this.lista = new ArrayList<>();
        this.numBolas = 90;
    }

    // Métedo público para llenar el bombo de bolas
    public void llenarBombo() {
        // Aqui indicamos que si el contador es igual a 0 se llena el bombo
        // pero si sacamos bolas y después llenamos otra vez el bombo nos 
        // indicara que el bombo ya estaba lleno. Hasta que no termine de 
        // sacara bolas, no se volvera a poder rellenarse
        if (this.numBolas == 90) {
            for (int i = 1; i <= this.numBolas; i++) {
                this.lista.add(i);
            }
            // Mensaje para indicar que bombo se ha llenado
            System.out.println("EL BOMBO SE HA LLENO");
        } else {
            System.out.println("EL BOMBO YA ESTABA LLENO");
        }
    }
    
    // Método de tipo entero para sacar bolas del bombo.
    public int sacarBola() {
        // Creamos un atributo Random(llamado, atl) y un número entero
        // para saber la posición de la bola
        Random alt = new Random();
        int posicion = 0;
        // Si el contador es distinto al número de bolas indicará 
        // que no quedan bolas
        if (this.numBolas != 0) {
            // La posición se va a crear con un número aleatorio con los números 
            // de bolas (this.numBolas) que va a eliminar despues de la lista
            posicion = (int) lista.remove(alt.nextInt(this.numBolas));
            // Despues vamos a restar 
            this.numBolas--;
        } else {
            //Este texto sale cuando seab terminado las bolas.
            System.out.println("NO QUEDAN BOLAS");
            // Se volverá a inicializar a 0 el contador
        }
        return posicion;
    }

    // Método publico para saber cuantas bolas quedan por salir.
    public void numeroDeBolas() {
        // Si el contador no es igual al numero de bolas que hay en la lista 
        if (this.numBolas == 0) {
            // Nos mostrará este texto.
            System.out.println("NO QUEDAN BOLAS");
        } else {
            // Si el contador no es igual al numero de bolas que hay en la lista
            // mostrará este mensaje en el que calculamos el número de bolas que faltan.
            System.out.println("Quedan " + this.numBolas);
        }
    }

    // To String para mostrar la lista de bolas.
    @Override
    public String toString() {
        return "Bombo{" + "bolas=" + lista + '}';
    }

}
