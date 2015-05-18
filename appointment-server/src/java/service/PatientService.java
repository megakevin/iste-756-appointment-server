package service;

import javax.ws.rs.Path;
import components.data.Patient;
import domain.PatientManager;
/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("patients")
public class PatientService extends BaseService<Patient> {
    /**
     * Creates a new instance of PatientService
     */
    public PatientService() {
        this.manager = new PatientManager();
    }
}
