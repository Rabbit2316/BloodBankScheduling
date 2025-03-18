/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.BloodCenterGUIComponents.TodaysAppointments;

import ApplicationLogic.Appointment;
import ApplicationLogic.BloodTestCenter;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author owen
 */
public class TodaysAppointmentsPanel extends javax.swing.JPanel {

    /**
     * Creates new form TodaysAppointmentsPanel
     */
    public TodaysAppointmentsPanel() {
        initComponents();
        for (Appointment a : BloodTestCenter.todaysApps) {  // Iterate through the appointments
    JLabel appointmentLabel = new JLabel();
    appointmentLabel.setText(a.toString());// Create JLabel for appointment
    
    // Add a border to the label (you can customize the color and thickness)
    appointmentLabel.setBorder(new LineBorder(Color.BLACK, 2));
    
    // Set the label to expand to fit content, you can adjust the preferred size if needed
    appointmentLabel.setPreferredSize(new Dimension(200, 40));  // Adjust size as necessary
    
    // Optionally, set the text alignment to center (or left/right depending on your needs)
    appointmentLabel.setHorizontalAlignment(SwingConstants.CENTER);

    // Add the label to the layout (which will be managed by GridLayout)
    this.add(appointmentLabel);
    
    // For debugging purposes, print out the appointment being added
    System.out.println("ADDING APPOINTMENT FROM DATABASE: " + a.toString());
}

        this.revalidate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(204, 255, 204));
        setLayout(new java.awt.GridLayout(0, 3));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
