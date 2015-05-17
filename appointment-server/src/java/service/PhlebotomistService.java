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
import java.util.List;
import data.PhlebotomistRepository;
import components.data.Phlebotomist;
/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("phlebotomists")
public class PhlebotomistService {
    private PhlebotomistRepository phlebotomistRepository;
    
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PhlebotomistService
     */
    public PhlebotomistService() {
        phlebotomistRepository = new PhlebotomistRepository();
    }

    /**
     * Retrieves representation of an instance of service.PhlebotomistService
     * @return an instance of List<Phlebotomist>
     */
    @GET
    @Produces("application/json")
    public List<Phlebotomist> get() {
        return phlebotomistRepository.get();
    }

    /**
     * PUT method for updating or creating an instance of PhlebotomistService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
