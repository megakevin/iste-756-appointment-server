package service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import components.data.Diagnosis;
import domain.DiagnosisManager;
/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("diagnosis")
public class DiagnosisService extends BaseService<Diagnosis> {
    
    public DiagnosisService(){
        this.manager = new DiagnosisManager();
    }
}
