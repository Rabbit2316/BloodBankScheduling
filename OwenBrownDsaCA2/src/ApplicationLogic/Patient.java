package ApplicationLogic;

import DoubleLinkedList.MyDoubleLinkedList;
import DoubleLinkedList.Node;
import Stack.MyStack;
import java.time.LocalDate;


//Main patient class holding all information pretaining to a patient. 
public class Patient {
    
   //Properties
   private String name;
   private int ppsn;
   private GP gp;
   private LocalDate dateOfBirth;
   private MyDoubleLinkedList allAppointments;//Double linked list holding all patients appointments. 
   public MyStack missedAppointments;//Stack of patients mist appointments. 

   //Constructor
    public Patient(String name, int ppsn, GP gp, LocalDate dateOfBirth) {
        allAppointments = new MyDoubleLinkedList();
        this.name = name;
        this.ppsn = ppsn;
        this.gp = gp;
        this.dateOfBirth = dateOfBirth;
        missedAppointments = new MyStack();
    }
    
    //Method for adding appointment to patients double linked list.
    public void addAppointment(Appointment app) {
        Node node = new Node(app);
        this.allAppointments.add(node);
    }
    
    //Getters and Setters. 
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPpsn() {
        return ppsn;
    }

    public void setPpsn(int ppsn) {
        this.ppsn = ppsn;
    }

    public GP getGp() {
        return gp;
    }

    public void setGp(GP gp) {
        this.gp = gp;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}
