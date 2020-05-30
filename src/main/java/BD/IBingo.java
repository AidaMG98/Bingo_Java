/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import BingoAmericano.Bingo;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author herma
 */
public interface IBingo {
    
    // Método para obtener todos los registros de la tabla
    List<Bingo> mostrarDatos() throws SQLException;

    // Método para generar partida guardada
    Bingo cargarPartida(String pk) throws SQLException;

    // Método para insertar una nueva partida de bingo
    int partidaNueva(Bingo nuevo) throws SQLException;

    // Método para borrar una partida del bingo
    int borrarPartida(Bingo borrar) throws SQLException;

    // Método para modificar el nombre de la persona
    int actualizarNombre(String pk, Bingo actualizar) throws SQLException;
}
