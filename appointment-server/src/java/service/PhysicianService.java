/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import domain.PhysicianManager;
import java.util.List;
import components.data.Physician;
import javax.ws.rs.core.MediaType;
/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("physicians")
public class PhysicianService {
    private PhysicianManager physicianManager;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PhysicianService
     */
    public PhysicianService() {
        physicianManager = new PhysicianManager();
    }

    /**
     * Retrieves all the physicians
     * @return List<Physician>
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Physician> get() {
        return physicianManager.getPhysicians();
    }
    
    /**
     * Retrieves the physicians that match the given physicianId
     * @param physicianId String
     * @return Physician
     */
    @GET
    @Path("{physicianId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Physician get(@PathParam("physicianId") String physicianId){
        return physicianManager.getPhysicianById(physicianId);
    }

    /**
     * PUT method for updating or creating an instance of PhysicianService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
  /*  @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }*/
}
