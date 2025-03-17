package Queue;

import Stack.Appointment;

public class LateAppointmentsQueue extends MyQueue {

    @Override
    public void enqueue(Object obj) {
        if (obj instanceof Appointment) {
            if (theQueue.size() == 5) {
                theQueue.add(obj);
                Appointment app = (Appointment) theQueue.get(0);
                app.moveToMissedAppointments();
                theQueue.remove(0);
            }
            else {
                theQueue.add(obj);
            }
        }
    }

    @Override
    public Object dequeue() {
        System.out.println("You cannot manually remove elements from this queue.");
        return null;
    }
}
