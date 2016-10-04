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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 73433810
 */
public class SalasDAO {
    
     List<String> lista = new LinkedList<String>();
     Autenticar aut = null;  
    public void cadastrar_sala(SalasBeans s) throws SQLException{
        
        String sql = "insert into salas(nome) values('"+s.getNome()+"')";
        
        Statement st = null;
        Conexao con = new Conexao();
        Connection conn = null;
        try {
//            conn = con.getConexao();
            conn = aut.getConexao();
            st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.printf("tche");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            
        
        }
        
    }
    public ResultSet getTodas_as_Salas() throws SQLException{
        
        String sql = "Select nome, id from salas";
        
        
        Statement st = null;
        Conexao con = new Conexao();
        Connection conn = null;
        ResultSet rs = null;
        try {
//            conn = con.getConexao();
            conn = aut.getConexao();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            
       
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        
        
       return rs;
        
        
    }
    public void alteraSala(int i, String nome) throws SQLException{
        String sql = "UPDATE salas ";
               sql+= "set nome = "+"'"+nome+"'";
               sql+= " WHERE id = "+i;
        
        Statement st = null;
        Conexao con = new Conexao();
        Connection conn = null;
        try {
//            conn = con.getConexao();
            conn = aut.getConexao();
            st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.printf("Alterou");
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public void excluir_sala(int i) throws SQLException{
        String sql = "DELETE FROM salas";
               sql+= " WHERE id = "+i;
        
        Statement st = null;
        Conexao con = new Conexao();
        Connection conn = null;
        try {
//            conn = con.getConexao();
            conn = aut.getConexao();
            st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.printf("Alterou");
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public void imprime(){
        
        for (String nome : lista){
            System.out.println(nome);
        }
        
    }
}
