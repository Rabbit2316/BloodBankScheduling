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
    //Overriding Eequeue method to calculate priority based on priorty given, age, and coming from ward. 
    //Not a good calculation, but only way I could think to do it with the time I have.
    @Override
    public void enqueue(int priority, Object data) {
        if (data instanceof Appointment) {
            Appointment appointment = (Appointment) data;
            //helper method doing calculation
            int customPriority = calculateCustomPriority(appointment, priority);
            PQElement newElement = new PQElement(customPriority, appointment);
            
            //position correctly in queue, prob could just be a super call.
            int i = 0;
            while (i < theQueue.size() && theQueue.get(i).getPriority() >= customPriority) {
                i++;
            }
            theQueue.add(i, newElement);
        } else {
            
        }
    }


    @Override
    public Object dequeue() {
        if (isEmpty()) return null;
        return theQueue.remove(0).getData(); 
    }

    private int calculateCustomPriority(Appointment appointment, int basePriority) {
        int customPriority = basePriority;
        
        //For age
        int age = calculateAgeFromDOB(appointment.getPatient().getDateOfBirth());
        customPriority += (age/5);

        //For coming from ward
        if (appointment.isComingFromWard()) {
            customPriority += 10;
        }
        
        return customPriority;
    }
    
    //Helper method to get the patients age. AI Used here.
    private int calculateAgeFromDOB(LocalDate dob) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.getYear() - dob.getYear() - (dob.getDayOfYear() > currentDate.getDayOfYear() ? 1 : 0);
}
}
