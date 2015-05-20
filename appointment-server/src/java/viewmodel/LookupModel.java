/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewmodel;

import components.data.Diagnosis;
import components.data.LabTest;
import components.data.PSC;
import components.data.Patient;
import components.data.Phlebotomist;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sabreu
 */
public class LookupModel {
    private List<Patient> patients;
    private List<Phlebotomist> phlebotomists;
    private List<PSC> psc;
    private List<LabTest> labTests;
    private List<Diagnosis> diagnosises;

    /**
     * @return the patients
     */
    public List<Patient> getPatients() {
        return patients;
    }

    /**
     * @return the phlebotomists
     */
    public List<Phlebotomist> getPhlebotomists() {
        return phlebotomists;
    }

    /**
     * @param patients the patients to set
     */
    public void setPatients(List<Object> patients) {
        this.patients = new ArrayList<>();
        for(Object patient: patients){
            this.patients.add((Patient)patient);
        }
    }

    /**
     * @param phlebotomists the phlebotomists to set
     */
    public void setPhlebotomists(List<Object> phlebotomists) {
        this.phlebotomists = new ArrayList<>();
        for(Object phlebotomist: phlebotomists){
            this.phlebotomists.add((Phlebotomist)phlebotomist);
        }
    }

    /**
     * @return the psc
     */
    public List<PSC> getPsc() {
        return psc;
    }

    /**
     * @param pscs the psc to set
     */
    public void setPsc(List<Object> pscs) {
        this.psc = new ArrayList<>();
        for(Object psc: pscs){
            this.psc.add((PSC) psc);
        }
    }

    /**
     * @return the labTests
     */
    public List<LabTest> getLabTests() {
        return labTests;
    }

    /**
     * @param labTests the labTests to set
     */
    public void setLabTests(List<Object> labTests) {
        this.labTests = new ArrayList<>();
        for(Object labtest: labTests){
            this.labTests.add((LabTest)labtest);
        }
    }

    /**
     * @return the diagnoses
     */
    public List<Diagnosis> getDiagnoses() {
        return diagnosises;
    }

    /**
     * @param diagnoses the diagnoses to be set
     */
    public void setDiagnoses(List<Object> diagnoses) {
        this.diagnosises = new ArrayList<>();
        for(Object diagnosis: diagnoses){
            this.diagnosises.add((Diagnosis) diagnosis);
        }
    }
}
