/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.booking;

import JDBC.Select;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hirushan
 */
public class Customer extends HotelBooking {
    
    String cusFirstName;
    String cusLastName;
    String pricePerDay;
    String cusNIC;
    String cusMobileNo;
    String cusEmail;
    String cusAddress;
    String cusGender;
    String cusCountry;        
    
    public void setRoomDetails(JComboBox cusGender, JComboBox cusCountry, JTextField cusFirstName, JTextField cusLastName, JTextField pricePerDay, JTextField cusNIC, JTextField cusMobileNo, JTextField cusEmail, JTextField cusAddress){
        this.cusGender = (String) cusGender.getSelectedItem();  // Assuming roomType is a JComboBox of String items
        this.cusCountry = (String) cusCountry.getSelectedItem();    // Assuming bedType is a JComboBox of String items
        
        this.cusFirstName = cusFirstName.getText(); 
        this.cusLastName = cusLastName.getText(); 
        this.pricePerDay = pricePerDay.getText(); 
        this.cusNIC = cusNIC.getText(); 
        this.cusEmail = cusEmail.getText(); 
        this.cusAddress = cusAddress.getText(); 
        this.cusMobileNo = cusMobileNo.getText(); 
    }
    
    public static void clearAddCustomerFields(JTextField field1, JTextField field2, JTextField field3, JTextField field4, JTextField field5, JTextField field6, JComboBox field7, JComboBox field8){
        field1.setText("");
        field2.setText("");
        field3.setText("");
        field4.setText("");
        field5.setText("");
        field6.setText("");
        
        field7.setSelectedIndex(0);
        field8.setSelectedIndex(0);
    }
    
    @Override
    public void tableShow(JTable jTable){
        //Customer page table show
        ResultSet rs1 = Select.getData("SELECT * FROM CUSTOMER");
        DefaultTableModel model1 = (DefaultTableModel)jTable.getModel();
        
        try{
            while(rs1.next()){
                model1.addRow(new Object[]{
                    rs1.getString("cusID"),
                    rs1.getString("cusNIC"),
                    rs1.getString("cusFirstName"),
                    rs1.getString("cusLastName"),
                    rs1.getString("cusAddress"),
                    rs1.getString("cusGender"),
                    rs1.getString("cusEmail"),
                    rs1.getString("cusMobileNo"),
                    rs1.getString("cusCountry")
                });
            }
            rs1.close();
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
}
