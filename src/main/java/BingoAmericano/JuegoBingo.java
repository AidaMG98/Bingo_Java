/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author herma
 */
public class JuegoBingo {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opciones;
        String nombre;

        while (!salir) {
            try {
                System.out.println("------------------BIENBENIDO AL BINGO------------------");
                System.out.println("¿------------------¿QUIERES JUAGAR?------------------"
                        + "\n1. Si" + "\n2. No");
                opciones = teclado.nextInt();
                switch (opciones) {
                    case 1:
                        /*JUGAR*/
                        System.out.println("------------------¿QUE QUIERES HACER?------------------"
                                + "\n1.PARTIDA NUEVA" + "\n2.CARGAR PARTIDA");
                        opciones = teclado.nextInt();
                        switch (opciones) {
                            case 1:
                                /*PARTIDA NUEVA*/
                                System.out.println("------------------¿CÓMO TE LLAMAS?------------------");
                                nombre = teclado.next();

                                System.out.println("------------------VAMOS A EMPEZAR------------------");
                                System.out.println("------------------¿A QUE BINGO JUGAMOS?------------------"
                                        + "\n1.EUROPEO" + "\n2.AMERICANO");
                                opciones = teclado.nextInt();
                                switch (opciones) {
                                    case 1:
                                        /*BINGO EUROPEO*/
                                        BomboEuropeo bomboEurope = new BomboEuropeo();
                                        bomboEurope.llenarBombo();
                                        System.out.println("------------------SE HA LLENADO EL BOMBO------------------");

                                        CartonEuropeo cartonEuropeo = new CartonEuropeo();
                                        Bingo bingo1 = new BingoEuropeo(cartonEuropeo, bomboEurope, LocalDate.now(), nombre);

                                        System.out.println("------------------Y ESTE ES TU CARTÓN------------------");
                                        System.out.println(cartonEuropeo.toString());
                                        
                                        while (!cartonEuropeo.esbingo()  && !salir) {
                                            try {
                                                System.out.println("------------------¿QUE QUIERES HACER?------------------"
                                                        + "\n1. SACAR BOLA" + "\n2. NÚMERO DE BOLAS QUE QUEDAN" + "\n3. COMPROBAR BOMBO"
                                                        + "\n4. COMPROBAR LINEA" + "\n5. COMRPOBAR BINGO" + "\n6. SALIR");
                                                opciones = teclado.nextInt();

                                                switch (opciones) {
                                                    case 1: /*SACAR BOLA*/
                                                        System.out.println("EL " + cartonEuropeo.tacharNumero(bomboEurope.sacarBola()));
                                                        System.out.println(cartonEuropeo.toString());
                                                        break;
                                                    case 2: /* NÚMERO DE BOLAS*/
                                                        System.out.println("QUEDAN " + bomboEurope.bolasDentro() + " BOLAS");
                                                        break;
                                                    case 3: /*COMPROBAR BOMBO*/
                                                        System.out.println(bomboEurope.vacio());
                                                        break;
                                                    case 4: /*COMPROBAR LINEA*/
                                                        if (cartonEuropeo.esLinea(1) == true || cartonEuropeo.esLinea(2) == true || cartonEuropeo.esLinea(3) == true) {
                                                            System.out.println("LINEA");
                                                        } else {
                                                            System.out.println("NO TIENES LINEA");
                                                        }
                                                        break;
                                                    case 5: /*COMPROBAR BINGO*/
                                                        if (cartonEuropeo.esbingo() != true) {
                                                            System.out.println("NO TIENES BINGO");
                                                        }
                                                        break;
                                                    case 6: /*SALIR*/
                                                        salir = true;
                                                        break;
                                                    default:
                                                        System.out.println("SOLO HAY CINCO OPCIONES");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("DEBE SER UN NÚMERO");
                                                teclado.next();
                                            }
                                        }
                                        System.out.println("------------------TU CARTÓN------------------");
                                        System.out.println(cartonEuropeo.toString());
                                        break;
                                    case 2: /*BINGO AMERICANO*/
                                        BingoAmericano bingoAmericano = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.now(), "Aida");
                                        System.out.println("SE HA LLENADO EL BOMBO");
                                        System.out.println("Y ESTE ES TU CARTÓN");
                                        System.out.println(bingoAmericano.getCarton().toString());
                                        while (bingoAmericano.getCarton().esbingo() == false) {
                                            try {
                                                System.out.println("------------------¿QUE QUIERES HACER?------------------"
                                                        + "\n1. SACAR BOLA" + "\n2. NÚMERO DE BOLAS QUE QUEDAN" + "\n3. COMPROBAR BOMBO"
                                                        + "\n4. COMRPOBAR BINGO");

                                                opciones = teclado.nextInt();

                                                switch (opciones) {
                                                    case 1:
                                                        System.out.println("EL " + bingoAmericano.getCarton().tacharNumero(bingoAmericano.getBombo().sacarBola()));
                                                        System.out.println(bingoAmericano.getCarton().toString());
                                                        break;
                                                    case 2:
                                                        System.out.println("QUEDAN " + bingoAmericano.getBombo().bolasDentro() + " BOLAS");
                                                        break;
                                                    case 3:
                                                        if (bingoAmericano.getBombo().vacio() == true) {
                                                            System.out.println("EL BOMBO ESTA VACIO");
                                                        } else {
                                                            System.out.println("EL BOMBO NO ESTA VACIO");
                                                        }
                                                        break;
                                                    case 4:
                                                        if (bingoAmericano.getCarton().esbingo() != true) {
                                                            System.out.println("NO TIENES BINGO");
                                                        }
                                                        break;
                                                    default:
                                                        System.out.println("SOLO HAY CINCO OPCIONES");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("DEBE SER UN NÚMERO");
                                                teclado.next();
                                            }
                                        }
                                        System.out.println("BINGO...!!");
                                        System.out.println(bingoAmericano.getCarton().toString());
                                        break;
                                    default:
                                        System.out.println("SOLO HAY DOS OPCIONES");
                                        ;
                                }
                                break;
                            case 2:
                                /*CARGAR PARTIDA */
                                System.out.println("------------------¿CUAL ES TU ID?------------------");
                                /* AUN NO ESTA MONTADO */
                                break;
                            default:
                                System.out.println("SOLO TENEMOS DOS OPCIONES");
                                teclado.next();
                        }
                        break;
                    case 2:
                        /*NO JUGAR*/
                        salir = true;
                        break;
                    default:
                        System.out.println("SOLO TENEMOS DOS OPCIONES");
                        teclado.next();
                }
            } catch (InputMismatchException e) {
                System.out.println("DEBE SER UN NÚMERO");
                teclado.next();
            }
        }

        System.out.println(
                "MUCHAS GRACIAS POR LA VISTA");
    }
    
    public void seleccinarOpcionBingo(){
    
    }
}
