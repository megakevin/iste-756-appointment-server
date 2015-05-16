/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import data.AppointmentRepository;

/**
 *
 * @author kevin
 */
public class AppointmentManager {
    
    private AppointmentRepository appointmentRepository;
    
    public AppointmentManager() {
        this.appointmentRepository = new AppointmentRepository();
    }
    
    public String getById(String appointmentId)
    {
        return this.appointmentRepository.getById(appointmentId);
    }
    
}
