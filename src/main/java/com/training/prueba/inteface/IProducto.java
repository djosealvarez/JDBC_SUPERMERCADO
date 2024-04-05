package com.training.prueba.inteface;

import com.training.prueba.modelo.Producto;

import java.util.List;

public interface IProducto {
        void mostrarProductos();
        void insertarProductos(List<Producto> productos);
    }

