/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.dao;

/**
 *
 * @author Joaquin
 */
import Servicio.DBConexion;
import Modelo.dto.Categorias;
import java.sql.*;

/**
 * La clase CategoriasDAO se encarga de las operaciones de acceso a datos
 * relacionadas con las categorías de productos, incluyendo la creación,
 * actualización y eliminación de categorías.
 */
public class CategoriasDAO {

    private Connection cnx;

    public CategoriasDAO() {
        cnx = new DBConexion().getConnection();
    }

    public Categorias get(int id) {
        Categorias categoria = null;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM categorias WHERE categoria_id = ?";
        try {
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                categoria = new Categorias(
                        rs.getInt("categoria_id"),
                        rs.getString("nombre")
                );
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categoria;
    }

    // Método para eliminar una categoría por ID
    public boolean eliminar(int id) {
        String sql = "DELETE FROM categorias WHERE categoria_id = ?";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la categoría: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

// Método para actualizar una categoría existente
    public boolean update(Categorias categoria) {
        String sql = "UPDATE categorias SET nombre = ? WHERE categoria_id = ?";
        try (PreparedStatement ps = cnx.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombre());
            ps.setInt(2, categoria.getCategoriaId());

            int rowsAffected = ps.executeUpdate();
            System.out.println("Filas afectadas: " + rowsAffected);
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la categoría: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

}
