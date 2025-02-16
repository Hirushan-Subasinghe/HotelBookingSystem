/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Hirushan
 */
public class Validations {
    public static int validPassword(String password){
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        
        if(!matcher.matches()){
            if(password.length()<8){
                return 1;
            }
            
            else if(!password.matches(".*[A-Z].*")){
                return 2;
            }
            
            else if(!password.matches(".*\\d.*")){
                return 3;
            }
        }
        return 0;
    }
    
    //Email validation
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    //Phone number validation
     public static boolean isValidPhoneNumber(String phoneNumber) {
        // Define the regular expression for a valid Sri Lankan phone number
        String phoneRegex = "^(0\\d{9})$";

        // Compile the regular expression into a Pattern
        Pattern pattern = Pattern.compile(phoneRegex);

        // Create a Matcher object by applying the pattern to the input phone number
        Matcher matcher = pattern.matcher(phoneNumber);

        // Check if the phone number matches the pattern
        if (matcher.matches()) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
}
