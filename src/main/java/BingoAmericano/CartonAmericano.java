/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.util.Random;

/**
 *
 * @author herma
 */
public final class CartonAmericano extends Carton {

    static public final int FILAS = 5;
    static public final int COLUMNAS = 5;
    Patron premio;

    public CartonAmericano() {
        super(FILAS, COLUMNAS);
        this.premio = getPatron();
        generarCarton();
    }

    public Patron getPatron() {
        Random aletorio = new Random();
        int numero = aletorio.nextInt(5) + 1;

        switch (numero) {
            case 1:
                return Patron.PATRON_C;
            case 2:
                return Patron.PATRON_E;
            case 3:
                return Patron.PATRON_F;
            case 4:
                return Patron.PATRON_O;
            default:
                return Patron.PATRON_U;
        }
    }

    @Override
    public void generarCarton() {
        Random alt = new Random();
        int numero;

        for (int i = 0; i < this.premio.getCasillas().size(); i++) {
            super.getMatriz()[(int) this.premio.getCasillas().get(i).getX()][(int) this.premio.getCasillas().get(i).getY()] = 99;
        }

        for (int i = 0; i < super.getMatriz().length; i++) {
            for (int j = 0; j < super.getMatriz()[i].length; j++) {

                if (super.getMatriz()[i][j] == 99) {

                    switch (j) {
                        case 0:
                            do {
                                numero = alt.nextInt(15) + 1;
                            } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j] || numero == super.getMatriz()[3][j] || numero == super.getMatriz()[4][j]);
                            super.getMatriz()[i][0] = numero;
                            break;
                        case 1:
                            do {
                                numero = alt.nextInt(15) + 15;
                            } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j] || numero == super.getMatriz()[3][j] || numero == super.getMatriz()[4][j]);
                            super.getMatriz()[i][1] = numero;
                            break;
                        case 2:
                            do {
                                numero = alt.nextInt(45 - 31 + 1) + 31;
                            } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j] || numero == super.getMatriz()[3][j] || numero == super.getMatriz()[4][j]);
                            super.getMatriz()[i][2] = numero;
                            break;
                        case 3:
                            do {
                                numero = alt.nextInt(61 - 46) + 46;
                            } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j] || numero == super.getMatriz()[3][j] || numero == super.getMatriz()[4][j]);
                            super.getMatriz()[i][3] = numero;
                            break;
                        case 4:
                            do {
                                numero = alt.nextInt(75 - 61) + 61;
                            } while (numero == super.getMatriz()[0][j] || numero == super.getMatriz()[1][j] || numero == super.getMatriz()[2][j] || numero == super.getMatriz()[3][j] || numero == super.getMatriz()[4][j]);
                            super.getMatriz()[i][4] = numero;
                            break;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        String titulo = ("\033[34m  B       I       N       G       O");
        String carton = "\n";
        for (int i = 0; i < this.getMatriz().length; i++) {
            for (int j = 0; j < this.getMatriz()[i].length; j++) {
                switch (super.getMatriz()[i][j]) {
                    case 0:
                        carton += ("\033[34m|" + "  " + "|\t");
                        break;
                    case 99:
                        carton += ("\033[34m||" + "\033[31mX" + "\033[34m||\t");
                        break;
                    default:
                        carton += "\033[34m|" + this.getMatriz()[i][j] + "|\t";
                        break;
                }
            }
            carton += "\n";
        }

        return titulo + carton;
    }
}
