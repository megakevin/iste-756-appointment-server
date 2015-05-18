package domain;

import components.data.Phlebotomist;
import data.PhlebotomistRepository;
/**
 * This class is used to encapsulate all business logic related to patients
 * @author sabreu
 */
public class PhlebotomistManager extends BaseManager<Phlebotomist> {    
    /**
     * Default constructor. It initializes the PatientRepository
     */
    public PhlebotomistManager() {
        this.reposiroty = new PhlebotomistRepository();
    }
}