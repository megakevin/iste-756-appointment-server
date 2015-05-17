package service;

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
import java.awt.PageAttributes;
import java.util.List;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("servicecenters")
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
     * Retrieves all the Patient Service Centers
     * @return List<PSC>
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
    public List<PSC> get() {
        return patientServiceCenterManager.getPscs();
    }

    /**
     * Retrieves a single Patient Service Center
     * @param serviceCenterId String
     * @return PSC
     */
    @GET
    @Path("{serviceCenterId}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public PSC get(@PathParam("serviceCenterId") String serviceCenterId) {
        return patientServiceCenterManager.getPscById(serviceCenterId);
    }
}
