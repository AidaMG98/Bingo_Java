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
    private String id;
    private LocalDate fecha;
    private String nombre;

    public Bingo(String id, LocalDate fecha, String nombre) {
        this.id = id;
        this.fecha = fecha;
        this.nombre = nombre;
    }

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

    @Override
    public String toString() {
        return "Bingo{" + "id=" + id + ", fecha=" + fecha + ", nombre=" + nombre + '}';
    }
    
}
