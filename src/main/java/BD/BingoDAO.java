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

        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {

            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from bingo where tipo=2");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {
                BingoAmericano m = new BingoAmericano(new CartonAmericano(), new BomboAmericano(), LocalDate.now(), "");

                m.setId(res.getString("id"));
                m.setFecha(res.getDate("fecha").toLocalDate());
                m.setNombre(res.getString("nombre"));
                m.setBombo((BomboAmericano) generarBomboAmericano(res.getString("bombo")));
                m.setCarton((CartonAmericano) generarCartonAmericano(res.getString("carton")));
                //Añadimos el objeto a la lista
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
        // Preparamos la consulta de datos mediante un objeto Statement
        // ya que no necesitamos parametrizar la sentencia SQL
        try (Statement st = con.createStatement()) {
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            ResultSet res = st.executeQuery("select * from bingo where tipo=1");
            // Ahora construimos la lista, recorriendo el ResultSet y mapeando los datos
            while (res.next()) {

                BingoEuropeo m = new BingoEuropeo(new CartonEuropeo(), new BomboEuropeo(), LocalDate.now(), "");

                m.setId(res.getString("id"));
                m.setFecha(res.getDate("fecha").toLocalDate());
                m.setNombre(res.getString("nombre"));
                m.setBombo((BomboEuropeo) generarBomboEuropeo(res.getString("bombo")));
                m.setCarton((CartonEuropeo) generarCartonEuropeo(res.getString("carton")));
                //Añadimos el objeto a la lista
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
            // Preparamos la sentencia parametrizada
            prest.setString(1, id);
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();
            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa id
            if (res.next()) {
                bingo.setId(res.getString("id"));
                bingo.setFecha(res.getDate("fecha").toLocalDate());
                bingo.setNombre(res.getString("nombre"));
                bingo.setBombo((BomboAmericano) generarBomboAmericano(res.getString("bombo")));
                bingo.setCarton((CartonAmericano) generarCartonAmericano(res.getString("carton")));

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
            // Preparamos la sentencia parametrizada
            prest.setString(1, id);
            // Ejecutamos la sentencia y obtenemos las filas en el objeto ResultSet
            res = prest.executeQuery();
            // Nos posicionamos en el primer registro del Resultset. Sólo debe haber una fila
            // si existe esa id
            if (res.next()) {
                bingo.setId(res.getString("id"));
                bingo.setFecha(res.getDate("fecha").toLocalDate());
                bingo.setNombre(res.getString("nombre"));
                bingo.setBombo((BomboEuropeo) generarBomboEuropeo(res.getString("bombo")));
                bingo.setCarton((CartonEuropeo) generarCartonEuropeo(res.getString("carton")));
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
            // Instanciamos el objeto PreparedStatement para inserción
            // de datos. Sentencia parametrizada
            if (nuevo instanceof BingoAmericano) {
                prest.setString(1, nuevo.getId());
                prest.setDate(2, Date.valueOf(nuevo.getFecha()));
                prest.setString(3, nuevo.getNombre());
                prest.setInt(4, tipoBingo(nuevo));
                prest.setString(5, listaBombo(((BingoAmericano) nuevo).getBombo()));
                prest.setString(6, listaCarton(((BingoAmericano) nuevo).getCarton()));
            }

            if (nuevo instanceof BingoEuropeo) {
                // Instanciamos el objeto PreparedStatement para inserción
                // de datos. Sentencia parametrizada
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

//    @Override
//    public int borrarPartida(Bingo borrar) {
//        int numFilas = 0;
//
//        String sql = "delete from bingo where id = ?";
//        // Preparamos el borrado de datos  mediante un Statement
//        // No hay parámetros en la sentencia SQL
//        try (PreparedStatement prest = con.prepareStatement(sql)) {
//            // Ejecución de la sentencia
//            prest.setString(1, borrar.getId());
//            numFilas = prest.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        // El borrado se realizó con éxito, devolvemos filas afectadas
//        return numFilas;
//    }
//
    /*Método que genera un String con todos las bolas que quedan en el bombo*/
    private String listaBombo(Bombo bombo) {
        String lista = "";
        for (int i = 0; i < bombo.getListaBombo().size(); i++) {
            lista += bombo.getListaBombo().get(i) + ",";
        }
        return lista;
    }

    /*Método que genera el bombo americano con las bolas que queden, en el se
    le pasa una lista de bolas que quedan (se complementa con el método de listabombo)*/
    private BomboAmericano generarBomboAmericano(String lista) {
        BomboAmericano bombo = new BomboAmericano();

        String[] tokens;
        tokens = lista.split(",");

        for (int i = 0; i < tokens.length; i++) {
            bombo.getListaBombo().add(Integer.parseInt(tokens[i]));
        }
        return bombo;
    }

    /*Método que genera el bombo europeo con las bolas que queden, en el se
    le pasa una lista de bolas que quedan (se complementa con el método de listabombo)*/
    private BomboEuropeo generarBomboEuropeo(String lista) {
        BomboEuropeo bombo = new BomboEuropeo();

        String[] tokens;
        tokens = lista.split(",");

        for (int i = 0; i < tokens.length; i++) {
            bombo.getListaBombo().add(Integer.parseInt(tokens[i]));
        }
        return bombo;
    }

    /*Método que genera un String con una lista con todos los numeros que tiene el carton*/
    public String listaCarton(Carton carton) {
        String lista = "";
        for (int i = 0; i < carton.getMatriz().length; i++) {
            for (int j = 0; j < carton.getMatriz()[i].length; j++) {
                lista += carton.getMatriz()[i][j] + ",";
            }
        }
        return lista;
    }

    /*Método que genera el cartón, le tenemos pasar una lista con todos
    los número que tiene el cartón (se complementa con listaCarton)*/
    private Carton generarCartonAmericano(String lista) {
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

    /*Método que genera el cartón, le tenemos pasar una lista con todos
    los número que tiene el cartón (se complementa con listaCarton)*/
    private Carton generarCartonEuropeo(String lista) {
        Carton carton = new CartonEuropeo();
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

    /*Método que genera el tipo de cartón que es, si es un bingo europeo pondrá 
    1 y si es americano pondrá 2*/
    private int tipoBingo(Bingo bingo) {
        int numero = (bingo instanceof BingoEuropeo) ? 1 : 2;
        return numero;
    }

    public int atualizarPartidaAmericana(String id, BingoAmericano bingo) {
        int numFilas = 0;
        String sql = "update bingo set fecha = ?, bombo = ?, carton = ? where id=?";

        // Instanciamos el objeto PreparedStatement para inserción
        // de datos. Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setDate(1, Date.valueOf(bingo.getFecha()));
            prest.setString(2, listaBombo(((BingoAmericano) bingo).getBombo()));
            prest.setString(3, listaCarton(((BingoAmericano) bingo).getCarton()));
            prest.setString(4, id);

            numFilas = prest.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFilas;
    }

    @Override
    public int atualizarPartidaEuropea(String id, BingoEuropeo bingo) {
        int numFilas = 0;
        String sql = "update bingo set fecha = ?, bombo = ?, carton = ? where id=?";

        // Instanciamos el objeto PreparedStatement para inserción
        // de datos. Sentencia parametrizada
        try (PreparedStatement prest = con.prepareStatement(sql)) {

            prest.setDate(1, Date.valueOf(bingo.getFecha()));
            prest.setString(2, listaBombo(((BingoEuropeo) bingo).getBombo()));
            prest.setString(3, listaCarton(((BingoEuropeo) bingo).getCarton()));
            prest.setString(4, id);

            numFilas = prest.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BingoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numFilas;
    }
}
