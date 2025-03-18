/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.BloodCenterGUIComponents.BBCheckPatientIN;

import GUI.BloodCenterGUIComponents.BBCheckPatientIN.CheckBBPatientInPanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author owen
 */
public class CheckBBPatientInFrame extends JFrame {
    public CheckBBPatientInPanel panel;
    public CheckBBPatientInFrame() {
          setTitle("CHECK PATIENT IN");
          panel = new CheckBBPatientInPanel();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}
