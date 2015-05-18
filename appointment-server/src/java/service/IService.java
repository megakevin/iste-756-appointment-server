/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import viewmodel.OperationResultModel;

/**
 *
 * @author Kevin
 */
public interface IService<T> {
    public List<T> get();
    public T get(String id);
    public List<T> get(String condition, String value);
    public OperationResultModel put(T entityToUpdate);
    public OperationResultModel post(T entityToSave);    
}
