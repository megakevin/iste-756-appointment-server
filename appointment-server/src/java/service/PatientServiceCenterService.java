package service;

import javax.ws.rs.Path;
import components.data.PSC;
import domain.PatientServiceCenterManager;
/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("servicecenters")
public class PatientServiceCenterService extends BaseService<PSC> {
    /**
     * Creates a new instance of PatientService
     */
    public PatientServiceCenterService() {
        this.manager = new PatientServiceCenterManager();
    }
}
