/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApplicationLogic;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author owen
 */
public class Patient {
    
   private String name;
   private int ppsn;
   private GP gp;
   private LocalDate dateOfBirth;

    public Patient(String name, int ppsn, GP gp, LocalDate dateOfBirth) {
        this.name = name;
        this.ppsn = ppsn;
        this.gp = gp;
        this.dateOfBirth = dateOfBirth;
    }
    
    //DLL
    //STACK

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
