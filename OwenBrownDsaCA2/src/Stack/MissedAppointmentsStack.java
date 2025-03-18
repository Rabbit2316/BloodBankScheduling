package Stack;

import ApplicationLogic.Appointment;

public class MissedAppointmentsStack extends MyStack {
    
    public MissedAppointmentsStack() {
        super();
    }

    @Override
    public Object pop() {
        Object appointment = peek();
        if(appointment instanceof Appointment) {
            Appointment app = (Appointment) appointment;
            if(app.isIsPaid()) {
                theStack.remove(theStack.size()-1);
                return app;
            }
            else {//Not paid
                return null;
            }
        }
        else {
            return null;
        }
    }
    
    public String get(int i) {
        return theStack.get(i).toString();
    }
}
