/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.appdesarrolladorreclu.dao;

import com.mx.appdesarrolladorreclu.conexion.Conexion;
import com.mx.appdesarrolladorreclu.dto.Areas;
import com.mx.appdesarrolladorreclu.dto.Estatus;
import com.mx.appdesarrolladorreclu.dto.Prospectos;
import com.mx.appdesarrolladorreclu.dto.Response;
import com.mx.appdesarrolladorreclu.dto.Vacantes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Yhady
 */
public class ProspectosDao {
    
    public Object getProspectoByNombre(String nombre) throws ClassNotFoundException{
        String sql = "SELECT id_prospecto, "
                + "     nombre_prospecto, "
                + "     nombre_area, "
                + "	nombre_vacante, "
                + "	estatus_vacante "
                + "FROM VW_PROSPECTOS "
                + "WHERE nombre_prospecto = ? ";

        Response resp = new Response();
        Prospectos prospecto;
        ArrayList<Prospectos> prospectos = new ArrayList<Prospectos>();
        try {
            PreparedStatement ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prospecto = new Prospectos();
                prospecto.setIdProspecto(rs.getInt("id_prospecto"));
                prospecto.setNombre(rs.getString("nombre"));
                
                Vacantes v = new Vacantes();
                v.setNombre(rs.getString("nombre_vacante"));
                
                Areas a = new Areas();
                a.setNombreArea(rs.getString("nombre_area"));
                v.setAreas(a);
                prospecto.setVacantes(v);
                
                Estatus e = new Estatus();
                e.setDescripcion(rs.getString("estatus_vacante"));
                prospecto.setEstatusVacante(e);
 
                prospectos.add(prospecto);
            }
            rs.close();
            ps.close();
            Conexion.getInstance().cerrar();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar:" + sql + ", " + ex.getMessage());
            resp.setEstatus("Error:");
            resp.setMensaje("Error al ejecutar:" + sql);
            return resp;
        }
        if (prospectos.size() > 0) {
            return prospectos;
        } else {
            resp.setEstatus("OK");
            resp.setMensaje("No hay prospecto registrado");
            return resp;
        }
    }
        
    public Response InsertProspecto(Prospectos prospecto) throws ClassNotFoundException {
        String sql = "INSERT INTO prospectos (id_vacante, nombre, edad) VALUES  (?, ?, ?) ";
        
        Response resp = new Response();
        try {
            PreparedStatement ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, prospecto.getVacantes().getIdVacante());
            ps.setString(2, prospecto.getNombre());
            ps.setInt(3, prospecto.getEdad());
            ps.execute();

            resp.setEstatus("OK:");
            resp.setMensaje("Proceso realizado correctamente.");
            ps.close();
            Conexion.getInstance().cerrar();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar:" + sql + ", " + ex.getMessage());
            resp.setEstatus("Error:");
            resp.setMensaje("Error al ejecutar:" + sql);
        }
        return resp;
    }
    
        public Response UpdateProspectoEstatusVacante(Prospectos prospecto) throws ClassNotFoundException {
        String sql = "UPDATE prospectos SET estatus_vacante = ? WHERE id_prospecto = ? ";
        
        Response resp = new Response();
        try {
            PreparedStatement ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, prospecto.getEstatusVacante().getIdEstatus());
            ps.setInt(2, prospecto.getIdProspecto());
            ps.execute();

            resp.setEstatus("OK:");
            resp.setMensaje("Proceso realizado correctamente.");
            ps.close();
            Conexion.getInstance().cerrar();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar:" + sql + ", " + ex.getMessage());
            resp.setEstatus("Error:");
            resp.setMensaje("Error al ejecutar:" + sql);
        }
        return resp;
    }
    
        public Response UpdateProspecto(Prospectos prospecto) throws ClassNotFoundException {
        String sql = "UPDATE prospectos "
                + "     SET id_vacante = ?, "
                + "         nombre = ?, "
                + "         edad = ?, "
                + "         estatus_vacante = ? "
                + " WHERE id_prospecto = ? ";
        
        Response resp = new Response();
        try {
            PreparedStatement ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, prospecto.getVacantes().getIdVacante());
            ps.setString(2, prospecto.getNombre());
            ps.setInt(3, prospecto.getEdad());
            ps.setInt(4, prospecto.getEstatusVacante().getIdEstatus());
            ps.setInt(5, prospecto.getIdProspecto());
            ps.execute();

            resp.setEstatus("OK:");
            resp.setMensaje("Proceso realizado correctamente.");
            ps.close();
            Conexion.getInstance().cerrar();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar:" + sql + ", " + ex.getMessage());
            resp.setEstatus("Error:");
            resp.setMensaje("Error al ejecutar:" + sql);
        }
        return resp;
    }
    
    public Response deleteProspecto(int idProspecto) throws ClassNotFoundException {
        String sql = "DELETE prospecto WHERE id_prospecto = ? ";
        Response resp = new Response();
        try {
            PreparedStatement ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, idProspecto);
            ps.execute();

            resp.setEstatus("OK:");
            resp.setMensaje("Proceso realizado correctamente.");
            ps.close();
            Conexion.getInstance().cerrar();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar:" + sql + ", " + ex.getMessage());
            resp.setEstatus("Error:");
            resp.setMensaje("Error al ejecutar:" + sql);
        }
        return resp;
    }
}
