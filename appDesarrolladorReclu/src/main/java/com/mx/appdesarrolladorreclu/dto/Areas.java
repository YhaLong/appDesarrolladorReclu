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
public class Areas {

    private int idArea;
    private String cveArea;
    private String nombreArea;

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getCveArea() {
        return cveArea;
    }

    public void setCveArea(String cveArea) {
        this.cveArea = cveArea;
    }

    public String getNommbreArea() {
        return nombreArea;
    }

    public void setNommbreArea(String nommbreArea) {
        this.nombreArea = nommbreArea;
    }

    public void setNombreArea(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
