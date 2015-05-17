
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import components.data.*;
import java.util.*;
import viewmodel.AppointmentModel;
/**
 *
 * @author kevin
 */
public class AppointmentRepository {
    private IComponentsData db;
    
    /**
     * This constructor initializes the connection to the database
     */
    public AppointmentRepository(){
        db = new DB();
        //db.initialLoad("LAMS");
    }
    
    /**
     * Method for getting all the appointment from the database.
     * @return ArrayList<Appointment>
     */
    public ArrayList<AppointmentModel> get(){
       ArrayList<AppointmentModel> result = new ArrayList<AppointmentModel>();
       List<Object> objs = db.getData("Appointment", "");      
       for(Object obj: objs){
           Appointment appointment = (Appointment)obj;
           result.add(new AppointmentModel(appointment));
       }
       return result;
    }
    
       public List<Appointment> getAppointments(){
       List<Appointment> result = new ArrayList<>();
       List<Object> objs = db.getData("Appointment", "");
      // result.add(new Appointment("800",java.sql.Date.valueOf("2009-09-01"),java.sql.Time.valueOf("10:15:00")));
       for(Object obj: objs){
           Appointment appointment = (Appointment)obj;
          // result.add(new AppointmentModel(appointment.getId(), appointment.getApptdate(), appointment.getAppttime()));
           result.add(appointment);
       }
       return result;
    }
}
