/*
 * Purpose          : This class represents an appointment view model.
 * Date             : Written 5/16/2015
 */

package viewmodel;
//import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import components.data.*;
/**
 *
 * @author sabreu
 */
public class AppointmentModel  {
    private String id;
    private Date appointmentDate;
    private Time appointmentTime;
    private  Patient patient;
    private Phlebotomist phlebotomist;
    private PSC psc;
    
    public AppointmentModel(){}
    
   
    public AppointmentModel(Appointment appointment){
        this.id = appointment.getId();
        this.appointmentDate = appointment.getApptdate();
        this.appointmentTime = appointment.getAppttime();
        this.patient = appointment.getPatientid();
        this.phlebotomist = appointment.getPhlebid();
        this.psc = appointment.getPscid();
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    public Patient getPatient(){
        return patient;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the appointmentDate
     */
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    /**
     * @param appointmentDate the appointmentDate to set
     */
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    /**
     * @return the appointmentTime
     */
    public Time getAppointmentTime() {
        return appointmentTime;
    }

    /**
     * @param appointmentTime the appointmentTime to set
     */
    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the phlebotomist
     */
    public Phlebotomist getPhlebotomist() {
        return phlebotomist;
    }

    /**
     * @param phlebotomist the phlebotomist to set
     */
    public void setPhlebotomist(Phlebotomist phlebotomist) {
        this.phlebotomist = phlebotomist;
    }

    /**
     * @return the psc
     */
    public PSC getPsc() {
        return psc;
    }

    /**
     * @param psc the psc to set
     */
    public void setPsc(PSC psc) {
        this.psc = psc;
    }

}
