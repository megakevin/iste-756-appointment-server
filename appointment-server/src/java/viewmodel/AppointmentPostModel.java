/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import viewmodel.AppointmentLabTestViewModel;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

/**
 *
 * @author JuanElias
 */
public class AppointmentPostModel {
    private String apptDate;
    private String apptTime;
    private String id; 
    private String patientId;
    private String pscId;
    private String phlebId;
    private List<AppointmentLabTestViewModel> appointmentLabTestCollection; 

    public AppointmentPostModel() {
    }

    public String getApptDate() {
        return apptDate;
    }

    public void setApptDate(String apptDate) {
        this.apptDate = apptDate;
    }
    
    public void setId(String id) {
        if(!id.isEmpty()) this.id = id;
        else this.id = "";
    }
    
    public String getId() {
        return id;
    }

    public String getApptTime() {
        return apptTime;
    }

    public void setApptTime(String apptTime) {
        this.apptTime = apptTime;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPhlebId() {
        return phlebId;
    }

    public void setPhlebId(String phlebId) {
        this.phlebId = phlebId;
    }

    public String getPscId() {
        return pscId;
    }

    public void setPscId(String pscId) {
        this.pscId = pscId;
    }

    public List<AppointmentLabTestViewModel> getAppointmentLabTestCollection() {
        return appointmentLabTestCollection;
    }

    public void setAppointmentLabTestCollection(List<AppointmentLabTestViewModel> appointmentLabTestCollection) {
        this.appointmentLabTestCollection = appointmentLabTestCollection;
    }

}
