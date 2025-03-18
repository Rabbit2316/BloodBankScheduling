/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.GPGUIComponents;

import com.github.lgooddatepicker.components.DateTimePicker;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author owen
 */
public class BookBloodTestFrame extends JFrame {
    public BookBloodTestPanel panel;
    public BookBloodTestFrame() {
        setTitle("BOOK BLOOD TEST");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());
        panel = new BookBloodTestPanel();
        add(panel, BorderLayout.CENTER);
        
        
    }
}
