/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.booking;

import GUI.AdminGUI;
import JDBC.InsertUpdateDelete;
import JDBC.Select;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Hirushan
 */
public class User extends HotelBooking {
    
    
    public void clearAddUserFields(JTextField field1, JTextField field2, JComboBox field3, JComboBox field4){
        field1.setText("");
        field2.setText("");
                
        field3.setSelectedIndex(0);
        field4.setSelectedIndex(0);
    }

    @Override
    public void tableShow(JTable jTable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}


