/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author sam_e
 */
public class LengthOfStay {
    
    public static int DaysOfStay(Guest guest) {
        
        Date currentDate = new Date();
        
        DateFormat priceCheck = new SimpleDateFormat("D");
        
        String priceCheckOutDate = priceCheck.format(currentDate);
        
        String priceCheckInDate = guest.getPriceCheckDate();
        
        int checkOut = Integer.parseInt(priceCheckOutDate);
        int checkIn = Integer.parseInt(priceCheckInDate);
        
        int daysOfStay = checkOut - checkIn;
        
        return daysOfStay;
    }
    
}
