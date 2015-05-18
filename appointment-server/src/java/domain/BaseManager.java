/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

import data.IRepository;
import viewmodel.OperationResultModel;

/**
 *
 * @author Kevin
 */
public abstract class BaseManager<T> implements IManager<T> 
{
    protected IRepository<T> reposiroty;
    
    public List<T> getEntities(){
        return this.reposiroty.get();
    }
    
    public List<T> getEntities(String condition, String value){
        return this.reposiroty.get(condition, value);
    }

    public T getEntityById(String id){
        return this.reposiroty.getById(id);
    }
    
    public OperationResultModel updateEntity(T enityToUpdate)
    {
        return new OperationResultModel(this.reposiroty.update(enityToUpdate));
    }
    
    public OperationResultModel saveEntity(T entityToSave)
    {
        return new OperationResultModel(this.reposiroty.save(entityToSave));
    }
    
}
