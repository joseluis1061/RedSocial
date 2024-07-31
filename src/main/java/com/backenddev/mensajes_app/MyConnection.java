package com.backenddev.mensajes_app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    public static Connection getConnection(){
        Connection myConn = null;
        String url = "jdbc:mysql://localhost:3306/mensajes_app";
        String user = "root";
        String password = "1061ivalostia";
        try{
            myConn = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e){
            System.out.println("Error de conexión: "+ e);
        }
        return myConn;
    }
}
