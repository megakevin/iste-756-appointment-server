package domain;
import components.data.LabTest;
import data.LabTestRepository;
/**
 *
 * @author sabreu
 */
public class LabTestManager extends BaseManager<LabTest> {
    
    public LabTestManager(){
        this.reposiroty = new LabTestRepository();
    }
}
