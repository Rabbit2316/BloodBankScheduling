/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApplicationLogic;

import java.time.LocalDateTime;

/**
 *
 * @author owen
 */
public class Appointment {
    
    private boolean isPaid;
    private Patient patient;
    private GP gp;
    private int priorty;
    private boolean comingFromWard;
    private LocalDateTime time;

    public Appointment(Patient patient, GP gp, LocalDateTime time) {
        this.patient = patient;
        this.gp = gp;
        this.time = time;
    }
    
   @Override
public String toString() {
    // Format each field to look neat
    String patientInfo = "Patient: " + this.patient.getName();
    String gpInfo = "GP: " + this.gp;
    String wardStatus = "Ward Status: " + (comingFromWard ? "Coming from ward" : "Not coming from ward");
    String appointmentTime = "Appointment Time: " + time.toString();
    String PPSN = "PPSN: "+ patient.getPpsn();

    // Return the formatted string with HTML tags to handle line breaks
    return "<html>" + patientInfo + "<br>" + gpInfo + "<br>" + wardStatus + "<br>" + appointmentTime +"<br>"+ PPSN + "</html>";
}



    public boolean isIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public GP getGp() {
        return gp;
    }

    public void setGp(GP gp) {
        this.gp = gp;
    }

    public int getPriorty() {
        return priorty;
    }

    public void setPriorty(int priorty) {
        this.priorty = priorty;
    }

    public boolean isComingFromWard() {
        return comingFromWard;
    }

    public void setComingFromWard(boolean comingFromWard) {
        this.comingFromWard = comingFromWard;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    public void moveToMissedAppointments() {
        
    }
    
}
