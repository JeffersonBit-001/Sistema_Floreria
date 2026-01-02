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
import Modelo.dto.Flores_Categorias;
import java.sql.*;

/**
 * La clase Flores_CategoriasDAO se encarga de gestionar las operaciones de acceso a datos 
 * para la relación entre flores y categorías, permitiendo agregar, actualizar y 
 * consultar estas relaciones.
 */

public class Flores_CategoriasDAO {
    private Connection cnx;

    public Flores_CategoriasDAO() {
        cnx = new DBConexion().getConnection();
    }

     public Flores_Categorias getDetalles(int florId, int categoriaId) {
        Flores_Categorias fc = null;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT f.nombre AS flor_nombre, c.nombre AS categoria_nombre " +
                     "FROM flores_categorias fc " +
                     "JOIN flores f ON fc.flor_id = f.flor_id " +
                     "JOIN categorias c ON fc.categoria_id = c.categoria_id " +
                     "WHERE fc.flor_id = ? AND fc.categoria_id = ?";
        try {
            ps = cnx.prepareStatement(sql);
            ps.setInt(1, florId);
            ps.setInt(2, categoriaId);
            rs = ps.executeQuery();

            if (rs.next()) {
                fc = new Flores_Categorias(
                    florId,
                    categoriaId,
                    rs.getString("flor_nombre"),
                    rs.getString("categoria_nombre")
                );
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return fc;
    }
     
     // Método para eliminar una relación entre flor y categoría
public boolean eliminar(int florId, int categoriaId) {
    String sql = "DELETE FROM flores_categorias WHERE flor_id = ? AND categoria_id = ?";
    try (PreparedStatement ps = cnx.prepareStatement(sql)) {
        ps.setInt(1, florId);
        ps.setInt(2, categoriaId);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException ex) {
        System.out.println("Error al eliminar la relación flor-categoría: " + ex.getMessage());
        ex.printStackTrace();
        return false;
    }
}

// Método para actualizar una relación entre flor y categoría
public boolean update(Flores_Categorias fc) {
    String sql = "UPDATE flores_categorias SET flor_id = ?, categoria_id = ? WHERE flor_id = ? AND categoria_id = ?";
    try (PreparedStatement ps = cnx.prepareStatement(sql)) {
        ps.setInt(1, fc.getFlorId());
        ps.setInt(2, fc.getCategoriaId());
        ps.setInt(3, fc.getFlorId());
        ps.setInt(4, fc.getCategoriaId());

        int rowsAffected = ps.executeUpdate();
        System.out.println("Filas afectadas: " + rowsAffected);
        return rowsAffected > 0;
    } catch (SQLException ex) {
        System.out.println("Error al actualizar la relación flor-categoría: " + ex.getMessage());
        ex.printStackTrace();
        return false;
    }
}


}

