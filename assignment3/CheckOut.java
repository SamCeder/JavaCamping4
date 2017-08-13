/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author sam_e
 */
public class CheckOut {
    
    public static Guest CheckOutGuest(Guest guest) {
        
        DateFormat newFormat = new SimpleDateFormat("yy-MM-dd");
        
        Date currentDate = new Date();
        
        String checkOutDate = newFormat.format(currentDate);
        
        guest.setCheckOutDate(checkOutDate);
        
        DateFormat priceCheck = new SimpleDateFormat("D");
        
        String priceCheckOutDate = priceCheck.format(currentDate);
        
        String priceCheckInDate = guest.getPriceCheckDate();
        
        double[] givenPrice = guest.getGivenPrice();
        
        Accomodation accomodation = guest.getAssignedAccomodation();
        
        String accomodationType = accomodation.getAccomodationType();
        
        double priceOfElectricity = 0;
        
        if (accomodationType.equals("Husvagnsplats")) {
            if (accomodation.isElectricity() == true) {
                priceOfElectricity = givenPrice[4];   
            }
        }
        
        int checkOut = Integer.parseInt(priceCheckOutDate);
        int checkIn = Integer.parseInt(priceCheckInDate);
        
        int daysOfStay = checkOut - checkIn;
        int weeks = daysOfStay / 7;
        int days = daysOfStay % 7;
        
        int pwrUsage = ((int) Math.floor(Math.random()*(11))) * daysOfStay;
        
        double newMeterValue = accomodation.getElectricityMeter() + pwrUsage;
        accomodation.setElectricityMeter(newMeterValue);
        
        double priceForWeek;
        double priceForDay;
        
        String[] season = { "Lågsäsong", "Högsäsong"};
            String choice = (String)JOptionPane.showInputDialog( null, "Välj Hög- eller Lågsäsong",
                "Utcheckning av: " + guest.getName() + " " + guest.getLastname(),
                JOptionPane.QUESTION_MESSAGE,
                null,
                season,
                season[ 0 ]);
            
            if (choice.equals("Lågsäsong")) {
                priceForDay = givenPrice[0];
                priceForWeek = givenPrice[2];
            }
            
            else {
                priceForDay = givenPrice[1];
                priceForWeek = givenPrice[3];
            }
            
        double priceOfStay =  (priceForWeek * weeks) + (priceForDay * days) + 
                                (priceOfElectricity * pwrUsage);
        
        guest.setPriceOfStay(priceOfStay);
        
        return null;
        
        
        
    
    }
}
