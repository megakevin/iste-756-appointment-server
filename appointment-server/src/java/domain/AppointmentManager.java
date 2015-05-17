/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import data.AppointmentRepository;
import java.util.*;
import components.data.Appointment;
import viewmodel.AppointmentModel;


import components.data.*;

import data.AppointmentRepository;
import java.util.List;


/**
 *
 * @author kevin
 */
public class AppointmentManager {
   private AppointmentRepository apointmentRepo; 
   
   /**
    * Default constructor. It handle the initialization of the appointment repository
    */
   public AppointmentManager(){
       apointmentRepo = new AppointmentRepository();               
   }
   
   /**
    * Gets all the appointments
    * @return ArrayList<Appointment>
    */
   public List<AppointmentModel> getAppointments(){
       return apointmentRepo.getAppointmentModels();
   }
   

    
    private AppointmentRepository appointmentRepository;
    

    
    public Appointment getById(String appointmentId)
    {      
        return this.appointmentRepository.getByIdReal(appointmentId);
    }    

}
