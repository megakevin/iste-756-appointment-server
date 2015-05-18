package service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import components.data.Patient;
import domain.PatientManager;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import viewmodel.OperationResultModel;
/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("patients")
public class PatientService {
    private PatientManager patientManager;
            
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PatientService
     */
    public PatientService() {
        patientManager = new PatientManager();
    }

    /**
     * Retrieves all patients
     * @return List<Patient>
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
    public List<Patient> get() {
        return patientManager.getPatients();
    }
    
    /**
     * Retrieves the patient that match the given id
     * @param patientId
     * @return Patient
     */
    @GET
    @Path("{patientId}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public Patient get(@PathParam("patientId") String patientId){
        return patientManager.getPatientById(patientId);
    }

    /**
     * PUT method for updating or creating an instance of PatientService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON}) 
    public OperationResultModel put(Patient patient) {
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
        return this.patientManager.updatePatient(patient);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON}) 
    public OperationResultModel post(Patient patient){
        return this.patientManager.savePatient(patient);
    }
}
