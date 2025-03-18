/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.BloodCenterGUIComponents.TodaysAppointments;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author owen
 */
public class TodaysAppointmentsFrame extends JFrame {
    public TodaysAppointmentsPanel tap = new TodaysAppointmentsPanel();
    public TodaysAppointmentsFrame() {
        tap = new TodaysAppointmentsPanel();
         setTitle("TODAYS APPOINTMENTS");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setVisible(true);
        add(tap);
    }
    
}
