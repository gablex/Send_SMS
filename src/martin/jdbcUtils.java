/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package martin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author support
 */
public class jdbcUtils {

    Connection con;

    public Connection connectionLocal() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/YourDB", "user", "passwd");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
        return con;
    }
    public Connection connectionGodaddy() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Server IP connect more faster than the ip name, therefore changed from mspace.co.ke to 72.167.52.99
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/YourDB", "user", "passwd");
            //System.out.println("======================= Connected to Godaddy ====================");
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
        return con;
    }
    
    public Connection ReplicationServer() throws SQLException {

    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
             con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/YourDB", "user", "passwd");
           // System.out.println("=============== Connected to Replication Server ========================= ");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
        return con;
    }
      public Connection Server45() throws SQLException {

    
        try {
            Class.forName("com.mysql.jdbc.Driver");

             con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/YourDB", "user", "passwd");
          //  System.out.println("==================== Connected to Server 45 (Dashboard) =================");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();

        }
        return con;
       
    } 
    }
