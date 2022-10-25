/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cymaniatico
 */
public class ConexionBD {
    
    InfoConexion conexion;
    public ConexionBD(){
        conexion = new InfoConexion();
    }

    public String connectDatabase() {
        try {
            // We register the MySQL (MariaDB) driver
            // Registramos el driver de MySQL (MariaDB)
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de MySQL: " + ex);
            }
            Connection connection =  DriverManager.getConnection(
                    conexion.getUrl(),
                    conexion.getUsername(), conexion.getPassword());
            boolean valid = connection.isValid(50000);
            if(valid){
                return "TEST OK";
            }else{
                return "FAIL CONNECTION";
            }
        } catch (java.sql.SQLException sqle) {
            return("Error: " + sqle);
        }
    }
    
    public int dmlUpdate(String consulta){ //Data Manipulation Language (dml)
        try {
            
            Connection connection = DriverManager.getConnection(conexion.getUrl(), conexion.getUsername(), conexion.getPassword());

            Statement statement = connection.createStatement();
            int ps = statement.executeUpdate(consulta);
               
            statement.close();
            connection.close();
            return ps;

        } catch (SQLException ex) {
            
            System.out.println(ex);
            return 0;
        }
    }
    
    public ResultSet dmlQuery(String consulta){ //Data Manipulation Language (dml)
        try {
            
            Connection connection = DriverManager.getConnection(conexion.getUrl(), conexion.getUsername(), conexion.getPassword());

            Statement statement = connection.createStatement();
            ResultSet ps = statement.executeQuery(consulta);
               
            statement.close();
            connection.close();
            return ps;

        } catch (SQLException ex) {
            
            System.out.println(ex);
            return null;
        }
    }
}
