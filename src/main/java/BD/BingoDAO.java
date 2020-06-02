/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import BingoAmericano.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public Bingo cargarPartida(String id) {
        ResultSet res;
        Bingo bingo = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.now(), id);

        String sql = "select * from bingo where id=?";
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setString(1, id);
            res = prest.executeQuery();

            if (res.next()) {
                if (bingo instanceof BingoAmericano) {
                    bingo.setId(res.getString("id"));
                    bingo.setFecha(res.getDate("fecha").toLocalDate());
                    bingo.setNombre(res.getString("nombre"));
                    ((BingoAmericano) bingo).setBombo((BomboAmericano) generarBombo(res.getString("bombo")));
                    ((BingoAmericano) bingo).setCarton((CartonAmericano) generarCarton(res.getString("carton")));
                    return bingo;
                }

                if (bingo instanceof BingoEuropeo) {
                    bingo.setId(res.getString("id"));
                    bingo.setFecha(res.getDate("fecha").toLocalDate());
                    bingo.setNombre(res.getString("nombre"));
                    ((BingoEuropeo) bingo).setBombo((BomboEuropeo) generarBombo(res.getString("bombo")));
                    ((BingoEuropeo) bingo).setCarton((CartonEuropeo) generarCarton(res.getString("carton")));
                    return bingo;
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int partidaNueva(Bingo nuevo) {
        int numFilas = 0;
        String sql = "insert into bingo values (?,?,?,?,?,?)";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            if (nuevo instanceof BingoAmericano) {
                prest.setString(1, nuevo.getId());
                prest.setDate(2, Date.valueOf(nuevo.getFecha()));
                prest.setString(3, nuevo.getNombre());
                prest.setInt(4, tipoBingo(nuevo));
                prest.setString(5, listaBombo(((BingoAmericano) nuevo).getBombo()));
                prest.setString(6, listaCarton(((BingoAmericano) nuevo).getCarton()));
            }

            if (nuevo instanceof BingoEuropeo) {
                prest.setString(1, nuevo.getId());
                prest.setDate(2, Date.valueOf(nuevo.getFecha()));
                prest.setString(3, nuevo.getNombre());
                prest.setInt(4, tipoBingo(nuevo));
                prest.setString(5, listaBombo(((BingoEuropeo) nuevo).getBombo()));
                prest.setString(6, listaCarton(((BingoEuropeo) nuevo).getCarton()));
            }
            numFilas = prest.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFilas;
    }

    @Override
    public int borrarPartida(Bingo borrar) {
        int numFilas = 0;
        String sql = "delete from bingo where id = ?";
        try (PreparedStatement prest = con.prepareStatement(sql)) {
            prest.setString(1, borrar.getId());
            numFilas = prest.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFilas;
    }

    private String listaBombo(Bombo bombo) {
        String lista = "";
        for (int i = 0; i < bombo.getListaBombo().size(); i++) {
            lista += bombo.getListaBombo().get(i) + ",";
        }
        return lista;
    }

    private Bombo generarBombo(String lista) {
        Bombo bombo = new BomboAmericano();

        String[] tokens;
        tokens = lista.split(",");

        if (bombo instanceof BomboAmericano) {
            for (int i = 0; i < tokens.length; i++) {
                bombo.getListaBombo().add(Integer.parseInt(tokens[i]));
            }
        }
        if (bombo instanceof BomboEuropeo) {
            for (int i = 0; i < tokens.length; i++) {
                bombo.getListaBombo().add(Integer.parseInt(tokens[i]));
            }
        }

        return bombo;
    }

    private String listaCarton(Carton carton) {
        String lista = "";
        for (int i = 0; i < carton.getMatriz().length; i++) {
            for (int j = 0; j < carton.getMatriz()[i].length; j++) {
                lista += carton.getMatriz()[i][j] + ",";
            }
        }
        return lista;
    }

    private Carton generarCarton(String lista) {
        Carton carton = new CartonAmericano();

        String[] tokens;
        tokens = lista.split(",");
        int[][] matriz = carton.getMatriz();
        int contador = 0;
        if (carton instanceof CartonAmericano) {
            for (int i = 0; i < carton.getMatriz().length; i++) {
                for (int j = 0; j < carton.getMatriz()[i].length; j++) {
                    matriz[i][j] = Integer.parseInt(tokens[contador]);
                    contador++;
                }
            }
        }
        return carton;
    }

    private int tipoBingo(Bingo bingo) {
        int numero = (bingo instanceof BingoEuropeo) ? 1 : 2;
        return numero;
    }

    @Override
    public int atualizarPartida(String id, Bingo bingo) {
        int numFilas = 0;
        String sql = "update bingo set  fecha = ?, bombo = ?, carton = ? where id=?";

        try {
            if (cargarPartida(id) == null) {
                // La persona a actualizar no existe
                return numFilas;
            } else {
                try (PreparedStatement prest = con.prepareStatement(sql)) {

                    if (bingo instanceof BingoAmericano) {
                        prest.setDate(1, Date.valueOf(bingo.getFecha()));
                        prest.setString(2, listaBombo(((BingoAmericano) bingo).getBombo()));
                        prest.setString(3, listaCarton(((BingoAmericano) bingo).getCarton()));
                        prest.setString(4, bingo.getId());
                    }

                    if (bingo instanceof BingoEuropeo) {
                        prest.setDate(1, Date.valueOf(bingo.getFecha()));;
                        prest.setString(2, listaBombo(((BingoEuropeo) bingo).getBombo()));
                        prest.setString(3, listaCarton(((BingoEuropeo) bingo).getCarton()));
                        prest.setString(4, bingo.getId());
                    }

                    numFilas = prest.executeUpdate();
                }
                return numFilas;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
