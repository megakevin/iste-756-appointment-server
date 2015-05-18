package data;
import java.util.List;

/**
 * Generic repository to be implemented by the concrete repository implementation 
 * @author sabreu
 */
public interface IRepository<T> {
    List<T> get();
    T getById(String id);
    boolean save(T data);
    boolean update(T data);
    List<T> get(String condition, String value);
}
