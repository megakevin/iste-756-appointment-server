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
    
    public List<Appointment> get(){
        return super.get();
    }
    
    /**
     * Retrieves all the appointments
     * @return 
     */
    public List<AppointmentModel> getAppointmentModels(){
        List<AppointmentModel> appointmentModels = new ArrayList<>();
        List<Appointment> appointments = super.get();
        for(Appointment appointment : appointments){
            appointmentModels.add(new AppointmentModel(appointment));
        }
        return appointmentModels;
    }
    
    public AppointmentModel getAppointmentModelById(String appointmentId){
        return new AppointmentModel(super.getById(appointmentId));
    }
}
