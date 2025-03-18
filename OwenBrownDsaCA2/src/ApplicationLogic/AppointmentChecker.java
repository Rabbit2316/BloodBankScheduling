package ApplicationLogic;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//This class runs every 30 minutes, and checks for late appointments in BloodTestCenter.todaysAppointments - simple list of all appointments booked today. 
//If any are late, it moves them to BloodTestCenter.lateAppointments - queue fixed size 5. Replaces oldest element on add after that.
//My initial idea was to run an infinite while loop on a second thread that kept log of time and executes after a set time passes, but
//That seemed resource intensive for this not-exectly real-time functionality, so this is the solution I went with. This was coded
//And conceptualized with the assistance of generative AI. 
public class AppointmentChecker {
    
    //Declaring the executor.
    private final ScheduledExecutorService scheduler;

    //Constructor
    public AppointmentChecker() {
       
        //Initializing the executor to run on its own thread so as to not clog up the rest of the app.
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    //Scheduling the executor to run at set interval.
    public void startCheckingAppointments() {
        
        //Every 30 minutes, run checkAppointments.
        scheduler.scheduleAtFixedRate(this::checkAppointments, 0, 30, TimeUnit.MINUTES);
    }

    //Actual method to check if any appointments are late.
    private void checkAppointments() {
        
        //Getting the current time.
        LocalDateTime currentTime = LocalDateTime.now();

        //Creating a deep copy of the appointments for today to safely iterate through. I've had issues removing items from arraylists while itterating through said list, this is the solution.
        List<Appointment> todaysAppointments = BloodTestCenter.todaysApps;
        Iterator<Appointment> iterator = todaysAppointments.iterator();
        
        //Iterating through list.
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();//Getting next appointment.
            if (appointment.getTime().isBefore(currentTime)) { //If the time scheduled for the appointment is in the past.
                BloodTestCenter.lateApps.enqueue(appointment);//Put the appointment in the late queue.
                iterator.remove(); //Remove it from todays appointments.
                appointment.getPatient().missedAppointments.push(appointment);//Push appointment in Patient's missed appointments.
            }
        }

       
    }

}
