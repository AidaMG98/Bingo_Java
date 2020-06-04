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
    
    // Método para actualizar una partida 
    int atualizarPartida(String id, Bingo bingo);
    
    // Método para generar partida guardada
    BingoAmericano cargarPartidaAmericano(String id);
    
    BingoEuropeo cargarPartidaEuropeo(String id);

    // Método para insertar una nueva partida de bingo
    int partidaNueva(Bingo nuevo);

    // Método para borrar una partida del bingo
    int borrarPartida(Bingo borrar);

}
