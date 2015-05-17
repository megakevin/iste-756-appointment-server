package data;
import components.data.Phlebotomist;
import java.util.List;
/**
 *
 * @author sabreu
 */
public class PhlebotomistRepository extends BaseRepository<Phlebotomist> implements IRepository<Phlebotomist> {
    

    @Override
    public List<Phlebotomist> get() {
        return super.get();
    }

    @Override
    public Phlebotomist getById(String id) {
        return super.getById(id);
    }

    @Override
    public boolean save(Phlebotomist data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Phlebotomist data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
