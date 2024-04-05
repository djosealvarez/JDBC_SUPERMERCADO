package com.training.prueba.modeloDAO;

import com.training.prueba.conexion.ConexionBD;
import com.training.prueba.inteface.IRepartidor;
import com.training.prueba.modelo.Repartidores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepartidorDAO implements IRepartidor {
    @Override
    public void mostrarRepartidores() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = ConexionBD.getConnection();
            String consulta = "SELECT * FROM Repartidores";
            statement = conexion.prepareStatement(consulta);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Nombre: " + resultSet.getString("nombre") +
                        ", Matrícula Furgoneta: " + resultSet.getString("matricula_furgoneta"));
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
    public void insertarRepartidores(List<Repartidores> repartidores) {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.getConnection();
            conexion.setAutoCommit(false); // Deshabilitar el modo de autocommit

            String consulta = "INSERT INTO Repartidores (id, nombre, matricula_furgoneta) VALUES (?, ?, ?)";
            statement = conexion.prepareStatement(consulta);

            for (Repartidores repartidor : repartidores) {
                statement.setInt(1, repartidor.getId());
                statement.setString(2, repartidor.getNombre());
                statement.setString(3, repartidor.getMatriculaFurgoneta());

                statement.addBatch(); // Agregar la consulta al lote
            }

            statement.executeBatch(); // Ejecutar todas las consultas en el lote
            conexion.commit(); // Confirmar la transacción

            System.out.println("Se insertaron todos los repartidores correctamente.");
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
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
