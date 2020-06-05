/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BingoAmericano;

import java.time.LocalDate;

/**
 *
 * @author herma
 */
public abstract class Bingo  {
    /*Atributos*/
    private String id;
    private LocalDate fecha;
    private String nombre;
    
    /*Constructor*/
    public Bingo(LocalDate fecha, String nombre) {
        this.id = "B" + 0; /*Lo ponemos así para que cuando creemos uno temporar se cree siempre con el ID B0*/
        this.fecha = fecha;
        this.nombre = nombre;
    }
    
    /*Getter & Setter*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    /*toString*/
    @Override
    public String toString() {
        return "\nID: " + id + "\nFECHA: " + fecha + "\nNOMBRE: " + nombre;
    }
    
}
