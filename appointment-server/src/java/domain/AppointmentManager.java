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
import data.IRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import viewmodel.AppointmentPostModel;
import viewmodel.AppointmentLabTestViewModel;
import viewmodel.OperationResultModel;


/**
 *
 * @author kevin
 */
public class AppointmentManager {
    private AppointmentRepository appointmentRepo; 
    private  final String LOW_VALID_HOUR = "08:00:00";
    private  final String HIGH_VALID_HOUR = "17:00:00";
    /**
    * Default constructor. It handle the initialization of the appointment repository
    */
    public AppointmentManager(){
        appointmentRepo = new AppointmentRepository();         
    }
   
    /**
    * Gets all the appointments
    * @return ArrayList<Appointment>
    */
    public List<AppointmentModel> getAppointments(){
        List<AppointmentModel> appointmentModels = new ArrayList<>();
        List<Appointment> appointments = this.appointmentRepo.get();
        
        for(Appointment appointment : appointments){
            appointmentModels.add(new AppointmentModel(appointment));
        }
        
        return appointmentModels;
    }
    
    public AppointmentModel getAppointmentById(String appointmentId) {      
        return new AppointmentModel(appointmentRepo.getById(appointmentId));
    }
    
    private Appointment generateAppointmentObject(AppointmentPostModel appointmentPost){
        IComponentsData db = new DB();
        //db.initialLoad("LAMS");
        String id = appointmentPost.getId();
        
        if(id == null || id.isEmpty()) {
            id = appointmentRepo.generateNewId();
        }
        Appointment newAppt = new Appointment(
                    id,
                    appointmentPost.getApptDate(),
                    appointmentPost.getApptTime()
            );
        
        Patient patient = (Patient)db.getData("Patient", "id='" + appointmentPost.getPatientId() + "'").get(0);
        PSC psc = (PSC)db.getData("PSC", "id='" + appointmentPost.getPscId()+ "'").get(0);
        Phlebotomist phleb = (Phlebotomist)db.getData("Phlebotomist", "id='" + appointmentPost.getPhlebId() + "'").get(0);
        
        List<AppointmentLabTest> tests = new ArrayList<>();
        
        for ( AppointmentLabTestViewModel a : appointmentPost.getAppointmentLabTestCollection()) {
            AppointmentLabTest test = new AppointmentLabTest(id, a.getLabTestId(), a.getDiagnosisCode());
            test.setDiagnosis((Diagnosis)db.getData("Diagnosis", "code='"+ a.getDiagnosisCode() + "'").get(0));
            test.setLabTest((LabTest)db.getData("LabTest","id='" + a.getLabTestId() + "'").get(0));
            tests.add(test);
        }
            
        newAppt.setAppointmentLabTestCollection(tests);
        newAppt.setPatientid(patient);
        newAppt.setPhlebid(phleb);
        newAppt.setPscid(psc);
        
        return newAppt;
    }
    public OperationResultModel save(AppointmentPostModel appointmentPost) {  
        Appointment appointment = generateAppointmentObject(appointmentPost);
        
        if(validator(appointment)) {
            return new OperationResultModel(this.appointmentRepo.save(appointment));
        }
        else {
            return new OperationResultModel(false, "Not between 8 and 5", 919191);
        }
        

    }
    
    public OperationResultModel update(AppointmentPostModel appointmentPost) {
        Appointment appointment = generateAppointmentObject(appointmentPost);
        
        if(validator(appointment)) {
            return new OperationResultModel(this.appointmentRepo.update(appointment));
        }
        else {
            return new OperationResultModel(false, "Not between 8 and 5", 919191);
        }
    }
    
    private boolean validator(Appointment appt){
        
        Date openingHour = castDate(LOW_VALID_HOUR, "HH:mm:ss");
        Date closingHour = castDate(HIGH_VALID_HOUR, "HH:mm:ss");
        
        if(appt.getAppttime().after(closingHour) || appt.getAppttime().before(openingHour)) {
            return false;
        }
        
        Phlebotomist phl = appt.getPhlebid();
        List<Appointment> apptList= phl.getAppointmentCollection();
        
        return true; 
    }
    
    private Date castDate(String date,String format)
   {
      DateFormat dateFormat = new SimpleDateFormat(format);
      Date castedDate = null;
      try
      {   
         castedDate = dateFormat.parse(date);         
      }
      catch(Exception pe)
      {
         pe.printStackTrace();
      }
      return castedDate;
   }
}
