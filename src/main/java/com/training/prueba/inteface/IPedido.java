package com.training.prueba.inteface;

import com.training.prueba.modelo.Pedido;

import java.util.List;

public interface IPedido {

    void mostrarPedidos();

    void insertarPedidos(List<Pedido> pedidos);
}
