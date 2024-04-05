package com.training.prueba.modeloDAO;

import com.training.prueba.conexion.ConexionBD;
import com.training.prueba.inteface.IAlmacenista;
import com.training.prueba.modelo.Almacenista;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AlmacenistaDAO implements IAlmacenista {
        @Override
        public void mostrarAlmacenistas() {
            Connection conexion = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                conexion = ConexionBD.getConnection();
                String consulta = "SELECT * FROM Almacenistas";
                statement = conexion.prepareStatement(consulta);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") +
                            ", Nombre: " + resultSet.getString("nombre"));
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
        public void insertarAlmacenistas(List<Almacenista> almacenistas) {
            Connection conexion = null;
            PreparedStatement statement = null;

            try {
                conexion = ConexionBD.getConnection();
                conexion.setAutoCommit(false); // Deshabilitar el modo de autocommit

                String consulta = "INSERT INTO Almacenistas (id, nombre) VALUES (?, ?)";
                statement = conexion.prepareStatement(consulta);

                for (Almacenista almacenista : almacenistas) {
                    statement.setInt(1, almacenista.getId());
                    statement.setString(2, almacenista.getNombre());

                    statement.addBatch(); // Agregar la consulta al lote
                }

                statement.executeBatch(); // Ejecutar todas las consultas en el lote
                conexion.commit(); // Confirmar la transacción

                System.out.println("Se insertaron todos los almacenistas correctamente.");
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

