/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import BD.BingoDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        BingoDAO bingoDAO = new BingoDAO();
        String id;

        while (!salir) {
            try {
                System.out.println("------------------BIENBENIDO AL BINGO------------------");
                System.out.println("¿------------------DESEA JUAGAR?------------------"
                        + "\n1. Si" + "\n2. No");
                opciones = teclado.nextInt();
                switch (opciones) {
                    case 1:
                        do {
                            try {
                                System.out.println("------------------VAMOS A EMPEZAR------------------");
                                System.out.println("------------------¿QUE QUIERES HACER?------------------"
                                        + "\n1.PARTIDA NUEVA" + "\n2.CARGAR PARTIDA");
                                opciones = teclado.nextInt();
                                switch (opciones) {
                                    case 1:
                                        /*PARTIDA NUEVA*/
                                        System.out.println("------------------¿CÓMO TE LLAMAS?------------------");
                                        nombre = teclado.next();
                                        do {
                                            try {
                                                System.out.println("HOLA " + nombre + " ¿A QUE BINGO QUIERES JUGAR?" + "\n1.EUROPEO" + "\n2.AMERICANO");
                                                opciones = teclado.nextInt();
                                                switch (opciones) {
                                                    case 1:
                                                        System.out.println("------------------BINGO EUROPEO------------------");
                                                        BingoEuropeo bingoEuropeo = new BingoEuropeo(new CartonEuropeo(), new BomboEuropeo(), LocalDate.now(), nombre);

                                                        /*CONTROLAMOS QUE NO SE BORREN DATOS DE CADA PARTIDA*/
                                                        if (bingoDAO.mostrarDatosEuropeos().isEmpty()) {
                                                            bingoEuropeo.setId("EU_" + String.valueOf(bingoDAO.mostrarDatosEuropeos().size() + 1));
                                                        } else{
                                                            bingoEuropeo.setId("EU" +String.valueOf(bingoDAO.mostrarDatosEuropeos().size()) + 1);
                                                        }

                                                        bingoEuropeo.getBombo().llenarBombo();
                                                        System.out.println("________EL BOMBO SE HA LLENADO________");

                                                        bingoEuropeo.getCarton().generarCarton();
                                                        System.out.println("________ESTE ES TU CARTÓN________");

                                                        /*AÑADIMOS EL BINGO A LA BBDD*/
                                                        bingoDAO.partidaNueva(bingoEuropeo);

                                                        System.out.println(bingoEuropeo.getCarton().toString());

                                                        while (!bingoEuropeo.getCarton().esbingo() && !salir) {
                                                            try {
                                                                System.out.println("------------------¿QUE QUIERES HACER?------------------"
                                                                        + "\n1. SACAR BOLA" + "\n2. NÚMERO DE BOLAS QUE QUEDAN" + "\n3. COMPROBAR SI ESTA EL BOMBO VACIO"
                                                                        + "\n4. COMPROBAR LINEA" + "\n5. COMRPOBAR BINGO" + "\n6. SALIR");
                                                                opciones = teclado.nextInt();

                                                                switch (opciones) {
                                                                    case 1:
                                                                        System.out.println("EL " + bingoEuropeo.getCarton().tacharNumero(bingoEuropeo.getBombo().sacarBola()));
                                                                        System.out.println(bingoEuropeo.getCarton().toString());
                                                                        break;
                                                                    case 2:
                                                                        System.out.println(bingoEuropeo.getBombo().bolasDentro());
                                                                        break;
                                                                    case 3:
                                                                        System.out.println(bingoEuropeo.getBombo().vacio());
                                                                        break;
                                                                    case 4:
                                                                        if (bingoEuropeo.getCarton().esLinea(1) || bingoEuropeo.getCarton().esLinea(2) || bingoEuropeo.getCarton().esLinea(3)) {
                                                                            System.out.println("LINEA");
                                                                        } else {
                                                                            System.out.println("NO TIENES LINEAS");
                                                                        }
                                                                        break;
                                                                    case 5:
                                                                        if (!bingoEuropeo.getCarton().esbingo()) {
                                                                            System.out.println("NO TIENES BINGO");
                                                                        }
                                                                        break;
                                                                    case 6:
                                                                        System.out.println("GUARDANDO PARTIDA");
                                                                        bingoDAO.atualizarPartidaEuropea(bingoEuropeo.getId(), bingoEuropeo);
                                                                        salir = true;
                                                                        break;
                                                                    default:
                                                                        System.out.println("SOLO HAY SEIS OPCIONES");
                                                                }
                                                            } catch (InputMismatchException e) {
                                                                System.out.println("DEBE SER UN NÚMERO");
                                                                teclado.next();
                                                            }
                                                        }
                                                        /*Si el bingo a terminado se borrra*/
                                                        if (bingoEuropeo.getCarton().esbingo()) {
                                                            System.out.println("BINGO");
                                                            bingoDAO.atualizarPartidaEuropea(nombre, bingoEuropeo);
                                                            salir = true;
                                                        }

                                                        break;
                                                    case 2:
                                                        System.out.println("------------------BINGO AMERICANO------------------");
                                                        BingoAmericano bingoAmericano = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.now(), nombre);

                                                        /*CONTROLAMOS QUE NO SE BORREN DATOS DE CADA PARTIDA*/
                                                        if (bingoDAO.mostrarDatosAmericanos().isEmpty()) {
                                                            bingoAmericano.setId("USA_" + String.valueOf(bingoDAO.mostrarDatosAmericanos().size() + 1));
                                                        } else{
                                                            bingoAmericano.setId("USA_" + String.valueOf(bingoDAO.mostrarDatosAmericanos().size() + 1));
                                                        }

                                                        bingoAmericano.getBombo().llenarBombo();
                                                        System.out.println("________EL BOMBO SE HA LLENADO________");

                                                        bingoAmericano.getCarton().generarCarton();
                                                        System.out.println("________ESTE ES TU CARTÓN________");
                                                        System.out.println(bingoAmericano.getCarton().toString());

                                                        /*AÑADIMOS EL BINGO A LA BBDD*/
                                                        bingoDAO.partidaNueva(bingoAmericano);

                                                        while (!bingoAmericano.getCarton().esbingo() && !salir) {
                                                            try {
                                                                System.out.println("------------------¿QUE QUIERES HACER?------------------"
                                                                        + "\n1. SACAR BOLA" + "\n2. NÚMERO DE BOLAS QUE QUEDAN" + "\n3. COMPROBAR BOMBO"
                                                                        + "\n4. COMRPOBAR BINGO" + "\n5. SALIR");

                                                                opciones = teclado.nextInt();

                                                                switch (opciones) {
                                                                    case 1:
                                                                        /*SACAR BOLA*/
                                                                        System.out.println("EL " + bingoAmericano.getCarton().tacharNumero(bingoAmericano.getBombo().sacarBola()));
                                                                        System.out.println(bingoAmericano.getCarton().toString());
                                                                        break;
                                                                    case 2:
                                                                        /*NUM BOLAS*/
                                                                        System.out.println("QUEDAN " + bingoAmericano.getBombo().bolasDentro() + " BOLAS");
                                                                        break;
                                                                    case 3:
                                                                        /*COMPROBAR BOMBO*/
                                                                        if (bingoAmericano.getBombo().vacio()) {
                                                                            System.out.println("EL BOMBO ESTA VACIO");
                                                                        } else {
                                                                            System.out.println("EL BOMBO NO ESTA VACIO");
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        /*COMPROBAR BINGO*/
                                                                        if (!bingoAmericano.getCarton().esbingo()) {
                                                                            System.out.println("NO TIENES BINGO");
                                                                        }
                                                                        break;
                                                                    case 5:
                                                                        /*SALIR*/
                                                                        System.out.println("GUARDANDO PARTIDA");
                                                                        bingoDAO.atualizarPartidaAmericana(bingoAmericano.getId(), bingoAmericano);
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
                                                        /*Si el bingo a terminado se borrra*/
                                                        if (bingoAmericano.getCarton().esbingo()) {
                                                            System.out.println("BINGO");
                                                            bingoDAO.atualizarPartidaAmericana(nombre, bingoAmericano);
                                                            salir = true;
                                                        }
                                                        break;

                                                    default:
                                                        System.out.println("SOLO TIENES DOS OPCIONES");
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("DEBE SER UN NÚMERO");
                                                teclado.next();
                                            }
                                        } while (!salir);
                                        break;

                                    case 2:
                                        /*CARGAR PARTIDA*/
                                        do {
                                            try {
                                                System.out.println("------------------¿QUE BINGO QUIERES CARGAR?------------------"
                                                        + "\n1. EUROPEO" + "\n2. AMERICANO");
                                                opciones = teclado.nextInt();

                                                switch (opciones) {
                                                    case 1:
                                                        /* CARGAR ERUPEO*/
                                                        System.out.println("ESTOS SON LAS PARTIDAS GUARDADES DEL BINGO EUROPEO");
                                                        System.out.println(bingoDAO.mostrarDatosEuropeos());

                                                        System.out.println("¿QUÉ PAERTIDA QUIERES CARGAR?");
                                                        id = teclado.next();

                                                        boolean alt = false;

                                                        List<String> listaIDEuropea = new ArrayList<>();

                                                        for (int i = 0; i < bingoDAO.mostrarDatosEuropeos().size(); i++) {
                                                            listaIDEuropea.add(bingoDAO.mostrarDatosEuropeos().get(i).getId());
                                                        }

                                                        do {
                                                            if (!listaIDEuropea.contains(id)) {
                                                                System.out.println("PON UN VALOR CORRECTO");
                                                                id = teclado.next();
                                                            } else {
                                                                alt = true;
                                                            }
                                                        } while (!alt);

                                                        bingoDAO.cargarPartidaEuropeo(id);
                                                        BingoEuropeo copiaEU = new BingoEuropeo(bingoDAO.cargarPartidaEuropeo(id).getCarton(), bingoDAO.cargarPartidaEuropeo(id).getBombo(), bingoDAO.cargarPartidaEuropeo(id).getFecha(), bingoDAO.cargarPartidaEuropeo(id).getNombre());
                                                        System.out.println(copiaEU);
                                                        while (!copiaEU.getCarton().esbingo() && !salir) {
                                                            try {
                                                                System.out.println("------------------¿QUE QUIERES HACER?------------------"
                                                                        + "\n1. SACAR BOLA" + "\n2. NÚMERO DE BOLAS QUE QUEDAN" + "\n3. COMPROBAR SI ESTA EL BOMBO VACIO"
                                                                        + "\n4. COMPROBAR LINEA" + "\n5. COMRPOBAR BINGO" + "\n6. SALIR");
                                                                opciones = teclado.nextInt();

                                                                switch (opciones) {
                                                                    case 1:
                                                                        System.out.println("EL " + copiaEU.getCarton().tacharNumero(copiaEU.getBombo().sacarBola()));
                                                                        System.out.println(copiaEU.getCarton().toString());
                                                                        break;
                                                                    case 2:
                                                                        System.out.println(copiaEU.getBombo().bolasDentro());
                                                                        break;
                                                                    case 3:
                                                                        System.out.println(copiaEU.getBombo().vacio());
                                                                        break;
                                                                    case 4:
                                                                        if (copiaEU.getCarton().esLinea(1) || copiaEU.getCarton().esLinea(2) || copiaEU.getCarton().esLinea(3)) {
                                                                            System.out.println("LINEA ");
                                                                        } else {
                                                                            System.out.println("NO TIENES LINEAS");
                                                                        }
                                                                        break;
                                                                    case 5:
                                                                        if (!copiaEU.getCarton().esbingo()) {
                                                                            System.out.println("NO TIENES BINGO");
                                                                        }
                                                                        break;
                                                                    case 6:
                                                                        System.out.println("GUARDANDO PARTIDA");
                                                                        bingoDAO.atualizarPartidaEuropea(id, copiaEU);
                                                                        salir = true;
                                                                        break;
                                                                    default:
                                                                        System.out.println("SOLO HAY SEIS OPCIONES");
                                                                }
                                                            } catch (NullPointerException e) {
                                                                System.out.println("DEBE SER UN NÚMERO");
                                                                teclado.next();
                                                            }
                                                        }
                                                        /*Si se canta bingo se borra de la bbdd */

                                                        if (copiaEU.getCarton().esbingo()) {
                                                            System.out.println("BINGO");
                                                            bingoDAO.atualizarPartidaEuropea(id, copiaEU);
                                                            salir = true;
                                                        }
                                                        break;
                                                    case 2:
                                                        /*CARGAR AMERICANO */
                                                        System.out.println("ESTOS SON LAS PARTIDAS GUARDADES DEL BINGO AMERICANO");
                                                        System.out.println(bingoDAO.mostrarDatosAmericanos());

                                                        System.out.println("¿QUÉ PAERTIDA QUIERES CARGAR?");
                                                        id = teclado.next();

                                                        boolean tmp = false;
                                                        List<String> listaIDAmericana = new ArrayList<>();

                                                        for (int i = 0; i < bingoDAO.mostrarDatosAmericanos().size(); i++) {
                                                            listaIDAmericana.add(bingoDAO.mostrarDatosAmericanos().get(i).getId());
                                                        }

                                                        do {
                                                            if (!listaIDAmericana.contains(id)) {
                                                                System.out.println("PON UN VALOR CORRECTO");
                                                                id = teclado.next();
                                                            } else {
                                                                tmp = true;
                                                            }
                                                        } while (!tmp);

                                                        bingoDAO.cargarPartidaAmericano(id);
                                                        BingoAmericano copiaAM = new BingoAmericano(bingoDAO.cargarPartidaAmericano(id).getCarton(), bingoDAO.cargarPartidaAmericano(id).getBombo(), bingoDAO.cargarPartidaAmericano(id).getFecha(), id);
                                                        System.out.println(copiaAM);

                                                        while (!copiaAM.getCarton().esbingo() && !salir) {
                                                            try {
                                                                System.out.println("------------------¿QUE QUIERES HACER?------------------"
                                                                        + "\n1. SACAR BOLA" + "\n2. NÚMERO DE BOLAS QUE QUEDAN" + "\n3. COMPROBAR BOMBO"
                                                                        + "\n4. COMRPOBAR BINGO" + "\n5. SALIR");

                                                                opciones = teclado.nextInt();

                                                                switch (opciones) {
                                                                    case 1:
                                                                        /*SACAR BOLA*/
                                                                        System.out.println("EL " + copiaAM.getCarton().tacharNumero(copiaAM.getBombo().sacarBola()));
                                                                        System.out.println(copiaAM.getCarton().toString());
                                                                        break;
                                                                    case 2:
                                                                        /*NUM BOLAS*/
                                                                        System.out.println("QUEDAN " + copiaAM.getBombo().bolasDentro() + " BOLAS");
                                                                        break;
                                                                    case 3:
                                                                        /*COMPROBAR BOMBO*/
                                                                        if (copiaAM.getBombo().vacio()) {
                                                                            System.out.println("EL BOMBO ESTA VACIO");
                                                                        } else {
                                                                            System.out.println("EL BOMBO NO ESTA VACIO");
                                                                        }
                                                                        break;
                                                                    case 4:
                                                                        /*COMPROBAR BINGO*/
                                                                        if (!copiaAM.getCarton().esbingo()) {
                                                                            System.out.println("NO TIENES BINGO");
                                                                        }
                                                                        break;
                                                                    case 5:
                                                                        /*SALIR*/
                                                                        System.out.println("GUARDANDO PARTIDA");
                                                                        bingoDAO.atualizarPartidaAmericana(id, copiaAM);
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
                                                        /*Si se canta bingo se borra de la bbdd */
                                                        if (copiaAM.getCarton().esbingo()) {
                                                            System.out.println("BINGO");
                                                            bingoDAO.atualizarPartidaAmericana(id, copiaAM);
                                                            salir = true;
                                                        }

                                                        break;

                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("DEBE SER UN NÚMERO");
                                                teclado.next();
                                            }
                                        } while (!salir);
                                        break;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("DEBE SER UN NÚMERO");
                                teclado.next();
                            }
                        } while (!salir);
                        break;

                    case 2:
                        salir = true;
                        break;
                    default:
                        System.out.println("SOLO TENEMOS DOS OPCIONES");
                }
            } catch (InputMismatchException e) {
                System.out.println("DEBE SER UN NÚMERO");
                teclado.next();
            }
        }

        System.out.println(
                "GRACIAS POR JUGAR");
    }
}
