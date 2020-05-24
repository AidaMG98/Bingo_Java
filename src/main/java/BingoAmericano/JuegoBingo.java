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

        while (!salir) {
            try {
                System.out.println("------------------BIENBENIDO AL BINGO------------------");
                System.out.println("¿------------------DESEA JUAGAR?------------------"
                        + "\n1. Si" + "\n2. No");
                opciones = teclado.nextInt();
                switch (opciones) {
                    case 1:
                        System.out.println("------------------VAMOS A EMPEZAR------------------");
                        System.out.println("¿A que bingo jugamos?" + "\n1. Europeo" + "\n2. Americano");

                        opciones = teclado.nextInt();

                        switch (opciones) {
                            case 1:

                                BomboEuropeo bomboEurope = new BomboEuropeo();
                                bomboEurope.llenarBombo();
                                System.out.println("SE HA LLENADO EL BOMBO");
                                
                                CartonEuropeo cartonEuropeo = new CartonEuropeo();
                                Bingo aida = new BingoEuropeo(cartonEuropeo, bomboEurope, "EUROPEO_1", LocalDate.now(), "Aida");
                                System.out.println("Y ESTE ES TU CARTÓN");
                                System.out.println(cartonEuropeo.toString());
                                while (cartonEuropeo.esbingo() == false) {
                                    try {
                                        System.out.println("------------------¿QUE QUIERES HACER?------------------"
                                                + "\n1. SACAR BOLA" + "\n2. NÚMERO DE BOLAS QUE QUEDAN" + "\n3. COMPROBAR BOMBO"
                                                + "\n4. COMPROBAR LINEA" + "\n5. COMRPOBAR BINGO");

                                        opciones = teclado.nextInt();

                                        switch (opciones) {
                                            case 1:
                                                System.out.println("EL " + cartonEuropeo.tacharNumero(bomboEurope.sacarBola()));
                                                System.out.println(cartonEuropeo.toString());
                                                break;
                                            case 2:
                                                System.out.println("QUEDAN " + bomboEurope.bolasDentro() + " BOLAS");
                                                break;
                                            case 3:
                                                if (bomboEurope.vacio() == true) {
                                                    System.out.println("EL BOMBO ESTA VACIO");
                                                } else {
                                                    System.out.println("EL BOMBO NO ESTA VACIO");
                                                }
                                                break;
                                            case 4:
                                                if (cartonEuropeo.esLinea(1) == true || cartonEuropeo.esLinea(2) == true || cartonEuropeo.esLinea(3) == true) {
                                                    System.out.println("LINEA");
                                                } else {
                                                    System.out.println("NO TIENES LINEA");
                                                }
                                                break;
                                            case 5:
                                                if (cartonEuropeo.esbingo() != true) {
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
                                System.out.println(cartonEuropeo.toString());
                                break;
                            case 2:
                                BingoAmericano bingoAmericano = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), "123", LocalDate.now(), "Aida");
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
                    case 2:
                        salir = true;
                        break;
                    default:
                        System.out.println("SOLO HAY DOS OPCIONES");
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
}
