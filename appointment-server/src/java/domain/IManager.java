/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import viewmodel.OperationResultModel;

/**
 * @author Kevin
 */
public interface IManager<T> {
    public List<T> getEntities();
    public T getEntityById(String id);
    public OperationResultModel updateEntity(T entityToUpdate);
    public OperationResultModel saveEntity(T entityToSave);
}
