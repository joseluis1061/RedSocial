package com.backenddev.mensajes_app;

import java.util.Scanner;

public class Mensajes_app {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        
        do{
            System.out.println("--------------------");
            System.out.println("Aplicación de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Editar mensajes");
            System.out.println("4. Eliminar mensajes");
            System.out.println("5. Salir");
            
            option = sc.nextInt();
            
            switch(option){
                case 1 -> MensajesService.crearMensaje();
                case 2 -> MensajesService.listarMensajes();
                case 3 -> MensajesService.editarMensaje();
                case 4 -> MensajesService.borrarMensaje();
                case 5 -> System.err.println("See you leater");                    
            }

        }while(option != 5);
    }
}
