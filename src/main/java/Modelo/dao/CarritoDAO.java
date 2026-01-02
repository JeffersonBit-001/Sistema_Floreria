/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.dao;

import Servicio.DBConexion;
import Modelo.dto.Carrito;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase CarritoDAO se encarga de gestionar las operaciones de acceso a datos
 * relacionadas con el carrito de compras, como agregar, eliminar y listar
 * productos en el carrito.
 */
public class CarritoDAO {

    private Connection cnx;

    public CarritoDAO() {
        cnx = new DBConexion().getConnection();
    }

    public boolean save(Carrito carrito) {
        // Incluir el campo precio en la consulta SQL
        String sql = "INSERT INTO carrito (user_id, flor_id, cantidad, precio) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, carrito.getUserId());
            ps.setInt(2, carrito.getFlorId());
            ps.setInt(3, carrito.getCantidad());
            ps.setDouble(4, carrito.getPrecio());  // Añadir el precio al PreparedStatement

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Carrito get(int id) {
        Carrito c = null;
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT ca.carrito_id, ca.cantidad, "
                + "f.flor_id, f.nombre AS nombre_flor, f.precio, "
                + "r.user_id, r.nombre AS nombre_usuario "
                + "FROM carrito ca "
                + "INNER JOIN flores f ON ca.flor_id = f.flor_id "
                + "INNER JOIN register r ON ca.user_id = r.user_id "
                + "WHERE ca.carrito_id = ?";

        try {
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                c = new Carrito();
                c.setIdCarrito(rs.getInt("carrito_id"));
                c.setFlorId(rs.getInt("flor_id"));
                c.setUserId(rs.getInt("user_id"));
                c.setCantidad(rs.getInt("cantidad"));
                c.setPrecio(rs.getDouble("precio"));
                System.out.println("Carrito recuperado: " + c.toString()); // Log para confirmar recuperación
            } else {
                System.out.println("No se encontró un carrito con ID: " + id); // Log para carrito no encontrado
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la consulta para el ID: " + id);
            ex.printStackTrace(); // Log de la excepción
        }
        return c;
    }

    public List<Carrito> getCarritosByUserId(int userId) {
        List<Carrito> carritos = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;

        String sql = "SELECT ca.carrito_id, ca.cantidad, f.flor_id, f.precio, f.nombre "
                + "FROM carrito ca "
                + "INNER JOIN flores f ON ca.flor_id = f.flor_id "
                + "WHERE ca.user_id = ?";

        try {
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();

            while (rs.next()) {
                Carrito carrito = new Carrito();
                carrito.setIdCarrito(rs.getInt("carrito_id"));
                carrito.setFlorId(rs.getInt("flor_id"));
                carrito.setCantidad(rs.getInt("cantidad"));
                carrito.setPrecio(rs.getDouble("precio"));
                carrito.setNombreFlor(rs.getString("nombre")); // Asigna el nombre de la flor

                carritos.add(carrito);
            }

            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error al obtener los carritos: " + ex.getMessage());
        }
        return carritos;
    }

    // Método para actualizar un carrito existente
    public boolean update(Carrito carrito) {
        String sql = "UPDATE carrito SET user_id = ?, flor_id = ?, cantidad = ?, precio = ? WHERE carrito_id = ?";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setInt(1, carrito.getUserId());
            ps.setInt(2, carrito.getFlorId());
            ps.setInt(3, carrito.getCantidad());
            ps.setDouble(4, carrito.getPrecio());
            ps.setInt(5, carrito.getIdCarrito());

            int rowsAffected = ps.executeUpdate();
            System.out.println("Filas afectadas: " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el carrito: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un carrito por ID
    public boolean eliminar(int id) {
        String sql = "DELETE FROM carrito WHERE carrito_id = ?";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el carrito: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

}
