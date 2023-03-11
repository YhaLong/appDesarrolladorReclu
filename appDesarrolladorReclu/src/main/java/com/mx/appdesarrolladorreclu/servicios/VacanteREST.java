/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mx.appdesarrolladorreclu.servicios;

import com.google.gson.Gson;
import com.mx.appdesarrolladorreclu.dao.VacantesDao;
import com.mx.appdesarrolladorreclu.dto.Response;
import com.mx.appdesarrolladorreclu.dto.Vacantes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Yhady
 */
@Path("/Vacante")
public class VacanteREST {

    @Context
    private UriInfo context;
    Gson gson;
    VacantesDao vacantesDao;
    Response response;

    /**
     * Creates a new instance of VacanteREST
     */
    public VacanteREST() {
        gson = new Gson();
        vacantesDao = new VacantesDao();
        response = new Response();
    }

    /**
     * Servicio de prueba
     *
     * @return
     */
    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "Hello world servicio REST";
    }

    /**
     * Consulta vacantes
     *
     * @return
     * @throws ClassNotFoundException
     */
    @GET
    @Path("/ConsultarVacantes")
    @Produces(MediaType.APPLICATION_JSON)
    public String getVacantes() throws ClassNotFoundException {
        Object objeto = vacantesDao.getVacantes();
        return gson.toJson(objeto);
    }

    /**
     * Registro de vacante
     *
     * @param json
     * @return
     * @throws ClassNotFoundException
     */
    @POST
    @Path("/Registro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String insertVacante(String json) throws ClassNotFoundException {
        Vacantes vacante = gson.fromJson(json, Vacantes.class);
        response = vacantesDao.insertVacante(vacante);
        return gson.toJson(response);
    }

    /**
     * Actualizar vacante
     *
     * @param json
     * @return
     * @throws ClassNotFoundException
     */
    @PUT
    @Path("/Actualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateVacante(String json) throws ClassNotFoundException {
        Vacantes vacante = gson.fromJson(json, Vacantes.class);
        response = vacantesDao.updateVacante(vacante);
        return gson.toJson(response);
    }

    /**
     * Eliminar vacante
     *
     * @param idVacante
     * @return
     * @throws ClassNotFoundException
     */
    @DELETE
    @Path("/Eliminar/{idVacante}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteVacante(@PathParam("idVacante") int idVacante) throws ClassNotFoundException {
        response = vacantesDao.deleteVacante(idVacante);
        return gson.toJson(response);
    }
}
