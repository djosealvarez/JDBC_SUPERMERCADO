package com.training.prueba.inteface;

import com.training.prueba.modelo.Categoria;

import java.util.List;

public interface ICategoria {
    public void mostrarCategorias();

    public void insertarCategorias(List<Categoria> categorias);
}
