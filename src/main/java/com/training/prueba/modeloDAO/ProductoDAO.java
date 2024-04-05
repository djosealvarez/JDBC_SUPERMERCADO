package com.training.prueba.modeloDAO;

import com.training.prueba.conexion.ConexionBD;
import com.training.prueba.inteface.IProducto;
import com.training.prueba.modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductoDAO implements IProducto {
    @Override
    public void mostrarProductos() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = ConexionBD.getConnection();
            String consulta = "SELECT * FROM Productos";
            statement = conexion.prepareStatement(consulta);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Nombre: " + resultSet.getString("nombre") +
                        ", Marca: " + resultSet.getString("marca") +
                        ", Origen: " + resultSet.getString("origen") +
                        ", Volumen: " + resultSet.getString("volumen") +
                        ", Peso: " + resultSet.getString("peso") +
                        ", Fotografía: " + resultSet.getString("fotografia") +
                        ", Precio: " + resultSet.getLong("precio") +
                        ", Stock: " + resultSet.getLong("stock") +
                        ", Nombre de Categoría: " + resultSet.getString("nombre_categoria"));
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
    public void insertarProductos(List<Producto> productos) {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.getConnection();
            conexion.setAutoCommit(false); // Deshabilitar el modo de autocommit

            String consulta = "INSERT INTO Productos (id, nombre, marca, origen, volumen, peso, fotografia, precio, stock, nombre_categoria) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conexion.prepareStatement(consulta);

            for (Producto producto : productos) {
                statement.setInt(1, producto.getId());
                statement.setString(2, producto.getNombre());
                statement.setString(3, producto.getMarca());
                statement.setString(4, producto.getOrigen());
                statement.setString(5, producto.getVolumen());
                statement.setString(6, producto.getPeso());
                statement.setString(7, producto.getFotografia());
                statement.setLong(8, producto.getPrecio());
                statement.setLong(9, producto.getStock());
                statement.setString(10, producto.getNombreCategoria());

                statement.addBatch(); // Agregar la consulta al lote
            }

            statement.executeBatch(); // Ejecutar todas las consultas en el lote
            conexion.commit(); // Confirmar la transacción

            System.out.println("Se insertaron todos los productos correctamente.");
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
