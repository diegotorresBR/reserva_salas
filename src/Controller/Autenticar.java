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
public class Autenticar {

    static String URL = "jdbc:postgresql://172.27.50.71:5432/";
    static String NOME_BANCO = "reserva_salas";
    static String USER = null;
    static String SENHA = null;
    
    
    
    
    public static Connection getConexao() throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        
        Connection con = null;
        
            con = DriverManager.getConnection(URL+NOME_BANCO,USER,SENHA);
            System.out.println("Conetou");
        
        return con;
    }

    public static void setSENHA(String SENHA) {
        Autenticar.SENHA = SENHA;
    }

    public static void setUSER(String USER) {
        Autenticar.USER = USER;
    }

    public static String getUSER() {
        return USER;
    }
    
    
    
    
    
}
