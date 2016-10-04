/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Autenticar;
import Controller.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.postgresql.util.PSQLException;

/**
 *
 * @author 73433810
 */
public class ReservaDAO {
    Autenticar aut = null;
    public ResultSet getReservas(){
        String sql = "SELECT r.id, inicio, fim, id_sala, funcionario, descricao, nome";
        sql += " FROM reservas r join salas s on r.id_sala = s.id";
        sql += " order by inicio";
        
        Statement st = null;
        Conexao con = new Conexao();
        ResultSet rs = null;
        Connection conn = null;
        
        try {
            conn = con.getConexao();
//            conn = aut.getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        
        return rs;
    }
    public ResultSet getReservas_por_sala(int i){
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        Conexao conn = new Conexao();
        
        String sql = "select s.id, nome, inicio, fim  ";
               sql+= "from reservas r join salas s on s.id=r.id_sala ";
               sql+= "where r.id_sala = "+i;
               sql+= " order by inicio";
        try {
//            con = conn.getConexao();
            con = aut.getConexao();
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na reserva ", JOptionPane.ERROR_MESSAGE);
        }
        
        return rs;
               
    }
    public ResultSet getReservs_para_comparacao(){
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        Conexao conn = new Conexao();
        
        String sql = "SELECT id, inicio, fim, id_sala FROM reservas;";
        
        try {
//            con = conn.getConexao();
            con = aut.getConexao();
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    public void reservar(ReservaBeans reserva) throws SQLException{
        Statement st = null;
        Connection con = null;
        Conexao conn = new Conexao();
        
        String sql = "INSERT INTO reservas(inicio, fim, id_sala, funcionario, descricao) ";
               sql += "VALUES ('"+reserva.getData_reserva_inicio()+"', " + "'"+reserva.getData_reserva_fim()+"', ";
               sql +=reserva.getId_sala()+",'"+reserva.getfuncionario()+"','"+reserva.getDescricao()+"'"+")";
               
        try {
//            con = conn.getConexao();
            con = aut.getConexao();
            st = con.createStatement();
            st.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  


    }
    public ResultSet getreservas_por_salas_por_reserva(int i){//metodo para a funcionalidade alterar ou excluir uma reserva
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        Conexao conn = new Conexao();
        
        String sql = "select nome, inicio, fim, descricao, funcionario, r.id";
               sql+= " from reservas r join salas s on s.id=r.id_sala";
               sql+= " where s.id = "+i;
               sql+= " order by inicio";
        try {
//            con = conn.getConexao();
            con = aut.getConexao();
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na reserva ", JOptionPane.ERROR_MESSAGE);
        }
        
        return rs;
               
    }
    public ResultSet get_reserva_por_numero(int i){
        Statement st = null;
        ResultSet rs = null;
        Connection con = null;
        Conexao conn = new Conexao();
        
        String sql = "select nome, inicio, fim, descricao, funcionario, r.id";
               sql+= " from reservas r join salas s on s.id=r.id_sala";
               sql+= " where r.id = "+i;
               sql+=" order by inicio";
        try {
//            con = conn.getConexao();
            con = aut.getConexao();
            st = con.createStatement();
            rs = st.executeQuery(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na reserva ", JOptionPane.ERROR_MESSAGE);
        }
        
        return rs;
    }
    public void excluir_reserva(long i) throws SQLException{
        
        Statement st = null;
        Connection con = null;
        Conexao conn = new Conexao();
        
        String sql = "DELETE FROM reservas";
               sql+= " WHERE id = "+ i;
               
        try {
//            con = conn.getConexao();
            con = aut.getConexao();
            st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "A Reserva: "+i+" foi excluída com sucesso");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReservaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
//            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro na reserva ", JOptionPane.ERROR_MESSAGE);
        }
    }
}
