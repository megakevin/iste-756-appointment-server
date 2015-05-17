/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import domain.PatientServiceCenterManager;
import components.data.PSC;
import java.util.List;
import javax.ws.rs.core.MediaType;
/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("patientservicecenters")
public class PatientServiceCenterService {
    private PatientServiceCenterManager patientServiceCenterManager;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PatientServiceCenterService
     */
    public PatientServiceCenterService() {
        patientServiceCenterManager = new PatientServiceCenterManager();
    }

    /**
     * Retrieves representation of an instance of data.PatientServiceCenterService
     * @return List<PSC>
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
    public List<PSC> get() {
        return patientServiceCenterManager.getPscs();
    }
    
    @GET
    @Path("{pscId}")
    @Produces({MediaType.APPLICATION_JSON})
    public PSC get(@PathParam("pscId") String pscId){
        return patientServiceCenterManager.getPscById(pscId);
    }

}
