package data;
import components.data.PSC;
import java.util.List;
/**
 *
 * @author sabreu
 */
public class PatientServiceCenterRepository extends BaseRepository<PSC>  implements IRepository<PSC> {

    @Override
    public List<PSC> get() {
        return super.get();
    }

    @Override
    public PSC getById(String id) {
        return super.getById(id);
    }

    @Override
    public boolean save(PSC data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PSC data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

