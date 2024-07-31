package com.backenddev.mensajes_app;

import java.util.Scanner;

public class MensajesService {
         
    public static void crearMensaje(){
        System.out.println("-------- Crear Mensaje --------");
        Mensajes nuevoMensaje = new Mensajes();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Autor: ");
        String nombre = sc.nextLine();
        nuevoMensaje.setAutor_mensaje(nombre);
        System.out.println("Mensaje: ");
        String mensaje = sc.nextLine();
        nuevoMensaje.setMensaje(mensaje);
        MensajesDAO.crearMensaje(nuevoMensaje);
    }
          
    public static void listarMensajes(){
        System.out.println("-------- Listar Mensajes --------");
        MensajesDAO.leerMensajesDB();
    }
            
    public static void borrarMensaje(){
        System.out.println("-------- Borrar Mensajes --------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digita el Id del mensaje a borrar:");
        int id_mensaje = Integer.parseInt(sc.nextLine());
                
        System.out.println("Desea borrar el mensaje: ");
        MensajesDAO.leerMensajeByID(id_mensaje);
        
        int option = 0;
        do{
            System.out.println("1. SI");
            System.out.println("2. Cancelar");
            option = sc.nextInt();
        }while(option != 1 && option != 2);
        
        if(option == 1){
            MensajesDAO.borrarMensaje(id_mensaje);
        }
    }
                
    public static void editarMensaje(){
        System.out.println("-------- Editar Mensajes --------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digita el Id del mensaje a editar:");
        int id_mensaje = Integer.parseInt(sc.nextLine());
        Mensajes updateMensaje = MensajesDAO.leerMensajeByID(id_mensaje);
        
        System.out.println("Autor: ");
        String autor = sc.nextLine();
        updateMensaje.setAutor_mensaje(autor);
        
        System.out.println("Mensaje");
        String nuevoMensaje = sc.nextLine();
        updateMensaje.setMensaje(nuevoMensaje);
        
        MensajesDAO.actualizarMensaje(updateMensaje);
    }
    
}
