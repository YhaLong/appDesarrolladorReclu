/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.appdesarrolladorreclu.servicios;

import com.google.gson.Gson;
import com.mx.appdesarrolladorreclu.dao.ProspectosDao;
import com.mx.appdesarrolladorreclu.dto.Prospectos;
import com.mx.appdesarrolladorreclu.dto.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Yhady
 */
@Path("Prospecto")
public class ProspectoREST {

    @Context
    private UriInfo context;
    Gson gson;
    ProspectosDao prospectosDao;
    Response response;

    /**
     * Creates a new instance of ProspectoREST
     */
    public ProspectoREST() {
        gson = new Gson();
        prospectosDao = new ProspectosDao();
        response = new Response();
    }

    /**
     * Consulta de prospecto por nombre
     *
     * @param nombre
     * @return
     * @throws ClassNotFoundException
     */
    @GET
    @Path("/ConsultarProspecto/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProspectoByNombre(@PathParam("nombre") String nombre) throws ClassNotFoundException {
        Object objeto = prospectosDao.getProspectoByNombre(nombre);
        return gson.toJson(objeto);
    }

    /**
     * Registro de prospecto
     * @param json
     * @return
     * @throws ClassNotFoundException 
     */
    @POST
    @Path("/Registro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertProspecto(String json) throws ClassNotFoundException {
        Prospectos prospecto = gson.fromJson(json, Prospectos.class);
        response = prospectosDao.InsertProspecto(prospecto);
        return gson.toJson(response);
    }

    /**
     * Actualizacion de prospecto
     * 
     * @param json
     * @return
     * @throws ClassNotFoundException 
     */
    @PUT
    @Path("/Actualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateProspecto(String json) throws ClassNotFoundException {
        Prospectos prospecto = gson.fromJson(json, Prospectos.class);
        response = prospectosDao.UpdateProspecto(prospecto);
        return gson.toJson(response);
    }

    /**
     * Actualizacion de estatus de vacante del prospecto
     * @param json
     * @return
     * @throws ClassNotFoundException 
     */
    @PUT
    @Path("/ActualizarEstatusVacante")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String UpdateProspectoEstatusVacante(String json) throws ClassNotFoundException {
        Prospectos prospecto = gson.fromJson(json, Prospectos.class);
        response = prospectosDao.UpdateProspectoEstatusVacante(prospecto);
        return gson.toJson(response);
    }

    /**
     * Eliminar prospecto
     * @param idProspecto
     * @return
     * @throws ClassNotFoundException 
     */
    @DELETE
    @Path("/Eliminar/{idProspecto}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteProspecto(@PathParam("idProspecto") int idProspecto) throws ClassNotFoundException {
        response = prospectosDao.deleteProspecto(idProspecto);
        return gson.toJson(response);
    }
}
