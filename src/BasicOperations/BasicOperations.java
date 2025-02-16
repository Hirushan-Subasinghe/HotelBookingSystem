/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BasicOperations;

import JDBC.Select;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hirushan
 */
public class BasicOperations {
    public static void setTextAndClearAfterDelay(JTextField textField) {
        Timer timer = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Clear the text after the delay
                        textField.setText("");
                    }
                    });

                    // Start the timer
                    timer.setRepeats(false); // Set to false to execute only once
                    timer.start();
    }
    
    /* Clear fields data */
    //Manage users 
    public static void clearFields(JTextField field1, JTextField field2, JComboBox combo1, JComboBox combo2){
        field1.setText("");
        field2.setText("");
                
        combo1.setSelectedIndex(0);
        combo2.setSelectedIndex(0);
    }
    
    //Manage Customers
    public static void clearFields(JTextField field1, JTextField field2, JTextField field3, JTextField field4, JTextField field5, JTextField field6, JComboBox combo1, JComboBox combo2){
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
        field5.setText("");
        field6.setText("");
        
        combo1.setSelectedIndex(0);
        combo2.setSelectedIndex(0);
    }
    
    //Manage reservations
    public static void clearFields(JTextField field1, JTextField field2, JTextField field3, JTextField field4, JComboBox combo1, JComboBox combo2, JComboBox combo3, JDateChooser date1 , JDateChooser date2){
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
                
        combo1.setSelectedIndex(0);
        combo2.setSelectedIndex(0);
        combo3.setSelectedIndex(-1);
        
        date1.setDate(null);
        date2.setDate(null);
    }
    
    
     
     
}
