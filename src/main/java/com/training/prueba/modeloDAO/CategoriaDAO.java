package com.training.prueba.modeloDAO;

import com.training.prueba.conexion.ConexionBD;
import com.training.prueba.inteface.ICategoria;
import com.training.prueba.modelo.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoriaDAO implements ICategoria {
    @Override
    public void mostrarCategorias() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = ConexionBD.getConnection();
            String consulta = "SELECT * FROM Categorias";
            statement = conexion.prepareStatement(consulta);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("nombre") +
                        ", Condición de almacenaje: " + resultSet.getString("condicion_almacenaje") +
                        ", Observaciones: " + resultSet.getString("observaciones"));
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
    public void insertarCategorias(List<Categoria> categorias) {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.getConnection();
            conexion.setAutoCommit(false); // Deshabilitar el modo de autocommit

            String consulta = "INSERT INTO Categorias (nombre, condicion_almacenaje, observaciones) VALUES (?, ?, ?)";
            statement = conexion.prepareStatement(consulta);

            for (Categoria categoria : categorias) {
                statement.setString(1, categoria.getNombre());
                statement.setString(2, categoria.getCondicionAlmacenaje());
                statement.setString(3, categoria.getObservaciones());

                statement.addBatch(); // Agregar la consulta al lote
            }

            statement.executeBatch(); // Ejecutar todas las consultas en el lote
            conexion.commit(); // Confirmar la transacción

            System.out.println("Se insertaron todas las categorías correctamente.");
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
