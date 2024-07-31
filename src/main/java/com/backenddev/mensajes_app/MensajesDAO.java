
package com.backenddev.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MensajesDAO {

    public static void crearMensaje(Mensajes mensaje){     
        try(
            PreparedStatement myPrep = MyConnection.getConnection().prepareStatement("INSERT INTO mensajes (autor_mensaje, mensaje) VALUES(?, ?)");
        ){
            myPrep.setString(1, mensaje.autor_mensaje);            
            myPrep.setString(2, mensaje.mensaje);
            myPrep.executeUpdate();
            System.out.println("Mensaje creado");
        }
        catch(SQLException e){
            System.out.println("Error al crea mensaje: "+ e);
        }
    }
    
              
    public static void leerMensajesDB(){
        try(
            Statement myState = MyConnection.getConnection().createStatement();
        ){
            ResultSet myRest = myState.executeQuery("SELECT *  FROM mensajes");
            while(myRest.next()){
                System.out.println("-------------------------------------------");
                System.out.println("id: "+myRest.getString("id_mensaje"));                    
                System.out.println("autor: "+myRest.getString("autor_mensaje"));
                System.out.println("autor: "+myRest.getString("mensaje"));
                System.out.println("autor: "+myRest.getString("fecha_mensaje"));
                System.out.println("*******************************************");
            }
        }
        catch(SQLException e){
            System.out.println("Error al listar los datos: " + e);
        }
    }
    
    public static Mensajes leerMensajeByID(int id){
        Mensajes mensaje = new Mensajes();
        try(
            Statement myState = MyConnection.getConnection().createStatement();
        ){
            ResultSet myRest = myState.executeQuery("SELECT * FROM mensajes WHERE id_mensaje = "+ id);
            while(myRest.next()){
                System.out.println("-------------------------------------------");
                System.out.println("id: "+myRest.getString("id_mensaje"));                    
                System.out.println("autor: "+myRest.getString("autor_mensaje"));
                System.out.println("autor: "+myRest.getString("mensaje"));
                System.out.println("autor: "+myRest.getString("fecha_mensaje"));
                System.out.println("*******************************************");
                
                mensaje.setId_mensaje(myRest.getInt("id_mensaje"));                
                mensaje.setAutor_mensaje(myRest.getString("autor_mensaje"));
                mensaje.setMensaje(myRest.getString("mensaje"));
                mensaje.setFecha_mensaje(myRest.getDate("fecha_mensaje"));
            }
        }
        catch(SQLException e){
            System.out.println("Error al listar los datos: " + e);
        }
        return mensaje;
    }
            
    public static void borrarMensaje(int id_mensaje){
        try(
            PreparedStatement myPrep = MyConnection.getConnection().prepareStatement("DELETE FROM mensajes WHERE id_mensaje = ?");
        ){
            myPrep.setInt(1, id_mensaje);
            myPrep.executeUpdate();
            System.out.println("Mensaje borrado");
        }
        catch(SQLException e){
            System.err.println("Error al borrar mensaje: "+ e);
        }
    }
                
    public static void actualizarMensaje(Mensajes mensaje){
        try(
            PreparedStatement myPrep = MyConnection.getConnection().prepareStatement("UPDATE mensajes SET autor_mensaje = ?, mensaje = ? WHERE id_mensaje = ?");
        ){
            myPrep.setString(1, mensaje.getAutor_mensaje());
            myPrep.setString(2, mensaje.getMensaje());
            myPrep.setInt(3, mensaje.getId_mensaje());
            int rowsChanges = myPrep.executeUpdate();
            if(rowsChanges >0){
                System.out.println("Actualización terminada");
            }
            
        }
        catch(SQLException e){
            System.err.println("Error al actualizar mensaje: "+ e);
        }
        
    }
}
