/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.*;
import java.text.*;
import components.data.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author kevin
 */
public class AppointmentRepository {
    public AppointmentRepository()
    {
        
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
}
