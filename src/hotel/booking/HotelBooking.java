/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.booking;

import com.formdev.flatlaf.FlatLightLaf;
import com.mysql.cj.protocol.Resultset;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Hirushan
 */
public abstract class HotelBooking {

    private Resultset Select;

    /**
     * @param args the command line arguments
     */
    
    public HotelBooking() {
        FlatLightLaf.setup();
        
    }
    
    //Variable Declaration
    private static String hotelName = "Galadari Hotel";
    private static String hotelAddress = "Ranvimana estate, Humbuluwa, Alawwa";
    private static String hotelphoneNo = "011 - 89 78 667";
    private static String hotelEmail = "Galadarihotel@gmail.com";

    // Getter and Setter for hotelName
    public static String getHotelName() {
        return hotelName;
    }

    public static void setHotelName(String hotelName) {
        HotelBooking.hotelName = hotelName;
    }

    // Getter and Setter for hotelAddress
    public static String getHotelAddress() {
        return hotelAddress;
    }

    public static void setHotelAddress(String hotelAddress) {
        HotelBooking.hotelAddress = hotelAddress;
    }

    // Getter and Setter for hotelphoneNo
    public static String getHotelphoneNo() {
        return hotelphoneNo;
    }

    public static void setHotelphoneNo(String hotelphoneNo) {
        HotelBooking.hotelphoneNo = hotelphoneNo;
    }

    // Getter and Setter for hotelEmail
    public static String getHotelEmail() {
        return hotelEmail;
    }

    public static void setHotelEmail(String hotelEmail) {
        HotelBooking.hotelEmail = hotelEmail;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(getHotelName());
        
    }
    
    
    
    //method for close Application
    public static void closeApplication(){
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to close the application","Select",JOptionPane.YES_NO_OPTION);

        if(a==0) //User selected YES
        {
            System.exit(0);  //exit from the application
        }
    }
    
    //show hotel details in MainGui/Dashboard
    public static void showHotelDetails(JTextField field1, JTextField field2, JTextField field3, JTextField field4){
        field1.setText(HotelBooking.getHotelName());
        field2.setText(HotelBooking.getHotelAddress());
        field3.setText(HotelBooking.getHotelphoneNo());
        field4.setText(HotelBooking.getHotelEmail());
        
    }
    
    public abstract void tableShow(JTable jTable);
    
   
    
    
    
}
