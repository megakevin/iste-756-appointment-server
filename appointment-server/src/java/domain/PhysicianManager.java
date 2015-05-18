package domain;

import components.data.Physician;
import data.PhysicianRepository;
/**
 * This class is used to encapsulate all business logic related to patients
 * @author sabreu
 */
public class PhysicianManager extends BaseManager<Physician> {    
    /**
     * Default constructor. It initializes the PatientRepository
     */
    public PhysicianManager() {
        this.reposiroty = new PhysicianRepository();
    }
}