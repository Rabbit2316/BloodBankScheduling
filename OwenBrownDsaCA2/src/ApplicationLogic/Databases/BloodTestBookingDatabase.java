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

//This is the class serving as a database for all appointments booked with the blood center. It runs off a hash map with a date kay, and stack of appointments value. 
//It holds appointments for any given date in the stack, then empties it into todaysAppointments in the BloodCenterTest on the first login of the day.
public class BloodTestBookingDatabase {
    
    //Declaring the hashmap 
    HashMap<LocalDate, MyStack> db;

    //Constructor
    public BloodTestBookingDatabase() {
        this.db = new HashMap<>();
        addAppointmentsForPatients();  //Created with the assistance of generative AI. This method populates the hashMap.
    }

    //This method is called whenever an appointment is scheduled. In-app, this is through the GP login -> book blood test.
    public boolean scheduleAppointment(Appointment a) {
        //Getting the date of the appointment
        LocalDateTime ldt = a.getTime();
        LocalDate ld = ldt.toLocalDate();
        
        //If an appointment for that date has already been created
        if (db.containsKey(ld)) {
            db.get(ld).push(a);//Add it to the stack
            return true;
        } 
        else { //If first appointment for that date
            db.put(ld, new MyStack());//Create an entry in the hash map for it with a new stack. 
            db.get(ld).push(a); //Push the appointment into it.
            return true;
        }
    }

    //Method to cancel an appointment. Half-implemented as it can only be done as soon as the appointment is added as its a stack. 
    //Option for doctor to cancel qucikly incase they enetered wrong information.
    public void cancelAppointment(Appointment a) {
        LocalDateTime ldt = a.getTime();
        LocalDate ld = ldt.toLocalDate();
        if (db.containsKey(ld)) {
            db.get(ld).pop();
        }
    }

    //This is the method that takes all the appointments for any given day, and loads them into the BloodTestCenter.
    public void loadTodaysApps(LocalDate date) {
        if (db.containsKey(date)) {
            MyStack stack = db.get(date);
            System.out.println(stack.isEmpty());
            while (!stack.isEmpty()) {
                Appointment app = (Appointment) stack.pop();
                BloodTestCenter.todaysApps.add(app);
                System.out.println("Appointment added: "+app.toString());
            }
        }
    }

    //Created with the assistance of generative AI. This autopopulates the database.
    private void addAppointmentsForPatients() {
        
        //Setting dates for autopopulation. 
        LocalDate startDate = LocalDate.of(2025, Month.MARCH, 1);
        LocalDate endDate = LocalDate.of(2025, Month.MARCH, 31);
        
        //Looping through each day in the range.
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {//date = startdate, while less than end date, date+1 day.
            
            //Creating the database entry for that day
            if (!db.containsKey(date)) {
                db.put(date, new MyStack());
            }
            
            //Setting the time for appointments to start being added at
            LocalDateTime appointmentTime = date.atTime(16, 0);  // 4:00 PM
            
            //Pulling all patients from the patients binary search tree as a list. We will create one appointment for each one each day.
            List<Patient> patients = MyMain.db.DB.getAllPatients();
            
            //Creating said appointments
            for (Patient patient : patients) {
                
                //Creating the patient's appointment.
                Appointment appointment = new Appointment( patient, new GP(), appointmentTime);

                //Adding it to the stack.
                db.get(date).push(appointment);

                //Movin the timer up 30 minutes.
                appointmentTime = appointmentTime.plusMinutes(30);
            }
        }
    }
}
