package domain;
import components.data.Diagnosis;
import data.DiagnosisRepository;
/**
 *
 * @author sabreu
 */
public class DiagnosisManager extends BaseManager<Diagnosis> {
    
    public DiagnosisManager (){
        this.reposiroty = new DiagnosisRepository();
    }
}

