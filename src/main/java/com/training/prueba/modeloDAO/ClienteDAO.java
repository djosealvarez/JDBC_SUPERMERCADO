package com.training.prueba.modeloDAO;

import com.training.prueba.conexion.ConexionBD;
import com.training.prueba.inteface.ICliente;
import com.training.prueba.modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClienteDAO implements ICliente {

    public void mostrarCliente() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conexion = ConexionBD.getConnection();
            String query = "SELECT * FROM clientes";
            statement = conexion.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " | " +
                        resultSet.getString("cedula") + " | " +
                        resultSet.getString("nombres") + " | " +
                        resultSet.getString("apellidos") + " | " +
                        resultSet.getString("direccion") + " | " +
                        resultSet.getString("telefono") + " | " +
                        resultSet.getString("codigo_postal") + " | " +
                        resultSet.getString("email") + " | " +
                        resultSet.getString("contrasenia"));
            }
        } catch (SQLException e) {
            System.out.println("Error de SQL " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if(statement != null){
                    statement.close();
                }
                if (conexion != null){
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar Conexion "+e.getMessage());
            }
        }
    }

    @Override
    public void insertarClientes(List<Cliente> clientes) {
        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.getConnection();
            String consulta = "INSERT INTO Clientes (id, cedula, nombres, apellidos, direccion, telefono, codigo_postal, email, contrasenia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conexion.prepareStatement(consulta);

            for (Cliente cliente : clientes) {
                statement.setInt(1, cliente.getId());
                statement.setString(2, cliente.getCedula());
                statement.setString(3, cliente.getNombres());
                statement.setString(4, cliente.getApellidos());
                statement.setString(5, cliente.getDireccion());
                statement.setString(6, cliente.getTelefono());
                statement.setString(7, cliente.getCodigoPostal());
                statement.setString(8, cliente.getEmail());
                statement.setString(9, cliente.getContrasenia());

                statement.addBatch(); // Agregar la consulta al lote
            }

            int[] filasInsertadas = statement.executeBatch();

            System.out.println("Se insertaron " + filasInsertadas.length + " clientes correctamente.");
        } catch (SQLException e) {
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
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    }




