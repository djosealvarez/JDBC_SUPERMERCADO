package com.training.prueba.modelo;

public class Repartidores {
    private int id;
    private String nombre;
    private String matriculaFurgoneta;


    public Repartidores(int id, String nombre, String matriculaFurgoneta) {
        this.id = id;
        this.nombre = nombre;
        this.matriculaFurgoneta = matriculaFurgoneta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatriculaFurgoneta() {
        return matriculaFurgoneta;
    }

    public void setMatriculaFurgoneta(String matriculaFurgoneta) {
        this.matriculaFurgoneta = matriculaFurgoneta;
    }
}
