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
public class CartonEuropeo extends Carton {
    
    static public final int FILAS = 3;
    static public final int COLUMNAS = 9;

    public CartonEuropeo(int filas, int columnas) {
        super(filas, columnas);
    }
    
    @Override
    public void generarCarton(){
    
    }

    @Override
    public String toString() {
        return "CartonEuropeo{" + '}';
    }
    
}
