/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.appdesarrolladorreclu.dao;

import com.mx.appdesarrolladorreclu.conexion.Conexion;
import com.mx.appdesarrolladorreclu.dto.Response;
import com.mx.appdesarrolladorreclu.dto.Vacantes;
import com.mx.appdesarrolladorreclu.dto.Areas;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author Yhady
 */
public class VacantesDao {

    public Object getVacantes() throws ClassNotFoundException {
        String sql = "SELECT v.id_vacante as id_vacante, "
                + "     a.nombre_area as nombre_area, "
                + "     v.nombre as nombre, "
                + "     v.cubierta as vacante "
                + " FROM vacantes v, areas a "
                + " WHERE v.id_area = a.id_area "
                + " ORDER by v.id_vacante asc ";

        Response resp = new Response();
        ArrayList<Vacantes> vacantes = new ArrayList<Vacantes>();
        try {
            Statement query = Conexion.getInstance().getConnection().createStatement();
            ResultSet rs = query.executeQuery(sql);
            while (rs.next()) {
                Vacantes vacante = new Vacantes();
                vacante.setIdVacante(rs.getInt("id_vacante"));

                Areas a = new Areas();
                a.setNommbreArea(rs.getString("nombre_area"));
                vacante.setAreas(a);

                vacante.setNombre(rs.getString("nombre"));
                vacante.setCubierta(rs.getString("cubierta"));

                vacantes.add(vacante);
            }
            rs.close();
            query.close();
            Conexion.getInstance().cerrar();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar:" + sql + ", " + ex.getMessage());
            resp.setEstatus("Error:");
            resp.setMensaje("Error al ejecutar:" + sql);
            return resp;
        }
        if (vacantes.size() > 0) {
            return vacantes;
        } else {
            resp.setEstatus("OK");
            resp.setMensaje("No hay vacantes registradas");
            return resp;
        }
    }

    public Response insertVacante(Vacantes vacante) throws ClassNotFoundException {
        String sql = "{call SP_INSERTA_VACANTE(?,?,?)}";
        Response resp = new Response();
        try {
            CallableStatement cs = Conexion.getInstance().getConnection().prepareCall(sql);
            cs.setInt(1, vacante.getAreas().getIdArea());
            cs.setString(2, vacante.getNombre());
            cs.setString(3, vacante.getCubierta());
            cs.execute();
            resp.setEstatus(cs.getString(5));
            resp.setMensaje(cs.getString(6));
            cs.close();
            Conexion.getInstance().cerrar();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar: " + sql + ", " + ex.getMessage());
        }
        return resp;
    }

    public Response updateVacante(Vacantes vacante) throws ClassNotFoundException {
        String sql = "{call SP_ACTUALIZA_VACANTE(?,?,?,?)}";
        Response resp = new Response();
        try {
            CallableStatement cs = Conexion.getInstance().getConnection().prepareCall(sql);
            cs.setInt(1, vacante.getIdVacante());
            cs.setFloat(2, vacante.getAreas().getIdArea());
            cs.setString(3, vacante.getNombre());
            cs.setString(4, vacante.getCubierta());
            cs.execute();
            resp.setEstatus(cs.getString(3));
            resp.setMensaje(cs.getString(4));
            cs.close();
            Conexion.getInstance().cerrar();
        } catch (SQLException ex) {
            System.out.println("Error al ejecutar: " + sql + ", " + ex.getMessage());
        }
        return resp;
    }

    public Response deleteVacante(int idVacante) throws ClassNotFoundException {
        String sql = "DELETE vacantes WHERE id_vacante = ? ";
        Response resp = new Response();
        try {
            PreparedStatement ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, idVacante);
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
