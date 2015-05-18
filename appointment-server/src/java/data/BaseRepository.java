/**
 * This base repository provides an abstraction for the data layer. It also a wrapper for the provided data layer.
 */
package data;
import components.data.IComponentsData;
import components.data.DB;
import components.data.Patient;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sabreu
 * @param <T>
 */
public abstract class BaseRepository<T> implements IRepository<T> {
    protected IComponentsData db;
    private Class<T> typeOfT;
    private String className;
    
    /**
     * Default constructor.
     */
    public BaseRepository(){
        db = new DB();
          this.typeOfT = (Class<T>)
                ((ParameterizedType)getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
          className = getClassName();
    }
    
    /**
     * Gets all the records of a given type from the database.
     * @return List<T>
     */
    @Override
    public List<T> get(){
        List<T> result = new ArrayList<>();
        List<Object> objs = db.getData(className, "");
        for(Object obj: objs){
            result.add((T)obj);
        }
        return result;
    }
    
    /**
     * Retrieves data that match a given condition
     * @param condition String
     * @param value String
     * @return List<T>
     */
    @Override
    public List<T> get(String condition, String value){
        List<T> result = new ArrayList<>();
        List<Object> objs = db.getData(className, String.format("%s='%s'",condition, value));
        for(Object obj: objs){
            result.add((T)obj);
        }
        return result;
    }
    
    /**
     * Gets a given type by Id
     * @param id
     * @return T object
     */
    @Override
    public T getById(String id) {
        T result = null;
        List<Object> objs = db.getData(className, String.format("id='%s'", id));
        if(objs!=null && objs.size()>=0)
            result = (T)objs.get(0);
        return result;
    }

    @Override
    public boolean save(T data) {
        try 
        {
            List<T> entities = this.get();

            entities.sort(new Comparator<T>() {
                @Override
                public int compare(T p1, T p2) {
                    try {
                        return (Integer.parseInt((String)typeOfT.getMethod("getId", null).invoke(p2, null)) >
                                Integer.parseInt((String)typeOfT.getMethod("getId", null).invoke(p1, null))) ? 1 : -1;
                    } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        Logger.getLogger(BaseRepository.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    return 0;
                }
            });        

            String newId = Integer.toString(
                    Integer.parseInt(
                            (String)typeOfT.getMethod("getId", null).invoke(entities.get(0), null)) + 10);

            typeOfT.getMethod("setId", String.class).invoke(data, newId);

            return this.db.addData(data);
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    @Override
    public boolean update(T data) {
        return this.db.updateData(data);
    }
    
    /**
     * Get the name of the current class pass in the generic
     * @return String
     */
    private String getClassName(){
       return typeOfT.getSimpleName();
   }
}
