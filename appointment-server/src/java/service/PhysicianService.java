package service;

import javax.ws.rs.Path;
import components.data.Physician;
import domain.PhysicianManager;
/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("physicians")
public class PhysicianService extends BaseService<Physician> {
    /**
     * Creates a new instance of PatientService
     */
    public PhysicianService() {
        this.manager = new PhysicianManager();
    }
}
