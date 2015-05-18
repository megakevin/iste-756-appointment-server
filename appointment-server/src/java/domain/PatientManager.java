package domain;
import java.util.List;
import components.data.Patient;
import data.PatientRepository;
import viewmodel.OperationResultModel;

/**
 * This class is used to encapsulate all business logic related to patients
 * @author sabreu
 */
public class PatientManager {
    private PatientRepository patientRepo;
    
    /**
     * Default constructor. It initializes the PatientRepository
     */
    public PatientManager(){
        patientRepo = new PatientRepository();
    }
    
    /**
     * Retrieves the list of patients
     * @return List<Patient>
     */
    public List<Patient> getPatients(){
        return patientRepo.get();
    }
    
    /**
     * Returns the patient that match the given id
     * @param patientId String
     * @return Patient
     */
    public Patient getPatientById(String patientId){
        return patientRepo.getById(patientId);
    }
    
    public OperationResultModel updatePatient(Patient patientToSave)
    {
        return new OperationResultModel(this.patientRepo.update(patientToSave));
    }
}
