/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import data.PhlebotomistRepository;
import components.data.Phlebotomist;
import java.util.List;
/**
 *
 * @author sabreu
 */
public class PhlebotomistManager {
    private PhlebotomistRepository phlebotomistRepository;
    
    public PhlebotomistManager(){
        phlebotomistRepository = new PhlebotomistRepository();
    }
    
    /**
     * Retrieves all the Phlebotomists
     * @return List<Phlebotomist> 
     */
    public List<Phlebotomist> getPhlebotomists(){
        return phlebotomistRepository.get();
    }
    
    /**
     * Retrieves the phlobotomist that match the current id
     * @param id String
     * @return Phlebotomist
     */
    public Phlebotomist getPhlebotomistById(String id){
        return phlebotomistRepository.getById(id);
    }
}
