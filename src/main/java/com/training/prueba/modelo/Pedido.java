package com.training.prueba.modelo;

import java.security.Timestamp;

public class Pedido {

    private int id;
    private String direccion;
    private String numeroTarjeta;
    private Timestamp vencimientoTarjeta;
    private String estado;
    private Timestamp fechaSolicitud;
    private Timestamp fechaServido;
    private Timestamp fechaEntregado;
    private int idRepartidor;
    private int idAlmacenista;
    private int idCliente;

    // Constructor
    public Pedido(int id, String direccion, String numeroTarjeta, Timestamp vencimientoTarjeta, String estado,
                  Timestamp fechaSolicitud, Timestamp fechaServido, Timestamp fechaEntregado, int idRepartidor,
                  int idAlmacenista, int idCliente) {
        this.id = id;
        this.direccion = direccion;
        this.numeroTarjeta = numeroTarjeta;
        this.vencimientoTarjeta = vencimientoTarjeta;
        this.estado = estado;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaServido = fechaServido;
        this.fechaEntregado = fechaEntregado;
        this.idRepartidor = idRepartidor;
        this.idAlmacenista = idAlmacenista;
        this.idCliente = idCliente;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Timestamp getVencimientoTarjeta() {
        return vencimientoTarjeta;
    }

    public void setVencimientoTarjeta(Timestamp vencimientoTarjeta) {
        this.vencimientoTarjeta = vencimientoTarjeta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Timestamp getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Timestamp fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Timestamp getFechaServido() {
        return fechaServido;
    }

    public void setFechaServido(Timestamp fechaServido) {
        this.fechaServido = fechaServido;
    }

    public Timestamp getFechaEntregado() {
        return fechaEntregado;
    }

    public void setFechaEntregado(Timestamp fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public int getIdAlmacenista() {
        return idAlmacenista;
    }

    public void setIdAlmacenista(int idAlmacenista) {
        this.idAlmacenista = idAlmacenista;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
