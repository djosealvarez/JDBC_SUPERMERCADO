package com.training.prueba.modeloDAO;

import com.training.prueba.conexion.ConexionBD;
import com.training.prueba.inteface.IAlmacenistaArea;
import com.training.prueba.modelo.AlmacenistaArea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AlmacenistaAreaDAO implements IAlmacenistaArea {
    @Override
    public void mostrarAlmacenistasAreas() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = ConexionBD.getConnection();
            String consulta = "SELECT * FROM almacenistas_areas";
            statement = conexion.prepareStatement(consulta);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID Almacenista: " + resultSet.getInt("id_almacenistaFK") +
                        ", Área: " + resultSet.getString("area"));
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
    public void insertarAlmacenistasAreas(List<AlmacenistaArea> almacenistasAreas) {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.getConnection();
            conexion.setAutoCommit(false); // Deshabilitar el modo de autocommit

            String consulta = "INSERT INTO almacenistas_areas (id_almacenistaFK, area) VALUES (?, ?)";
            statement = conexion.prepareStatement(consulta);

            for (AlmacenistaArea almacenistaArea : almacenistasAreas) {
                statement.setInt(1, almacenistaArea.getIdAlmacenista());
                statement.setString(2, almacenistaArea.getArea());

                statement.addBatch(); // Agregar la consulta al lote
            }

            statement.executeBatch(); // Ejecutar todas las consultas en el lote
            conexion.commit(); // Confirmar la transacción

            System.out.println("Se insertaron todas las áreas de los almacenistas correctamente.");
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

