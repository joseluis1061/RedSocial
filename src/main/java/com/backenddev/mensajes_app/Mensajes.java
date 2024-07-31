package com.backenddev.mensajes_app;

import java.sql.Date;

public class Mensajes {
    int id_mensaje;
    String autor_mensaje;
    String mensaje;
    Date fecha_mensaje;

    public Mensajes() {
    }

    public Mensajes(String autor_mensaje, String mensaje, Date fecha_mensaje) {
        this.autor_mensaje = autor_mensaje;
        this.mensaje = mensaje;
        this.fecha_mensaje = fecha_mensaje;
    }
    

    public int getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getAutor_mensaje() {
        return autor_mensaje;
    }

    public void setAutor_mensaje(String autor_mensaje) {
        this.autor_mensaje = autor_mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha_mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_mensaje(Date fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }
    
    
    
}
