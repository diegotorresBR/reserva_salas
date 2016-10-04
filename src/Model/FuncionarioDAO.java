/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Autenticar;
import Controller.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author 73433810
 */
public class FuncionarioDAO {
    
    public void inserirFuncionario(FuncionarioBeans f1) throws SQLException{
        
        String sql = "insert into funcionarios(nome) values('"+f1.getNome()+"')";
        
        Statement st = null;
//        Conexao con = new Conexao();
        Autenticar aut = null;
        Connection conn = null;
        try {
            aut.getConexao();
            st = conn.createStatement();
            st.executeUpdate(sql);
            System.out.printf("tche");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        
        }
            
        
    } 
}
