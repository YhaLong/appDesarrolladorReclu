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
public class HistoricoVacantes {

    private int idHistoricoVacante;
    private int idVacante;
    private int idProspecto;
    private String observaciones;

    public int getIdHistoricoVacante() {
        return idHistoricoVacante;
    }

    public void setIdHistoricoVacante(int idHistoricoVacante) {
        this.idHistoricoVacante = idHistoricoVacante;
    }

    public int getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(int idVacante) {
        this.idVacante = idVacante;
    }

    public int getIdProspecto() {
        return idProspecto;
    }

    public void setIdProspecto(int idProspecto) {
        this.idProspecto = idProspecto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
