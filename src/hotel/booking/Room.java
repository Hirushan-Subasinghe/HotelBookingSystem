/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.booking;

import JDBC.Select;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hirushan
 */
public class Room extends HotelBooking {
    
    //Declare variables
    String roomType;
    String bedType;
    String pricePerDay;
    
    public void setRoomDetails(JComboBox roomType, JComboBox bedType, JTextField pricePerDay){
        this.roomType = (String) roomType.getSelectedItem();  // Assuming roomType is a JComboBox of String items
        this.bedType = (String) bedType.getSelectedItem();    // Assuming bedType is a JComboBox of String items
        this.pricePerDay = pricePerDay.getText(); 
    }
    
    public String getRoomType(){
        return roomType;
    }
    
    public String getBedType(){
        return bedType;
    }
    
    public int getPricePerDay(){
        return Integer.parseInt(pricePerDay);
    }
    
    @Override
    public void tableShow(JTable jTable){
        //Manage room page table show
        ResultSet rs = Select.getData("SELECT * FROM ROOM");
        DefaultTableModel model = (DefaultTableModel)jTable.getModel();
        
        try{
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("roomNo"), rs.getString("roomType"), rs.getString("bedType"), rs.getString("bookStatus"), rs.getString("pricePerDay")});
            }
            rs.close();
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void tableShow() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
