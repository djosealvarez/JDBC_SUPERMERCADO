package com.training.prueba.modeloDAO;

import com.training.prueba.conexion.ConexionBD;
import com.training.prueba.inteface.IPedidoProducto;
import com.training.prueba.modelo.PedidoProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PedidoProductoDAO implements IPedidoProducto {
    @Override
    public void mostrarPedidoProductos() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = ConexionBD.getConnection();
            String consulta = "SELECT * FROM pedidos_productos";
            statement = conexion.prepareStatement(consulta);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID Pedido: " + resultSet.getInt("id_pedido") +
                        ", ID Producto: " + resultSet.getInt("id_producto") +
                        ", Cantidad: " + resultSet.getInt("cantidad") +
                        ", Precio Unitario: " + resultSet.getLong("precio_unitario"));
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    @Override
    public void insertarPedidoProductos(List<PedidoProducto> pedidoProductos) {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.getConnection();
            conexion.setAutoCommit(false); // Deshabilitar el modo de autocommit

            String consulta = "INSERT INTO pedidos_productos (id_pedido, id_producto, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";
            statement = conexion.prepareStatement(consulta);

            for (PedidoProducto pedidoProducto : pedidoProductos) {
                statement.setInt(1, pedidoProducto.getIdPedido());
                statement.setInt(2, pedidoProducto.getIdProducto());
                statement.setInt(3, pedidoProducto.getCantidad());
                statement.setLong(4, pedidoProducto.getPrecioUnitario());

                statement.addBatch(); // Agregar la consulta al lote
            }

            statement.executeBatch(); // Ejecutar todas las consultas en el lote
            conexion.commit(); // Confirmar la transacción

            System.out.println("Se insertaron todos los productos de los pedidos correctamente.");
        } catch (SQLException e) {
            try {
                if (conexion != null) {
                    conexion.rollback(); // Revertir la transacción en caso de error
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Error de SQL: " + e.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.setAutoCommit(true); // Restaurar el modo de autocommit
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
