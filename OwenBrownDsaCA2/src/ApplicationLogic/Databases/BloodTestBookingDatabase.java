package ApplicationLogic.Databases;

import ApplicationLogic.Appointment;
import ApplicationLogic.BloodTestCenter;
import ApplicationLogic.GP;
import ApplicationLogic.MyMain;
import ApplicationLogic.Patient;
import Stack.MyStack;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

public class BloodTestBookingDatabase {
    
    HashMap<LocalDate, MyStack> db;

    public BloodTestBookingDatabase() {
        this.db = new HashMap<>();
        addAppointmentsForPatients();  // Add appointments for patients (e.g., for the whole month)
    }

    // Method to schedule an appointment
    public boolean scheduleAppointment(Appointment a) {
        LocalDateTime ldt = a.getTime();
        LocalDate ld = ldt.toLocalDate();
        if (db.containsKey(ld)) {
            db.get(ld).push(a);
            return true;
        } else {
            db.put(ld, new MyStack());
            db.get(ld).push(a);
            return true;
        }
    }

    // Method to cancel an appointment
    public void cancelAppointment(Appointment a) {
        LocalDateTime ldt = a.getTime();
        LocalDate ld = ldt.toLocalDate();
        if (db.containsKey(ld)) {
            db.get(ld).pop();
        }
    }

    // Method to load today's appointments
    public void loadTodaysApps(LocalDate date) {
        if (db.containsKey(date)) {
            MyStack stack = db.get(date);
            System.out.println(stack.isEmpty());
            while (!stack.isEmpty()) {
                BloodTestCenter.todaysApps.add((Appointment) stack.pop());
                System.out.println("LOADING SINGLE APPOINTMENT");
            }
        }
    }

    // Method to add appointments for all patients (example: for a month)
    private void addAppointmentsForPatients() {
        LocalDate startDate = LocalDate.of(2025, Month.MARCH, 1);
        LocalDate endDate = LocalDate.of(2025, Month.MARCH, 31);
        
        // Loop through every day in March
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            // Create a stack for the day if it's not already in the database
            if (!db.containsKey(date)) {
                db.put(date, new MyStack());
            }
            
            // Start adding appointments after 4pm every half hour
            LocalDateTime appointmentTime = date.atTime(16, 0);  // 4:00 PM
            
            // Get all patients from the PatientDatabase
            List<Patient> patients = MyMain.db.DB.getAllPatients();
            
            // Create an appointment for each patient
            for (Patient patient : patients) {
                // Schedule appointments every half hour
                Appointment appointment = new Appointment(
                        patient,  // Patient from the list
                        new GP(), // Dummy GP for now
                        appointmentTime
                );

                // Add the appointment to the stack for the specific date
                db.get(date).push(appointment);

                // Increment the appointment time by 30 minutes
                appointmentTime = appointmentTime.plusMinutes(30);
            }
        }
    }
}
