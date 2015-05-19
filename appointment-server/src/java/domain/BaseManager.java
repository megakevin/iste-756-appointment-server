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
 * @param <T>
 */
public abstract class BaseManager<T> implements IManager<T> 
{
    protected IRepository<T> reposiroty;
    
    @Override
    public List<T> getEntities(){
        return this.reposiroty.get();
    }
    
    @Override
    public List<T> getEntities(String condition, String value){
        return this.reposiroty.get(condition, value);
    }

    @Override
    public T getEntityById(String id){
        return this.reposiroty.getById(id);
    }
    
    @Override
    public OperationResultModel updateEntity(T enityToUpdate)
    {
        return new OperationResultModel(this.reposiroty.update(enityToUpdate));
    }
    
    @Override
    public OperationResultModel saveEntity(T entityToSave)
    {
        return new OperationResultModel(this.reposiroty.save(entityToSave));
    }
    
}
