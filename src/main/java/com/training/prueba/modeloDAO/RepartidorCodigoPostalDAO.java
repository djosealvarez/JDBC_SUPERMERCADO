package com.training.prueba.modeloDAO;

import com.training.prueba.conexion.ConexionBD;
import com.training.prueba.inteface.IRepartidorCodigoPostal;
import com.training.prueba.modelo.RepartidorCodigoPostal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RepartidorCodigoPostalDAO implements IRepartidorCodigoPostal {
    @Override
    public void mostrarRepartidoresCodigosPostales() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = ConexionBD.getConnection();
            String consulta = "SELECT * FROM repartidores_codigos_postales";
            statement = conexion.prepareStatement(consulta);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("ID Repartidor: " + resultSet.getInt("id_repartidor") +
                        ", Código Postal: " + resultSet.getString("codigo_postal"));
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
    public void insertarRepartidoresCodigosPostales(List<RepartidorCodigoPostal> repartidoresCodigosPostales) {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.getConnection();
            conexion.setAutoCommit(false); // Deshabilitar el modo de autocommit

            String consulta = "INSERT INTO repartidores_codigos_postales (id_repartidor, codigo_postal) VALUES (?, ?)";
            statement = conexion.prepareStatement(consulta);

            for (RepartidorCodigoPostal repartidorCodigoPostal : repartidoresCodigosPostales) {
                statement.setInt(1, repartidorCodigoPostal.getIdRepartidor());
                statement.setString(2, repartidorCodigoPostal.getCodigoPostal());

                statement.addBatch(); // Agregar la consulta al lote
            }

            statement.executeBatch(); // Ejecutar todas las consultas en el lote
            conexion.commit(); // Confirmar la transacción

            System.out.println("Se insertaron todos los códigos postales de los repartidores correctamente.");
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

