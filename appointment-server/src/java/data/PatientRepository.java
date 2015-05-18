
package data;
import components.data.IComponentsData;
import components.data.DB;
import components.data.Patient;
import components.data.Physician;
import java.util.*;

/**
 * This repository class is used to provide data access to Patient
 * @author sabreu
 */
public class PatientRepository extends BaseRepository<Patient> implements IRepository<Patient> {
    /**
     * Get all the patients from the database.
     * @return List<Patient> 
     */
    public List<Patient> get(){
        return super.get();
    }
    
    /**
     * Returns the patient that match the given id
     * @param patiendId String
     * @return Patient
     */
    public Patient getById(String patiendId){
        return super.getById(patiendId);
    }
    
    public boolean save(Patient patientToSave) {
        return super.save(patientToSave);
    }
}
