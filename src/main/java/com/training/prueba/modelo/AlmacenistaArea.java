package com.training.prueba.modelo;

public class AlmacenistaArea {
    private int idAlmacenista;
    private String area;

    // Constructor
    public AlmacenistaArea(int idAlmacenista, String area) {
        this.idAlmacenista = idAlmacenista;
        this.area = area;
    }

    // Getters y Setters
    public int getIdAlmacenista() {
        return idAlmacenista;
    }

    public void setIdAlmacenista(int idAlmacenista) {
        this.idAlmacenista = idAlmacenista;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
