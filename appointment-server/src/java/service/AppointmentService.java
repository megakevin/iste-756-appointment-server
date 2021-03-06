/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import components.data.Appointment;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import viewmodel.AppointmentModel;


import domain.AppointmentManager;
import java.util.List;
import viewmodel.AppointmentPostModel;
import viewmodel.OperationResultModel;

/**
 * REST Web Service
 *
 * @author kevin
 */

@Path("appointments")
public class AppointmentService {

    @Context
    private UriInfo context;
    
    private AppointmentManager appointmentManager;

    /**
     * Creates a new instance of Appointment
     */
    public AppointmentService() 
    {
        this.appointmentManager = new AppointmentManager();
    }

    /**
     * Retrieves representation of an instance of service.Appointment
     * @return an instance of ArrayList<components.data.Appointment> 
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
    public List<AppointmentModel> get() {        
        List<AppointmentModel> appointments = appointmentManager.getAppointments();         
        return appointments;
    }
    
    @GET
    @Path("{appointmentId}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public AppointmentModel get(@PathParam("appointmentId") String appointmentId)
    {    
        return appointmentManager.getAppointmentById(appointmentId);
    }

    /**
     * PUT method for updating or creating an instance of Appointment
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public OperationResultModel put(AppointmentPostModel appointmentPost) {
        return appointmentManager.update(appointmentPost);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public OperationResultModel post(AppointmentPostModel appointmentPost) {
        return appointmentManager.save(appointmentPost);
    }
}
