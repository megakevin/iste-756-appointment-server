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
import viewmodel.AppointmentPostModel;
import viewmodel.AppointmentLabTestViewModel;
import viewmodel.OperationResultModel;


/**
 *
 * @author kevin
 */
public class AppointmentManager {
    private IRepository<Appointment> appointmentRepo; 
   
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

    public OperationResultModel save(AppointmentPostModel appointmentPost) {
        
        IComponentsData db = new DB();
        //db.initialLoad("LAMS");
        Appointment newAppt = new Appointment(
                    "12001",
                    appointmentPost.getApptDate(),
                    appointmentPost.getApptTime()
            );
        
        Patient patient = (Patient)db.getData("Patient", "id='" + appointmentPost.getPatientId() + "'").get(0);
        PSC psc = (PSC)db.getData("PSC", "id='" + appointmentPost.getPscId()+ "'").get(0);
        Phlebotomist phleb = (Phlebotomist)db.getData("Phlebotomist", "id='" + appointmentPost.getPhlebId() + "'").get(0);
        
        List<AppointmentLabTest> tests = new ArrayList<>();
        
        for ( AppointmentLabTestViewModel a : appointmentPost.getAppointmentLabTestCollection()) {
            AppointmentLabTest test = new AppointmentLabTest("12001",a.getLabTestId(),a.getDiagnosisCode());
            test.setDiagnosis((Diagnosis)db.getData("Diagnosis", "code='"+ a.getDiagnosisCode() + "'").get(0));
            test.setLabTest((LabTest)db.getData("LabTest","id='" + a.getLabTestId() + "'").get(0));
            tests.add(test);
        }
            
        newAppt.setAppointmentLabTestCollection(tests);
        newAppt.setPatientid(patient);
        newAppt.setPhlebid(phleb);
        newAppt.setPscid(psc);
        
        return new OperationResultModel(this.appointmentRepo.save(newAppt));

    }
}
