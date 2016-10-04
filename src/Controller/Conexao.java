/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 73433810
 */
public class Conexao {
    String URL = "jdbc:postgresql://172.27.50.76:5432/";
    String NOME_BANCO = "reserva_salas";
    String USER = "postgres";
    String SENHA = "9090";
    
    public Connection getConexao() throws ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL+NOME_BANCO,USER,SENHA);
            System.out.println("Conetou");
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
