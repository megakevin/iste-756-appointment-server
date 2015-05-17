/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;
import java.text.*;
import components.data.*;
import viewmodel.AppointmentModel;

/**
 *
 * @author kevin
 */
public class AppointmentRepository extends BaseRepository<Appointment>{
    
    private IComponentsData db;
    
    public AppointmentRepository()
    {
        this.db = new DB();
     //   this.db.initialLoad("LAMS");
    }
    
    @Override
    public List<Appointment> get(){
        return super.get();
    }

    @Override
    public Appointment getById(String appointmentId){
        return super.getById(appointmentId);
    }
}
