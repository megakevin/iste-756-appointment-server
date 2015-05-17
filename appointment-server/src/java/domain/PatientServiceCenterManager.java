/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import components.data.PSC;
import data.PatientServiceCenterRepository;
import java.util.List;
/**
 *
 * @author sabreu
 */
public class PatientServiceCenterManager {
    private PatientServiceCenterRepository patientServiceCenterRepository;
    
    public PatientServiceCenterManager(){
        patientServiceCenterRepository = new PatientServiceCenterRepository();
    }
    
    public List<PSC> getPscs(){
        return patientServiceCenterRepository.get();
    }
    
    
    public PSC getPscById(String id){
        return patientServiceCenterRepository.getById(id);
    }
}
