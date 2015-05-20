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
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.function.Predicate;
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
    private  final String EIGTH_TO_FIVE_ERROR = "8to5error";
    private  final String TIME_SLOT_NOT_AVAILABLE = "apptTimeNotAvailable";
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
        
        Date apptDate = castDate(appointmentPost.getApptDate(), "yyyy-MM-dd");
        
        Appointment newAppt = new Appointment(
                    id,
                    new java.sql.Date(apptDate.getTime()),
                    java.sql.Time.valueOf(appointmentPost.getApptTime())
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
        String error = validator(appointment);
        if(error == null) {
            return new OperationResultModel(this.appointmentRepo.save(appointment));
        }
        else {
            return new OperationResultModel(false, buildErrorMessage(appointment,error), 919191);
        }
        

    }
    
    public OperationResultModel update(AppointmentPostModel appointmentPost) {
        Appointment appointment = generateAppointmentObject(appointmentPost);
        String error = validator(appointment);
        if(error == null) {
            return new OperationResultModel(this.appointmentRepo.update(appointment));
        }
        else {
            return new OperationResultModel(false, buildErrorMessage(appointment,error), 919191);
        }
    }
    
    private String validator(Appointment appt){
        
        Date openingHour = castDate(LOW_VALID_HOUR, "HH:mm:ss");
        Date closingHour = castDate(HIGH_VALID_HOUR, "HH:mm:ss");
        
        if(appt.getAppttime().after(closingHour) || appt.getAppttime().before(openingHour)) {
            return EIGTH_TO_FIVE_ERROR;
        }
        
        Phlebotomist phl = appt.getPhlebid();
        List<Appointment> apptList= phl.getAppointmentCollection();
        ArrayList<Appointment> apptInDate = new ArrayList<Appointment>();
        
        for(Appointment apptTemp : apptList){
            if(apptTemp.getApptdate().equals(appt.getApptdate())){
                apptInDate.add(apptTemp);
            }
        }
        if(apptInDate.isEmpty()) return null; 
        
        for(Appointment apptTemp : apptInDate){
            if(apptTemp.getPscid().equals(appt.getPscid()) &&
                   intimeRange(appt.getAppttime(), apptTemp.getAppttime(), 15) ){
                return TIME_SLOT_NOT_AVAILABLE;
            } 
            else if(intimeRange(appt.getAppttime(), apptTemp.getAppttime(), 45)) {
                return TIME_SLOT_NOT_AVAILABLE;
            }
        }
        return null; 
    }
    
    private String availableAppointmentTime(Appointment appt){
        String startTime = "8:00";
        String endTime = "5:00";
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date d; 
        
        try {
            d = df.parse(startTime);
            Calendar cal = Calendar.getInstance();
            cal.setTime(d);
            
            d = df.parse(endTime);
            Calendar limit = Calendar.getInstance();
            limit.setTime(d);
            
            for(int i=0; cal.after(limit) ; i++){
                Appointment a = new Appointment(
                                "0",
                                appt.getApptdate(), 
                                new java.sql.Time(cal.getTimeInMillis())
                        );
                
                a.setPhlebid(appt.getPhlebid());
                a.setPscid(appt.getPscid());
                
                String error = validator(a);
                
                if(error == null) {
                    return df.format(cal.getTime());
                }
                cal.add(Calendar.MINUTE, 15);
            }
        } 
        catch (ParseException ex) {
            Logger.getLogger(AppointmentManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "No valid Time";
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

    private boolean intimeRange(Time apptTime, Time newApptTime, int timeSpan) {
        Date apptDate = castDate(apptTime.toString(), "HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.setTime(apptDate);
        
        cal.add(Calendar.MINUTE, timeSpan);
        Date endTime = cal.getTime();
        
        cal.add(Calendar.MINUTE, timeSpan * -2);
        Date startTime = cal.getTime();
        
        if(newApptTime.after(startTime) && 
                newApptTime.before(endTime)) {
            return true;
        }
        else {
            return false;
        }
    }

    private String buildErrorMessage(Appointment appt, String error) {
        switch (error) {
            case EIGTH_TO_FIVE_ERROR:
                return "Requested time is not valid. Must be between 8 am and 5 pm";
            case TIME_SLOT_NOT_AVAILABLE:
                return "The requested time is not available. The phlebotomist is available at: "
                        + availableAppointmentTime(appt);
        }
        
        return "Unkown error";
    }
}
