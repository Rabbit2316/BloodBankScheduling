package ApplicationLogic;

import ApplicationLogic.Appointment;
import ApplicationLogic.BloodTestCenter;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppointmentChecker {
    private final ScheduledExecutorService scheduler;

    public AppointmentChecker() {
       
        this.scheduler = Executors.newSingleThreadScheduledExecutor(); // Creates a single background thread
    }

    public void startCheckingAppointments() {
        // Schedule the task to run every 30 minutes with a delay of 0 (start immediately)
        scheduler.scheduleAtFixedRate(this::checkAppointments, 0, 30, TimeUnit.MINUTES);
    }

    private void checkAppointments() {
        // Perform the task in the background
        LocalDateTime currentTime = LocalDateTime.now();

        // Assuming BloodTestCenter.todaysApps is a list of today's appointments
        List<Appointment> todaysAppointments = BloodTestCenter.todaysApps;

        Iterator<Appointment> iterator = todaysAppointments.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getTime().isBefore(currentTime)) { // Check if the appointment time has passed
                BloodTestCenter.lateApps.enqueue(appointment);
                iterator.remove(); // Remove the missed appointment from today's list
                appointment.getPatient().missedAppointments.push(appointment);
            }
        }

       
    }

    public void shutdown() {
        scheduler.shutdown(); // Gracefully shut down the executor when it's no longer needed
    }
}
