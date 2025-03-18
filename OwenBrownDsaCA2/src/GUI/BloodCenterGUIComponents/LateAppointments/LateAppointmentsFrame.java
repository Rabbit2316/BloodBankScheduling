/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.BloodCenterGUIComponents.LateAppointments;

import GUI.BloodCenterGUIComponents.TodaysAppointments.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author owen
 */
public class LateAppointmentsFrame extends JFrame {
    public LateAppointmentsPanel tap = new LateAppointmentsPanel();
    public LateAppointmentsFrame() {
        tap = new LateAppointmentsPanel();
         setTitle("LATE APPOINTMENTS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        add(tap);
    }
    
}
