/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApplicationLogic;

import PriorityQueue.AppointmentPriorityQueue;
import PriorityQueue.MyPriorityQueue;
import Queue.LateAppointmentsQueue;
import Stack.MissedAppointmentsStack;
import Stack.MyStack;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author owen
 */
public class BloodTestCenter {
    public static ArrayList<Appointment> todaysApps;
    private LocalDate lastLogIn;
    public static AppointmentPriorityQueue waitingApps;
    public static LateAppointmentsQueue lateApps;
    
    public BloodTestCenter() {
        this.lastLogIn = LocalDate.of(2025, 1, 1);
        todaysApps = new ArrayList<>();
        waitingApps = new AppointmentPriorityQueue();
        lateApps = new LateAppointmentsQueue();
    }
    
    protected void loadTodaysApps() {
       
       MyMain.bloodTestDB.loadTodaysApps(lastLogIn);
    }
    
    public void login(LocalDate loginDay) {
       System.out.println("CALLING THE LOGIN METHOD FROM ApplicationLogic/BloodTestCenter");
        if(lastLogIn.isBefore(loginDay) || lastLogIn == null) {
            System.out.println("PULLING TODAYS APPOINTMENTS");
            lastLogIn = loginDay;
            loadTodaysApps();
            checkForLateAppointments();
        } else {
            
        }
        
    }
    
    private void checkForLateAppointments() {
    LocalDateTime currentTime = LocalDateTime.now();  // Current time for comparison

    // Iterate through the appointments for today and check if they are late
    Iterator<Appointment> iterator = BloodTestCenter.todaysApps.iterator();
    while (iterator.hasNext()) {
        Appointment appointment = iterator.next();
        
        // If the appointment is late (before current time), move it to the missed appointments queue
        if (appointment.getTime().isBefore(currentTime)) {
            System.out.println("MOVING LATE APPOINTMENT TO QUEUE: " + appointment);
            lateApps.enqueue(appointment);  
            appointment.getPatient().missedAppointments.push(appointment);
            iterator.remove();  // Remove the late appointment from today's appointments
        }
    }
}
}
