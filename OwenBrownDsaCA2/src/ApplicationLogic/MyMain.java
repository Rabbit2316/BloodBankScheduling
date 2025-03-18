package ApplicationLogic;
import ApplicationLogic.Databases.PatientDatabase;
import ApplicationLogic.Databases.BloodTestBookingDatabase;
import GUI.MainFrame;

//Main class with main method
public class MyMain {

    //Declaring the database classes
    public static PatientDatabase db; //Binary Search Tree holding instances of Patient, sorted by PPSN.
    public static BloodTestBookingDatabase bloodTestDB;//HashMap of LocalDates and Stacks<Appointment>, holding appointments by date.
    
    //Main method
    public static void main(String[] args) {
        
        //Main GUI Frame
        MainFrame frame = new MainFrame();
        
        //Initializing the databases.
        db = new PatientDatabase();
        bloodTestDB = new BloodTestBookingDatabase();
        
        //Creating instance of system scheduler that checks for late appointments every 30 minutes, and moves to late queue in BloodTestCenter..
        AppointmentChecker appointmentChecker = new AppointmentChecker();

        //Starting the scheduler.
        appointmentChecker.startCheckingAppointments();
    }
    
}
