/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.booking;

import JDBC.*;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Hirushan
 */
public class Reservation extends HotelBooking {
    
    //Declare variables
    String roomType;
    String bedType;
    String roomNo;
    String noOfDays;
    String cusID;
    
    String totalPrice;
        
    String checkInDate;
    String checkOutDate;
    
    public void setRoomDetails(JComboBox<String> roomTypeComboBox, JComboBox<String> bedTypeComboBox, JComboBox<String> roomNoComboBox, JTextField noOfDaysTextField, JTextField cusIDTextField, JTextField totalPriceTextField, JDateChooser checkInDateChooser, JDateChooser checkOutDateChooser) {
        this.roomType = (String) roomTypeComboBox.getSelectedItem();  // Assuming roomTypeComboBox is a JComboBox of String items
        this.bedType = (String) bedTypeComboBox.getSelectedItem();    // Assuming bedTypeComboBox is a JComboBox of String items
        this.roomNo = (String) roomNoComboBox.getSelectedItem();      // Assuming roomNoComboBox is a JComboBox of String items
        this.noOfDays = noOfDaysTextField.getText();                  // Assuming noOfDaysTextField is a JTextField
        this.cusID = cusIDTextField.getText();                        // Assuming cusIDTextField is a JTextField
        this.totalPrice = totalPriceTextField.getText();              // Assuming totalPriceTextField is a JTextField

        // Assuming checkInDateChooser and checkOutDateChooser are JDateChooser components
        this.checkInDate = formatDate((Date) checkInDateChooser.getDate());
        this.checkOutDate = formatDate((Date) checkOutDateChooser.getDate());
    }
    
