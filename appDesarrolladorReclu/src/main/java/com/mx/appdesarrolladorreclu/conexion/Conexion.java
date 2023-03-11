/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.appdesarrolladorreclu.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yhady
 */
public class Conexion {

    static Conexion instance;
    private Connection conexion;

    private Conexion() {
        try {

            conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=AdminVacantes", "sa", "123.Hola");

            System.out.println("Conectado con la BD");

        } catch (SQLException e) {
            System.out.println("Error al obtener la conexion:" + e.getMessage());
        }
    }

    static public Conexion getInstance() throws ClassNotFoundException {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getConnection() {
        return conexion;
    }

    public void cerrar() {
        try {
            conexion.close();
            instance = null;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
