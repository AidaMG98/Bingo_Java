/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

/**
 *
 * @author herma
 */
public class CartonAmericano extends Carton {

    static public final int FILAS = 5;
    static public final int COLUMNAS = 5;
    Patron premio;

    public CartonAmericano(Patron premio, int filas, int columnas) {
        super(filas, columnas);
        this.premio = premio;
    }
    
    @Override
    public void generarCarton(){
    
    }
    
    public Patron getPatron(){
        return null;
    
    }

    @Override
    public String toString() {
        return "CartonAmericano{" + "premio=" + premio + '}';
    }

}
