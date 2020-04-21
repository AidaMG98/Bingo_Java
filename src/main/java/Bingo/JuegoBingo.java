/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bingo;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author aida
 */
public class JuegoBingo {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        //  Hemos creado un atributo Scanner para pedir valores al usuario
        Scanner teclado = new Scanner(System.in);
        //  Un valor para salir del juego
        boolean salir = false;
        //  Un valor para elegir la opción
        int opciones = 0;

        // Hemos creado un bucle para que se repita todas las veces que quieras jugar
        while (!salir) {
            try {
                // Lo primero que hace es preguntar si queremos jugar 
                System.out.println("------------------BIENBENIDO AL BINGO------------------");
                System.out.println("¿------------------DESEA JUAGAR?------------------"
                        + "\n1. Si" + "\n2. No");
                opciones = teclado.nextInt();
                //  Hemos creado un switch con dos opciones para que el usuario escoga.
                switch (opciones) {
                    //  En el caso 1 se empezará a crear las clases bombo y carton
                    case 1:
                        System.out.println("------------------VAMOS A EMPEZAR------------------");
                        Bombo bombo = new Bombo();
                        Carton carton = new Carton();
                        // Se llenará el bombo
                        bombo.llenarBombo();
                        try {
                            //  Después genera el cartón
                            System.out.println("EL CARTÓN GENERADO ES ESTE: ");
                            carton.generarCarton();
                            carton.mostrarCarton();
                            do {
                                try {
                                    //  Si no nos gusta podremos generar otro 
                                    System.out.println("------------------¿QUIERES OTRO CARTÓN?------------------"
                                            + "\n1. SI" + "\n2. NO");
                                    opciones = teclado.nextInt();

                                    switch (opciones) {
                                        case 1:
                                            System.out.println("EL CARTÓN NUEVO ES ESTE: ");
                                            carton.generarCarton();
                                            carton.mostrarCarton();
                                        case 2:
                                            break;
                                        default:
                                            System.out.println("SOLO HAY DOS OPSICONES");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("DEBE SER UN NÚMERO");
                                    teclado.next();
                                }
                            } while (opciones != 2);
                        } catch (InputMismatchException e) {
                            System.out.println("DEBE SER UN NÚMERO");
                            teclado.next();
                        }
                        //  Luego se genera un bucle hasta que se haga bingo
                        while (carton.comprobarBingo() == false) {
                            try {
                                System.out.println("------------------¿QUE QUIERES HACER?------------------"
                                        + "\n1. SACAR BOLA" + "\n2. NÚMERO DE BOLAS QUE QUEDAN" + "\n3. MOSTRAR CARTÓN"
                                        + "\n4. COMPROBAR LINEA" + "\n5. COMRPOBAR BINGO");
                                opciones = teclado.nextInt();
                                //  Podremos eleguir que hacemos escribiendo el número con el que es asociado
                                switch (opciones) {
                                    case 1:
                                        carton.tacharCasilla(bombo.sacarBola());
                                        break;
                                    case 2:
                                        bombo.numeroDeBolas();
                                        break;
                                    case 3:
                                        carton.mostrarCarton();
                                        break;
                                    case 4:
                                        carton.comprobarLinea();
                                        break;
                                    case 5:
                                        carton.comprobarBingo();
                                        break;
                                    default:
                                        System.out.println("SOLO HAY CINCO OPCIONES");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("DEBE SER UN NÚMERO");
                                teclado.next();
                            }
                        }
                        break;
                    //  La segunda opción es que no quieras jugar más y se cierra la partida
                    case 2:
                        salir = true;
                        break;
                    default:
                        System.out.println("SOLO HAY DOS OPCIONES");
                }
            } catch (InputMismatchException e) {
                System.out.println("DEBE SER UN NÚMERO");
                teclado.next();
            }
        }
        System.out.println("MUCHAS GRACIAS POR LA VISTA");
    }
}
