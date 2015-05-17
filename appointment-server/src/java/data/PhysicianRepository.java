/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import components.data.Physician;
import java.util.List;
/**
 *
 * @author sabreu
 */
public class PhysicianRepository extends BaseRepository<Physician> implements IRepository<Physician>{

    @Override
    public List<Physician> get() {
        return super.get();
    }

    @Override
    public Physician getById(String id) {
        return super.getById(id);
    }

    @Override
    public boolean save(Physician data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Physician data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
