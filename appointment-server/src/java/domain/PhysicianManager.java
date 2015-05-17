/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import data.PhysicianRepository;
import components.data.Physician;
import java.util.List;
/**
 *
 * @author sabreu
 */
public class PhysicianManager {
    private PhysicianRepository physicianRepository;
    
    public PhysicianManager(){
        physicianRepository = new PhysicianRepository();
    }
    
    
    public List<Physician> getPhysicians(){
        return physicianRepository.get();
    }
    
    public Physician getPhysicianById(String id){
        return physicianRepository.getById(id);
    }
}
