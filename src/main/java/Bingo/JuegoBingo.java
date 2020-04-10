/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;


/**
 *
 * @author aida
 */
public class JuegoBingo {

    public static void main(String[] args) {
        Bombo bombo = new Bombo();
        bombo.llenarBombo();
        Carton carton = new Carton();
        carton.generarCarton();
        System.out.println("----------------------------------------");
        for (int i = 0; i < 90; i++) {           
            carton.mostrarCarton();
            carton.tacharCasilla(bombo.sacarBola());
            bombo.numeroDeBolas();
        }

//        Carton carton = new Carton();
//        for (int i = 0; i < 10; i++) {
//            carton.generarCarton();
//        }
//        carton.generarCarton();
//        carton.generarCarton();
//        carton.generarCarton();



    }
}
