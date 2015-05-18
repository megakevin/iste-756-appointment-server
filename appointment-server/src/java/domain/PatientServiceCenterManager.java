package domain;

import components.data.PSC;
import data.PatientServiceCenterRepository;
/**
 * This class is used to encapsulate all business logic related to patients
 * @author sabreu
 */
public class PatientServiceCenterManager extends BaseManager<PSC> {    
    /**
     * Default constructor. It initializes the PatientRepository
     */
    public PatientServiceCenterManager() {
        this.reposiroty = new PatientServiceCenterRepository();
    }
}

