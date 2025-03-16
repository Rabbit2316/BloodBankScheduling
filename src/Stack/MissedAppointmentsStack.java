package Stack;

public class MissedAppointmentsStack extends MyStack {

    @Override
    public Object pop() {
        Object appointment = peek();
        if(appointment instanceof Appointment) {
            Appointment app = (Appointment) appointment;
            if(app.isPaid()) {
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
}
