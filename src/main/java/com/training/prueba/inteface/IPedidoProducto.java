package com.training.prueba.inteface;

import com.training.prueba.modelo.PedidoProducto;

import java.util.List;

public interface IPedidoProducto {
    void mostrarPedidoProductos();
    void insertarPedidoProductos(List<PedidoProducto> pedidoProductos);
}
