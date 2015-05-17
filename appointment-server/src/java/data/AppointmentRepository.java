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
    

    
    @Override
    public Appointment getById(String appointmentId)
    {
        try
        {
            Appointment appointmentToReturn = new Appointment(appointmentId);
            
            appointmentToReturn.setApptdate(new java.sql.Date(2012, 10, 10));
            appointmentToReturn.setAppttime(new java.sql.Time(01, 25, 00));

            return appointmentToReturn;
        }
        catch(Exception ex)
        {
            return null;
        }
    }
    
    public AppointmentModel getAppointmentModelById(String appointmentId){
        return new AppointmentModel(super.getById(appointmentId));
    }
    
    public Appointment getByIdReal(String appointmentId)
    {
        List<Object> objs = db.getData("Appointment", "id='" + appointmentId + "'");

        Appointment appointmentToReturn = null;

        for (Object obj : objs)
        {
            appointmentToReturn = (Appointment)obj;
        }

        return appointmentToReturn;//.toString();
    }
}
