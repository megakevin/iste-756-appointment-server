package service;

import javax.ws.rs.Path;
import components.data.Phlebotomist;
import domain.PhlebotomistManager;
/**
 * REST Web Service
 *
 * @author sabreu
 */
@Path("phlebotomists")
public class PhlebotomistService extends BaseService<Phlebotomist> {
    /**
     * Creates a new instance of PatientService
     */
    public PhlebotomistService() {
        this.manager = new PhlebotomistManager();
    }
}
