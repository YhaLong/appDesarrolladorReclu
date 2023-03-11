/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.appdesarrolladorreclu.dto;

/**
 *
 * @author Yhady
 */
public class Prospectos {

    private int idProspecto;
    private Vacantes vacantes;
    private String nombre;
    private int edad;
    private Estatus estatusVacante;

    public int getIdProspecto() {
        return idProspecto;
    }

    public void setIdProspecto(int idProspecto) {
        this.idProspecto = idProspecto;
    }

    public Vacantes getVacantes() {
        return vacantes;
    }

    public void setVacantes(Vacantes vacantes) {
        this.vacantes = vacantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Estatus getEstatusVacante() {
        return estatusVacante;
    }

    public void setEstatusVacante(Estatus estatusVacante) {
        this.estatusVacante = estatusVacante;
    }

}
