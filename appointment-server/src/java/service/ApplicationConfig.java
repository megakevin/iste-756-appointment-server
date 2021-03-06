/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author kevin
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.AppointmentService.class);
        resources.add(service.CrossOriginResourceSharingFilter.class);
        resources.add(service.DiagnosisService.class);
        resources.add(service.LabTestService.class);
        resources.add(service.LookupService.class);
        resources.add(service.PatientService.class);
        resources.add(service.PatientServiceCenterService.class);
        resources.add(service.PhlebotomistService.class);
        resources.add(service.PhysicianService.class);
        resources.add(service.ServicesService.class);
    }
    
}
