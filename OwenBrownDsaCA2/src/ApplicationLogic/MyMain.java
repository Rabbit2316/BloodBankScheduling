package ApplicationLogic;



import ApplicationLogic.Databases.PatientDatabase;
import ApplicationLogic.Databases.BloodTestBookingDatabase;
import GUI.MainFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author owen
 */
public class MyMain {

    
    public static PatientDatabase db;
    public static BloodTestBookingDatabase bloodTestDB;
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        
        db = new PatientDatabase();
        bloodTestDB = new BloodTestBookingDatabase();
        
        AppointmentChecker appointmentChecker = new AppointmentChecker();

        // Start checking appointments every 30 minutes
        appointmentChecker.startCheckingAppointments();
    }
    
}
