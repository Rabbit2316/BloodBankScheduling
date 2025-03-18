/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.GPGUIComponents;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author owen
 */
public class CheckoutPatientFrame extends JFrame {
    CheckoutPatientPanel panel;
    public CheckoutPatientFrame() {
        setTitle("ENTER PATIENT PPSN");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());
        
        panel = new CheckoutPatientPanel();
        add(panel, BorderLayout.CENTER);
    }
}
