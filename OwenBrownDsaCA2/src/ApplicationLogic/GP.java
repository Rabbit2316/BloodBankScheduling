package ApplicationLogic;

import java.time.LocalDate;
import java.util.Date;

public class GP {
    
    String name;
    Date dateOfBirth;
    int medicalId;
    
   public GP() {
       this.name = "doctor";
       this.medicalId = 11;
   }
   
   @Override
   public String toString() {
       return name;
   }
    
}
