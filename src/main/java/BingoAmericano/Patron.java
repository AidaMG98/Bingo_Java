/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author herma
 */
public enum Patron {
    PATRON_F(cartonF(), "Cartón con una F"),
    PATRON_C(cartonC(), "Cartón con una C"),
    PATRON_E(cartonE(), "Cartón con una E"),
    PATRON_U(cartonU(), "Cartón con una U"),
    PATRON_O(cartonO(), "Cartón con una O");

    /* Atributos*/
    private final ArrayList<Point> casillas;
    private final String descripcion;

    /*Constructor*/
    private Patron(ArrayList<Point> casillas, String descripcion) {
        this.casillas = casillas;
        this.descripcion = descripcion;
    }

    /*Getter*/
    public ArrayList<Point> getCasillas() {
        return casillas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    /*toString*/
    @Override
    public String toString() {
        return "Patron{" + "casillas=" + casillas + ", descripcion=" + descripcion + '}';
    }

    /*Método para generar el patron F*/
    private static ArrayList<Point> cartonF() {
        ArrayList<Point> aux = new ArrayList<>();

        aux.add(new Point(0, 0));
        aux.add(new Point(0, 1));
        aux.add(new Point(0, 2));
        aux.add(new Point(0, 3));
        aux.add(new Point(0, 4));

        aux.add(new Point(1, 0));

        aux.add(new Point(2, 0));
        aux.add(new Point(2, 1));
        aux.add(new Point(2, 2));

        aux.add(new Point(3, 0));

        aux.add(new Point(4, 0));

        return aux;
    }

    /*Método para generar el patron C*/
    private static ArrayList<Point> cartonC() {
        ArrayList<Point> aux = new ArrayList<>();

        aux.add(new Point(0, 0));
        aux.add(new Point(0, 1));
        aux.add(new Point(0, 2));
        aux.add(new Point(0, 3));
        aux.add(new Point(0, 4));

        aux.add(new Point(1, 0));

        aux.add(new Point(2, 0));

        aux.add(new Point(3, 0));

        aux.add(new Point(4, 0));
        aux.add(new Point(4, 1));
        aux.add(new Point(4, 2));
        aux.add(new Point(4, 3));
        aux.add(new Point(4, 4));

        return aux;
    }

    /*Método para generar el patron E*/
    private static ArrayList<Point> cartonE() {
        ArrayList<Point> aux = new ArrayList<>();

        aux.add(new Point(0, 0));
        aux.add(new Point(0, 1));
        aux.add(new Point(0, 2));
        aux.add(new Point(0, 3));
        aux.add(new Point(0, 4));

        aux.add(new Point(1, 0));

        aux.add(new Point(2, 0));
        aux.add(new Point(2, 1));
        aux.add(new Point(2, 2));

        aux.add(new Point(3, 0));

        aux.add(new Point(4, 0));
        aux.add(new Point(4, 1));
        aux.add(new Point(4, 2));
        aux.add(new Point(4, 3));
        aux.add(new Point(4, 4));

        return aux;
    }

    /*Método para generar el patron O*/
    private static ArrayList<Point> cartonO() {
        ArrayList<Point> aux = new ArrayList<>();

        aux.add(new Point(0, 0));
        aux.add(new Point(0, 1));
        aux.add(new Point(0, 2));
        aux.add(new Point(0, 3));
        aux.add(new Point(0, 4));

        aux.add(new Point(1, 0));
        aux.add(new Point(1, 4));
        
        aux.add(new Point(2, 0));
        aux.add(new Point(2, 4));

        aux.add(new Point(3, 0));
        aux.add(new Point(3, 4));

        aux.add(new Point(4, 0));
        aux.add(new Point(4, 1));
        aux.add(new Point(4, 2));
        aux.add(new Point(4, 3));
        aux.add(new Point(4, 4));

        return aux;
    }
    
    /*Método para generar el patron U*/
    private static ArrayList<Point> cartonU() {
        ArrayList<Point> aux = new ArrayList<>();

        aux.add(new Point(0, 0));
        aux.add(new Point(0, 4));

        aux.add(new Point(1, 0));
        aux.add(new Point(1, 4));
        
        aux.add(new Point(2, 0));
        aux.add(new Point(2, 4));

        aux.add(new Point(3, 0));
        aux.add(new Point(3, 4));

        aux.add(new Point(4, 0));
        aux.add(new Point(4, 1));
        aux.add(new Point(4, 2));
        aux.add(new Point(4, 3));
        aux.add(new Point(4, 4));

        return aux;
    }    

}
