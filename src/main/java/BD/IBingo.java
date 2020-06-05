/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import BingoAmericano.*;
import java.util.List;

/**
 *
 * @author herma
 */
public interface IBingo {
    
    // Método para mostrar todas las partidas guardadas
    List<BingoAmericano> mostrarDatosAmericanos();
    
    List<BingoEuropeo> mostrarDatosEuropeos();
    
    // Método para actualizar una partida Americana 
    int atualizarPartidaAmericana(String id, BingoAmericano bingo);
    
    // Método para actualizar una partida Europea
    int atualizarPartidaEuropea(String id, BingoEuropeo bingo);
    
    // Método para generar partida guardada Americana
    BingoAmericano cargarPartidaAmericano(String id);
    
    // Método para generar partida guardada Europea
    BingoEuropeo cargarPartidaEuropeo(String id);

    // Método para insertar una nueva partida de bingo
    int partidaNueva(Bingo nuevo);

    // Método para borrar una partida del bingo
//    int borrarPartida(Bingo borrar);

}
