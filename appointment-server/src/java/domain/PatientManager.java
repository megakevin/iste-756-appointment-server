package domain;

import components.data.Patient;
import data.PatientRepository;
/**
 * This class is used to encapsulate all business logic related to patients
 * @author sabreu
 */
public class PatientManager extends BaseManager<Patient> {    
    /**
     * Default constructor. It initializes the PatientRepository
     */
    public PatientManager() {
        this.reposiroty = new PatientRepository();
    }
}