    private String formatDate(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        } else {
            return ""; // Handle the case when the date is null
        }
    }
    
    //Setters
    // Getters
    public String getRoomType() {
        return roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getNoOfDays() {
        return noOfDays;
    }

    public String getCusID() {
        return cusID;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }
    
    
    
    //Generate Reservation ID
    public int generateReservationID(){
        try{
           ResultSet rs = Select.getData("SELECT reservationID FROM RESERVATION WHERE reservationID IN(SELECT MAX(reservationID) FROM RESERVATION)");
           if(rs.next()){
               return rs.getInt("reservationID") + 1;
           }
           
           else{
               return 1;
           }
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        return 0;
    }
    
    public void printBill(String roomNo, int reservationID, String checkInDate, String checkOutDate, String noOfDays, String totalPrice){
        try{
            //ResultSet rs2 = Select.getData("SELECT bedType, roomType, pricePerDay FROM ROOM WHERE roomNo = '"+roomNo+"'");
            ResultSet rs2 = Select.getData("SELECT r.bedType, r.roomType, r.pricePerDay, c.cusFirstName, c.cusLastName, c.cusMobileNo, c.cusEmail FROM ROOM r INNER JOIN RESERVATION res ON r.roomNo = res.roomNo INNER JOIN CUSTOMER c ON res.cusID = c.cusID WHERE r.roomNo = '" + roomNo + "'");


            if (rs2.next()) {
                String roomType = rs2.getString("roomType");
                String bedType = rs2.getString("bedType");
                String pricePerDay = rs2.getString("pricePerDay");
                
                String cusFirstName = rs2.getString("cusFirstName");
//                String cusLastName = rs2.getString("cusFirstName");
                String cusMobileNo = rs2.getString("cusMobileNo");
                String cusEmail = rs2.getString("cusEmail");
//                String cusNIC = rs2.getString("cusNIC");
                
                String path = "E:\\hotel";
                com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
                PdfWriter.getInstance(doc, new FileOutputStream(path+""+reservationID+".pdf"));
                doc.open();
                Paragraph paragraph1 = new Paragraph("                                                        Hotel Management System\n");
                doc.add(paragraph1);

                Paragraph paragraph2 = new Paragraph("**************************************************************************************************************");
                doc.add(paragraph2);

//                Paragraph paragraph3 = new Paragraph("\tReservation ID : "+reservationID+"\nCustomer Details : \nNIC Number : "+cusNIC+" \nName : "+cusFirstName+" \nMobile Number : "+cusMobileNo+"\nEmail : "+cusEmail+"\n");
//                doc.add(paragraph3);    

                Paragraph paragraph3 = new Paragraph("\tReservation ID : "+reservationID+"\nCustomer Details : \nName : "+cusFirstName+" \nMobile Number : "+cusMobileNo+" \nEmail : "+cusEmail+" \n");
                doc.add(paragraph3); 
                

                doc.add(paragraph2);
                //String bedType = null;


                Paragraph paragraph4 = new Paragraph("\tRoom Details :\nNumber : "+roomNo+"\nRoom Type : "+roomType+"\nBed : "+bedType+"\nPrice Per Day : "+pricePerDay+"");
                doc.add(paragraph4);

                doc.add(paragraph2);
                
                

                PdfPTable tb1 = new PdfPTable(4);
                tb1.addCell("Check IN Date : " + checkInDate);
                tb1.addCell("Check Out Date : " + checkOutDate);
                tb1.addCell("No of Days Stay : " + noOfDays);
                tb1.addCell("Total Amount Paid : " + totalPrice);
                doc.add(tb1);
                   
                
                
                doc.add(paragraph2);

                Paragraph paragraph5 = new Paragraph("Thanks You, Please visit Again.");
                doc.add(paragraph5);  

                doc.close();
            }
            
            else {
                // Handle the case where no data is retrieved from the query
                JOptionPane.showMessageDialog(null, "No data found for RoomNo: " + roomNo);
            }
            
            
            
            
//            String path = "E:\\hotel";
//            com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
//            PdfWriter.getInstance(doc, new FileOutputStream(path+""+reservationID+".pdf"));
//            doc.open();
//            Paragraph paragraph1 = new Paragraph("                                                        Hotel Management System\n");
//            doc.add(paragraph1);
//            
//            Paragraph paragraph2 = new Paragraph("**************************************************************************************************************");
//            doc.add(paragraph2);
//            
//            Paragraph paragraph3 = new Paragraph("\tReservation ID : '"+reservationID+"'\nCustomer Details : \nName : \nMobile Number : \nEmail : \n");
//            doc.add(paragraph3);
//            
//            doc.add(paragraph2);
//            //String bedType = null;
//            
//            
//            Paragraph paragraph4 = new Paragraph("\tRoom Details :\nNumber : "+roomNo+"\nRoom Type : "+roomType+"\nBed : "+bedType+"\nPrice Per Day : ");
//            doc.add(paragraph4);
//            
//            doc.add(paragraph2);
//            
//            PdfPTable tb1 = new PdfPTable(4);
//            tb1.addCell("Check IN Date : " + checkInDate);
//            tb1.addCell("Check Out Date : " + checkOutDate);
//            tb1.addCell("No of Days Stay : " + noOfDays);
//            tb1.addCell("Total Amount Paid : " + totalPrice);
//            doc.add(tb1);
//            
//            doc.add(paragraph2);
//            
//            Paragraph paragraph5 = new Paragraph("Thanks You, Please visit Again.");
//            doc.add(paragraph5);  
//            
//            doc.close();
            
            
                                   
        }
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "This is error");
            e.printStackTrace();
        }
    }
    
    //Reservation table shown
    public void tableShow(JTable jTable){
            String query2 = "SELECT C.cusID, C.cusNIC, C.cusFirstName, C.cusLastName, C.cusAddress, C.cusGender, C.cusEmail, R.roomNo, R.roomType, R.bedType, RV.reservationID, RV.checkInDate, RV.checkOutDate, RV.totalPrice FROM CUSTOMER C JOIN RESERVATION RV ON C.cusID = RV.cusID JOIN ROOM R ON RV.roomNo = R.roomNo AND R.bookStatus = 'booked'";
            ResultSet rs2 = Select.getData(query2);
            DefaultTableModel model2 = (DefaultTableModel)jTable.getModel();

            try{
                while(rs2.next()){
                    model2.addRow(new Object[]{
                        rs2.getString("reservationID"),
                        rs2.getString("cusID"),
                        rs2.getString("cusNIC"),
                        rs2.getString("cusFirstName"),
                        rs2.getString("cusLastName"),
                        rs2.getString("cusAddress"),
                        rs2.getString("cusGender"),
                        rs2.getString("cusEmail"),
                        rs2.getString("roomNo"),
                        rs2.getString("roomType"),
                        rs2.getString("bedType"),
                        rs2.getString("checkInDate"),
                        rs2.getString("checkOutDate"),
                        rs2.getString("totalPrice")
                    });
                }
                rs2.close();
            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            } 
        }
    
    

   
}
