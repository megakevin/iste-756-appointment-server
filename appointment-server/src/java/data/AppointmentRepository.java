/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;
import java.text.*;
import components.data.*;

/**
 *
 * @author kevin
 */
public class AppointmentRepository {
    
    private IComponentsData db;
    
    public AppointmentRepository()
    {
        this.db = new DB();
        this.db.initialLoad("LAMS");
    }
    
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
