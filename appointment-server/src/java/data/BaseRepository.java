
package data;
import components.data.IComponentsData;
import components.data.DB;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.ArrayList;

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
     * @return 
     */
    public List<T> get(){
        List<T> result = new ArrayList<>();
        List<Object> objs = db.getData(className, "");
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
        return this.db.addData(data);
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
