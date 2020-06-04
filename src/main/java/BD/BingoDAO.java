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
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    public List<BingoAmericano> mostrarDatosAmericanos() {
        List<BingoAmericano> lista = new ArrayList<>();

        try (Statement st = con.createStatement()) {
            ResultSet res = st.executeQuery("select * from bingo where tipo=2");
            while (res.next()) {
                BingoAmericano m = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.now(), "");

                m.setId(res.getString("id"));
                m.setFecha(res.getDate("fecha").toLocalDate());
                m.setNombre(res.getString("nombre"));
                m.setBombo((BomboAmericano) generarBomboAmericano(res.getString("bombo")));
                m.setCarton((CartonAmericano) generarCarton(res.getString("carton")));

                lista.add(m);

            }
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public List<BingoEuropeo> mostrarDatosEuropeos() {

        List<BingoEuropeo> lista = new ArrayList<>();

        try (Statement st = con.createStatement()) {
            ResultSet res = st.executeQuery("select * from bingo where tipo=1");
            while (res.next()) {

                BingoEuropeo m = new BingoEuropeo(new CartonEuropeo(), new BomboEuropeo(), LocalDate.now(), "");

                m.setId(res.getString("id"));
                m.setFecha(res.getDate("fecha").toLocalDate());
                m.setNombre(res.getString("nombre"));
                m.setBombo((BomboEuropeo) generarBomboEuropeo(res.getString("bombo")));
//                m.setCarton((CartonEuropeo) generarCarton(res.getString("carton")));
                lista.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public BingoAmericano cargarPartidaAmericano(String id) {
        ResultSet res;
        BingoAmericano bingo = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.now(), id);

        String sql = "select * from bingo where id=?";
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setString(1, id);
            res = prest.executeQuery();

            if (res.next()) {
                bingo.setId(res.getString("id"));
                bingo.setFecha(res.getDate("fecha").toLocalDate());
                bingo.setNombre(res.getString("nombre"));
                bingo.setBombo((BomboAmericano) generarBomboAmericano(res.getString("bombo")));
                bingo.setCarton((CartonAmericano) generarCarton(res.getString("carton")));
                
                return bingo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public BingoEuropeo cargarPartidaEuropeo(String id) {
        ResultSet res;
        BingoEuropeo bingo = new BingoEuropeo(new CartonEuropeo(), new BomboEuropeo(), LocalDate.now(), id);

        String sql = "select * from bingo where id=?";
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setString(1, id);
            res = prest.executeQuery();

            if (res.next()) {
                bingo.setId(res.getString("id"));
                bingo.setFecha(res.getDate("fecha").toLocalDate());
                bingo.setNombre(res.getString("nombre"));
                bingo.setBombo((BomboEuropeo) generarBomboEuropeo(res.getString("bombo")));
//                bingo.setCarton((CartonEuropeo) generarCarton(res.getString("carton")));
                return bingo;
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

    private BomboAmericano generarBomboAmericano(String lista) {
        BomboAmericano bombo = new BomboAmericano();

        String[] tokens;
        tokens = lista.split(",");

        for (int i = 0; i < tokens.length; i++) {
            bombo.getListaBombo().add(Integer.parseInt(tokens[i]));
        }
        return bombo;
    }

    private BomboEuropeo generarBomboEuropeo(String lista) {
        BomboEuropeo bombo = new BomboEuropeo();

        String[] tokens;
        tokens = lista.split(",");

        for (int i = 0; i < tokens.length; i++) {
            bombo.getListaBombo().add(Integer.parseInt(tokens[i]));
        }
        return bombo;
    }

    public String listaCarton(Carton carton) {
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

        for (int i = 0; i < carton.getMatriz().length; i++) {
            for (int j = 0; j < carton.getMatriz()[i].length; j++) {
                matriz[i][j] = Integer.parseInt(tokens[contador]);
                contador++;
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
        String sql = "update bingo set fecha = ?, bombo = ?, carton = ? where id=?";

        try (PreparedStatement prest = con.prepareStatement(sql)) {
            
            if (bingo instanceof BingoAmericano) {
                prest.setDate(1, Date.valueOf(bingo.getFecha()));
                prest.setString(2, listaBombo(((BingoAmericano) bingo).getBombo()));
                prest.setString(3, listaCarton(((BingoAmericano) bingo).getCarton()));
                prest.setString(4, bingo.getId());
            } 

            if (bingo instanceof BingoEuropeo) {
                prest.setDate(1, Date.valueOf(bingo.getFecha()));
                prest.setString(2, listaBombo(((BingoEuropeo) bingo).getBombo()));
                prest.setString(3, listaCarton(((BingoEuropeo) bingo).getCarton()));
                prest.setString(4, bingo.getId());
            }

            numFilas = prest.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numFilas;
    }
}
