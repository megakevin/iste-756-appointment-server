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
import javax.ws.rs.core.MediaType;

import viewmodel.ServiceModel;

@Path("services")
public class ServicesService {

    @Context
    private UriInfo context;
    
    private String introMessage = "Welcome to the LAMS Appointment Service";
    

    /**
     * Creates a new instance of Appointment
     */
    public ServicesService() 
    {
        
    }

    /**
     * Retrieves representation of an instance of service.Appointment
     * @return an instance of ArrayList<components.data.Appointment> 
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
    public ServiceModel get() {
        
        ServiceModel serviceInfo = new ServiceModel(
                this.introMessage,
                this.context.getBaseUri().toString() + "application.wadl"
        );
        
        return serviceInfo;
    }
}
