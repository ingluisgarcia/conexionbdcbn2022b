/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionbd;

/**
 *
 * @author cymaniatico
 */
public class InfoConexion {
    String url = "jdbc:mysql://localhost/prueba";
    String username="cymaniatico";
    String password="drakhuntress1210";

    public InfoConexion() {
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}
