/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import components.data.Appointment;

/**
 *
 * @author kevin
 */
public class AppointmentRepository extends BaseRepository<Appointment> { 

    public String generateNewId(){
        int newId = Integer.parseInt(getLastId()) + 1;
        return Integer.toString(newId);
    }
    
    public String getLastId(){
        Appointment appt = (Appointment)(db.getData("Appointment", "1=1 order by id desc").get(0));
        
        return appt.getId();
    }
    
    public boolean save(Appointment appt) {
        return db.addData(appt);
    }
}
