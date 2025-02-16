/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Hirushan
 */
public class ConnectionProvider {
    public static Connection getCon(){
        String url = "jdbc:mysql://localhost:3306/hotelbooking";
        String user = "root";
        String password = "Ithinkeveryday9332@#";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        }
        
        catch(SQLException | ClassNotFoundException ex){
            System.out.println("Exception (Connection) : " + ex.getMessage());
            ex.printStackTrace();
        }
        
        return null;
        
    }
    
    public static void main(String[] args) {
        getCon();
    }
}
