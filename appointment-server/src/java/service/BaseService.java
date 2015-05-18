/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.IManager;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import viewmodel.OperationResultModel;

/**
 *
 * @author Kevin
 */
public abstract class BaseService<T> implements IService<T> {
    
    protected IManager<T> manager;
            
    @Context
    protected UriInfo context;

    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
    public List<T> get() {
        return this.manager.getEntities();
    }
    
    @GET
    @Path("{condition}/{value}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public List<T> get(@PathParam("condition") String condition, @PathParam("value") String value){
        return this.manager.getEntities(condition, value);
    }

    @GET
    @Path("{entityId}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public T get(@PathParam("entityId") String entityId){
        return this.manager.getEntityById(entityId);
    }
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON}) 
    public OperationResultModel put(T entityToUpdate) {
        /*
        this will work sending JSON like this:
        
        {  
            "address":"31 Westbrook Drive",
            "dateofbirth":"1959-09-22T00:00:00-04:00",
            "id":"210",
            "insurance":"Y",
            "name":"Tom Thumb",
            "physician":
            {  
                "id":"10",
                "name":"Dr. Howard"
            }
        }
        
        This is identical to the JSON that GET returns. woot.
        */
        return this.manager.updateEntity(entityToUpdate);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON}) 
    public OperationResultModel post(T entityToSave){
        return this.manager.saveEntity(entityToSave);
    }
    
}
