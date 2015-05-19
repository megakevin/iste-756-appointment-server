/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

//import service.AppointmentService;
import data.AppointmentRepository;
/**
 *
 * @author kevin
 */
public class Test {
    public static void main(String[] args) {
        //AppointmentService s = new AppointmentService();
        //s.getByAppointmentId("123456");
        
        AppointmentRepository r = new AppointmentRepository();
        r.getById("700");     
        
    }
}
