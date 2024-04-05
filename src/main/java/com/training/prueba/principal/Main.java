package com.training.prueba.principal;

import com.training.prueba.modeloDAO.*;
import com.training.prueba.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        //CLIENTE

        //Insertar y mostrar Cliente
        System.out.println("Mostrando cliente");
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.mostrarCliente();


        System.out.println("Insertando clientes...");

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente(18, "1234567890", "Juan", "Pérez", "Calle Principal 123", "123456789", "12345", "juan@example.com", "contraseña123"));
        clientes.add(new Cliente(19, "0987654321", "María", "López", "Avenida Central 456", "987654321", "54321", "maria@example.com", "password456"));

        clienteDAO.insertarClientes(clientes);



        //CATEGORIA

        //Insertar y mostrar Categoria
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("Cereales", "Seco", "Categoría para cereales y granos"));
        categorias.add(new Categoria("Tuberculos", "Refrigerado", "Categoría para productos alimenticios refrigerados"));

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        categoriaDAO.insertarCategorias(categorias);
        categoriaDAO.mostrarCategorias();




        //ALMACENISTA
        // Insertar y mostrar Almacenistas
         List<Almacenista> almacenistas = new ArrayList<>();
        almacenistas.add(new Almacenista(11, "Petrona Rodriguez"));
        almacenistas.add(new Almacenista(22, "Arleth Casola"));

        AlmacenistaDAO almacenistaDAO = new AlmacenistaDAO();
          almacenistaDAO.insertarAlmacenistas(almacenistas);
        almacenistaDAO.mostrarAlmacenistas();




        //PRODUCTO
         // Insertar y mostrar Productos
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(1, "Smartphone", "Samsung", "Corea del Sur", "16x8x0.8", "200g", "smartphone.jpg", 1000000, 50, "Electrónica"));
        productos.add(new Producto(2, "Televisor", "LG", "Corea del Sur", "120x70x10", "15kg", "tv.jpg", 1500000, 30, "Electrónica"));

        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.insertarProductos(productos);
        productoDAO.mostrarProductos();




        //REPARTIDORES
        // Insertar y mostrar Repartidores
        List<Repartidores> repartidores = new ArrayList<>();
        repartidores.add(new Repartidores(13, "Duvan Molina", "CJt568"));
        repartidores.add(new Repartidores(14, "Juan Perez", "UQd894"));

        RepartidorDAO repartidorDAO = new RepartidorDAO();
        repartidorDAO.insertarRepartidores(repartidores);
       // repartidorDAO.mostrarRepartidores();



        //PEDIDO_PRODUCTO
        // Insertar y mostrar pedido_producto
        List<PedidoProducto> pedidoProductos = new ArrayList<>();
        pedidoProductos.add(new PedidoProducto(6, 8, 3, 2600));
        pedidoProductos.add(new PedidoProducto(5, 8, 3, 3400));
        pedidoProductos.add(new PedidoProducto(3, 8, 3, 4700));

        PedidoProductoDAO pedidoProductoDAO = new PedidoProductoDAO();
        pedidoProductoDAO.insertarPedidoProductos(pedidoProductos);
        pedidoProductoDAO.mostrarPedidoProductos();



        //REPARTIDOR_CODIGO_POSTAL
        // Insertar y mostrar repartido y codigo postal
        List<RepartidorCodigoPostal> repartidoresCodigosPostales = new ArrayList<>();
        repartidoresCodigosPostales.add(new RepartidorCodigoPostal(7, "11022")); // ID Repartidor, Código Postal
        repartidoresCodigosPostales.add(new RepartidorCodigoPostal(6, "11023"));
        repartidoresCodigosPostales.add(new RepartidorCodigoPostal(5, "11024"));

        // Crear una instancia de RepartidorCodigoPostalDAO
        RepartidorCodigoPostalDAO repartidorCodigoPostalDAO = new RepartidorCodigoPostalDAO();
        repartidorCodigoPostalDAO.insertarRepartidoresCodigosPostales(repartidoresCodigosPostales);
        repartidorCodigoPostalDAO.mostrarRepartidoresCodigosPostales();



        //ALMACENISTA_AREA
        // Insertar y mostrar almacenista_area
        List<AlmacenistaArea> almacenistasAreas = new ArrayList<>();
        almacenistasAreas.add(new AlmacenistaArea(3, "Almacenista")); // ID Almacenista, Área
        almacenistasAreas.add(new AlmacenistaArea(4, "Carga y descarga"));
        almacenistasAreas.add(new AlmacenistaArea(6, "Preparacion de pedido"));

        AlmacenistaAreaDAO almacenistaAreaDAO = new AlmacenistaAreaDAO();
        almacenistaAreaDAO.insertarAlmacenistasAreas(almacenistasAreas);
        almacenistaAreaDAO.mostrarAlmacenistasAreas();
    }
}







