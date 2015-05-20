/*
Lookups: Patients, Phlebotomist, PSC, Diagnosis, LabTest
*/
package data;
import components.data.IComponentsData;
import components.data.DB;
import java.util.List;
import viewmodel.LookupModel;
/**
 *
 * @author sabreu
 */
public class LookupRepository {
    private  List<Object> patients;
    private final  List<Object> phlebotomists;
    private final  List<Object> labTests;
    private final  List<Object> diagnoses;
    private final  List<Object> pscs;
    
    private static LookupRepository instance = null;
    IComponentsData db = null;
    
    /**
     * Default constructor, it initializes the parameter list
     */
    private LookupRepository(){
        db = new DB();
        //Load data on initial load
        patients = db.getData("Patient", "");
        phlebotomists = db.getData("Phlebotomist", "");
        labTests = db.getData("LabTest", "");
        diagnoses= db.getData("Diagnosis", "");
        pscs = db.getData("PSC", "");
    }
    
    /**
     * Method to expose the instance of the current repository
     * @return LookupRepository
     */
    public static LookupRepository getInstance(){
        if(instance == null){
            instance = new LookupRepository();
        }
        return instance;
    }
    
    /**
     * Prepare the lookup model with the collections used as parameters
     * @return LookupModel
     */
    public LookupModel getLookup(){
        LookupModel lookupModel = new LookupModel();
        lookupModel.setPatients(patients);
        lookupModel.setPhlebotomists(phlebotomists);
        lookupModel.setDiagnoses(diagnoses);
        lookupModel.setLabTests(labTests);
        lookupModel.setPsc(pscs);
        return lookupModel;
    }
    
    /**
     * Reload the patient list.  This allows the getLookup to return fresh data
     */
    public void patientAddOrUpdate(){
        this.patients = null;
        patients = db.getData("Patient", "");
    }
    

}
