/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import GUI.BloodCenterGUIComponents.BloodCenterPanel;
import GUI.GPGUIComponents.GPHomePanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author owen
 */
public class MainFrame extends JFrame {
    public JPanel mainPanel;
    public CardLayout cardLayout;
    LoginPanel loginPanel;
    public static GPHomePanel gpHomePanel;
    public static BloodCenterPanel bloodCenterPanel;
    public MainFrame() {
        setTitle("Blood Bank Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        
        setLayout(new BorderLayout());
        
        mainPanel = new JPanel();
        mainPanel.setSize(700, 700);
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        
        loginPanel = new LoginPanel(this);
        loginPanel.setVisible(true);
        loginPanel.setSize(700, 700);
        
        gpHomePanel = new GPHomePanel();
        bloodCenterPanel = new BloodCenterPanel();
   
        mainPanel.add(gpHomePanel, "gpHomePanel");
        mainPanel.add(loginPanel, "loginPanel");
        mainPanel.add(bloodCenterPanel, "bloodCenterPanel");
        cardLayout.show(mainPanel, "loginPanel");
        
        add(mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
        
    }
}
