/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import BingoAmericano.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author herma
 */
public class BingoDAO implements IBingo {

    private Connection con = null;

    public BingoDAO() {
        con = Conexion.getInstance();
    }

    @Override
    public List<Bingo> mostrarDatos() throws SQLException {
        List<Bingo> lista = new ArrayList<>();
        try (Statement st = con.createStatement()) {
            ResultSet res = st.executeQuery("select * from persona");
            while (res.next()) {
                BingoAmericano bingoA = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.EPOCH, "");
                BingoEuropeo bingoE = new BingoEuropeo(new CartonEuropeo(), new BomboEuropeo(), LocalDate.EPOCH, "");

                if (res.getInt("tipo") == 1) {
                    bingoE.setId(res.getString("id"));
                    bingoE.setNombre(res.getString("nombre"));
                    bingoE.setFecha(res.getDate("fehca").toLocalDate());
                    /* Me faltan los 3 ultimos apartados*/
                    lista.add(bingoE);
                }
                bingoA.setId(res.getString("id"));
                bingoA.setNombre(res.getString("nombre"));
                bingoA.setFecha(res.getDate("fehca").toLocalDate());
                /* Me faltan los 3 ultimos apartados*/
                lista.add(bingoA);
            }
        }

        return lista;
    }

    @Override
    public Bingo cargarPartida(String pk) throws SQLException {
        ResultSet res;

        BingoAmericano bingoA = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.now(), pk);
        BingoEuropeo bingoE = new BingoEuropeo(new CartonEuropeo(), new BomboEuropeo(), LocalDate.now(), pk);

        String sql = "select * from persona where id=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setString(1, pk);
            res = prest.executeQuery();
            if (res.getInt("tipo") == 1) {
                if (res.next()) {
                    bingoE.setId(res.getString("id"));
                    bingoE.setNombre(res.getString("nombre"));
                    bingoE.setFecha(res.getDate("fecha").toLocalDate());
                    /*FALTAN BOMBO, CARTON, TIPO*/
                    return bingoA;
                }
            } else {
                if (res.next()) {
                    bingoA.setId(res.getString("id"));
                    bingoA.setNombre(res.getString("nombre"));
                    bingoA.setFecha(res.getDate("fecha").toLocalDate());
                    /*FALTAN BOMBO, CARTON, TIPO*/
                    return bingoA;
                }
            }
            return null;
        }
    }

    @Override
    public int partidaNueva(Bingo nuevo) throws SQLException {
        int numFilas = 0;
        String sql = "insert into persona values (?,?,?,?,?,?)";

        if (cargarPartida(nuevo.getId()) != null) {

            return numFilas;
        } else {

            try (PreparedStatement prest = con.prepareStatement(sql)) {
                prest.setString(1, nuevo.getId());
                prest.setDate(2, Date.valueOf(nuevo.getFecha()));
                prest.setString(3, nuevo.getNombre());
                /*FALTAN BOMBO, CARTON, TIPO*/
                numFilas = prest.executeUpdate();
            }
            return numFilas;
        }
    }

    @Override
    public int borrarPartida(Bingo borrar) throws SQLException {
        int numFilas = 0;

        String sql = "delete from persona where nombre = ?";
        try (PreparedStatement prest = con.prepareStatement(sql)) {
            prest.setString(1, borrar.getNombre());
            numFilas = prest.executeUpdate();
        }
        return numFilas;
    }

    @Override
    public int actualizarNombre(String viejo, String nuevo) throws SQLException {
        int res = 0;
        String sql = "{call cambiar_nombres (?,?)}";

        try (CallableStatement call = con.prepareCall(sql)) {
            call.setString(1, nuevo);
            call.setString(2, viejo);
            res = call.executeUpdate();

        }
        return res;
    }
    
    private String listaNumero(Bombo bombo){
        String lista = "";
        
        for (int i = 0; i < bombo.getListaBombo().size(); i++) {
            lista += bombo.getListaBombo().get(i) + ",";
        }
        return lista;
    }
    private String listaCarton(Carton carton){
        String lista = "";
        for (int i = 0; i < carton.getMatriz().length; i++) {
            for (int j = 0; j < carton.getMatriz()[i].length; j++) {
                lista += carton.getMatriz()[i][j] + ",";
            }
        }
        return lista;
    }
    
    
}
