package com.training.prueba.modelo;

public class Categoria {
    private String nombre;
    private String condicionAlmacenaje;
    private String observaciones;


    public Categoria(String nombre, String condicionAlmacenaje, String observaciones) {
        this.nombre = nombre;
        this.condicionAlmacenaje = condicionAlmacenaje;
        this.observaciones = observaciones;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCondicionAlmacenaje() {
        return condicionAlmacenaje;
    }

    public void setCondicionAlmacenaje(String condicionAlmacenaje) {
        this.condicionAlmacenaje = condicionAlmacenaje;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
