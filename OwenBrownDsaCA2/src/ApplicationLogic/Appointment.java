package ApplicationLogic;

import java.time.LocalDateTime;

//Main appointment class. This holds information related to an appointment, and is used in various data structures.
public class Appointment {
    
    private boolean isPaid;//Functionality for an unimplemented stack in the Patient class. Would not be able to schedule appointment without stack being empty, can't pop unless true.
    private Patient patient;//The patient the appointment is for.
    private GP gp;//The GP of the patient/booking the appointment.
    private int priorty;//Priority of appointment. Added by BloodTestCenterPanel after check-in
    private boolean comingFromWard;//Is the patient coming from a ward.
    private LocalDateTime time;//The time the appointment is booked for.

    //Constructor.
    public Appointment(Patient patient, GP gp, LocalDateTime time) {
        this.patient = patient;
        this.gp = gp;
        this.time = time;
        
    }
    
    //Overriding toString to provide a decent summary.
   @Override
    public String toString() {
    String patientInfo = "Patient: " + this.patient.getName();
    String gpInfo = "GP: " + this.gp;
    String wardStatus = "Ward Patient?: " + (comingFromWard ? "Yes" : "No");
    String appointmentTime = "Appointment Time: " + time.toString();
    String PPSN = "PPSN: "+ patient.getPpsn();
    
   

    //Using HTML to format because the JLabel isn't placing nice with \n.
    return "<html>" + patientInfo + "<br>" + gpInfo + "<br>" + wardStatus + "<br>" + appointmentTime +"<br>"+ PPSN + "</html>";
    }

    //Getters and setters.
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
}
