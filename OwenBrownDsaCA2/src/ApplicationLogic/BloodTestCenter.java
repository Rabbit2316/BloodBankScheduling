package ApplicationLogic;

import PriorityQueue.AppointmentPriorityQueue;
import Queue.LateAppointmentsQueue;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

//Primary class holding functionality for the blood test center, which is interacted with in the BLoodTestCenterPanel.
public class BloodTestCenter {
    
    //Properties
    //This is an array list of appointments. It is autopopulated in login, which runs at the first login of each new day. 
    public static ArrayList<Appointment> todaysApps;
    
    //Keeping track of the last login
    private LocalDateTime lastLogIn;

    
    //This is a priority queue keeping track of appointments that have checked in. Appointments are moved from 
    //todaysApps to this, or the lateApps queue. Either when its time has passed, or if the Patient is checked in 
    //From the BloodTestCenterPanel.
    public static AppointmentPriorityQueue waitingApps;
    
    //This is a queue of size fixed size 5. After five elements are present, enqueu will delete the oldest one when called. 
    //This is used to keep track of late appointments. 
    public static LateAppointmentsQueue lateApps;
    
    //Constructor.
    public BloodTestCenter() {
        
        //Initializing last login in the past so it runs properly on login.
        this.lastLogIn = LocalDateTime.of(2025, 1, 1, 1, 0);
        
        //Initializing data structures.
        todaysApps = new ArrayList<>();
        waitingApps = new AppointmentPriorityQueue();
        lateApps = new LateAppointmentsQueue();
    }
    
    //Calling a method in the BloodTestBookingDatabase that populates todaysApps.
    protected void loadTodaysApps() {
       MyMain.bloodTestDB.loadTodaysApps(lastLogIn.toLocalDate());//Passing in the date of the login,
    }
    
    //Login method called anytime the user logs in for the first time.
    public void login(LocalDateTime login) {
        LocalDate loginDay = login.toLocalDate();
        LocalDate lastLogin = lastLogIn.toLocalDate();
        //If the user has never logged in, or not logged in in a day.
        if(lastLogin.isBefore(loginDay) || lastLogin == null) {
            System.out.println("PULLING TODAYS APPOINTMENTS");
            lastLogIn = login;//Setting login date
            loadTodaysApps();//Populating the todaysApps list.
            checkForLateAppointments();//Checking for late appointments immediately, as login time might be later than some appointments.
        } else {
            
        }
        
    }
    
    //Same logic as in the AppointmentChecker.
    private void checkForLateAppointments() {
       
       

        Iterator<Appointment> iterator = BloodTestCenter.todaysApps.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();

            if (appointment.getTime().toLocalTime().isBefore(this.lastLogIn.toLocalTime())) {
                System.out.println("MOVING LATE APPOINTMENT TO QUEUE: " + appointment);
                lateApps.enqueue(appointment);  
                appointment.getPatient().missedAppointments.push(appointment);
                iterator.remove();  // Remove the late appointment from today's appointments
            }
        }
    }
}
