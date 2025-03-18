/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PriorityQueue;

import ApplicationLogic.Appointment;
import java.time.LocalDate;

/**
 *
 * @author owen
 */
public class AppointmentPriorityQueue extends MyPriorityQueue {
     @Override
    public void enqueue(int priority, Object data) {
        if (data instanceof Appointment) {
            Appointment appointment = (Appointment) data;
            // Calculate custom priority considering priority, age, and ward status
            int customPriority = calculateCustomPriority(appointment, priority);
            PQElement newElement = new PQElement(customPriority, appointment);
            
            // Find the right position based on priority and enqueue
            int i = 0;
            while (i < theQueue.size() && theQueue.get(i).getPriority() >= customPriority) {
                i++;
            }
            theQueue.add(i, newElement);
        } else {
            throw new IllegalArgumentException("Data must be an Appointment object");
        }
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) return null;
        return theQueue.remove(0).getData(); // Return the Appointment with the highest priority
    }

    private int calculateCustomPriority(Appointment appointment, int basePriority) {
        int customPriority = basePriority;
        
        // Consider age: older patients might have a higher priority
            int age = calculateAgeFromDOB(appointment.getPatient().getDateOfBirth());
    customPriority += age;;

        // Consider whether the patient is coming from a hospital ward
        if (appointment.isComingFromWard()) {
            customPriority += 10; // Assign extra priority for patients coming from wards
        }
        
        return customPriority;
    }
    private int calculateAgeFromDOB(LocalDate dob) {
    LocalDate currentDate = LocalDate.now();
    return currentDate.getYear() - dob.getYear() - (dob.getDayOfYear() > currentDate.getDayOfYear() ? 1 : 0);
}
}
