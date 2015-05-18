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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.parser.*;
import org.json.simple.*;


/**
 *
 * @author kevin
 */
public class AppointmentManager {
    private IRepository<Appointment> apointmentRepo; 
   
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
        List<AppointmentModel> appointmentModels = new ArrayList<>();
        List<Appointment> appointments = this.apointmentRepo.get();
        
        for(Appointment appointment : appointments){
            appointmentModels.add(new AppointmentModel(appointment));
        }
        
        return appointmentModels;
    }
    
    public AppointmentModel getAppointmentById(String appointmentId) {      
        return new AppointmentModel(apointmentRepo.getById(appointmentId));
    }

    public Boolean save(String inJSON) {
        Appointment appointment = new Appointment();
        
        IComponentsData db = new DB();
        //db.initialLoad("LAMS");
        JSONObject json;
        try {
            json = (JSONObject)new JSONParser().parse(inJSON);
            String patientId = json.get("patientId").toString();
            Patient patient = (Patient)db.getData("Patient", "id='210'").get(0);

            Appointment newAppt = new Appointment("800",java.sql.Date.valueOf("2009-09-01"),java.sql.Time.valueOf("10:15:00"));
            //extra steps here due to persistence api and join, need to create objects in list
            List<AppointmentLabTest> tests = new ArrayList<>();
            AppointmentLabTest test = new AppointmentLabTest("800","86900","292.9");
            test.setDiagnosis((Diagnosis)db.getData("Diagnosis", "code='292.9'").get(0));
            test.setLabTest((LabTest)db.getData("LabTest","id='86900'").get(0));
            tests.add(test);
            newAppt.setAppointmentLabTestCollection(tests);
            newAppt.setPatientid(patient);
            //newAppt.setPhlebid(phleb);
            //newAppt.setPscid(psc);
            System.out.println(patientId);
            return true;

            //return apointmentRepo.save(appointment);
        } 
        catch (ParseException ex) {
//            Logger.getLogger(AppointmentManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
