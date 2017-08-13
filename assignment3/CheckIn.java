/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author sam_e
 */
public class CheckIn {
    
    public static Guest CheckInGuest(ArrayList<Accomodation> allCabins, ArrayList<Accomodation> allCaravanSpaces, 
                                        ArrayList<Accomodation> rentedCabins, ArrayList<Accomodation> rentedCaravanSpaces, 
                                        Prices currentPrices) {
        
        double[] givenPrice = new double[5];
        
        String name = JOptionPane.showInputDialog("Ange Gästens förnamn");
        
        String lastname = JOptionPane.showInputDialog("Ange Gästens efternamn");
        
        String adress = JOptionPane.showInputDialog("Ange Gästens adress");
        
        String phoneNumber = JOptionPane.showInputDialog("Ange Gästens telefonnummer");
        
        DateFormat newFormat = new SimpleDateFormat("yy-MM-dd");
        
        Date currentDate = new Date();
        
        String checkInDate = newFormat.format(currentDate);
        
        DateFormat priceCheck = new SimpleDateFormat("D");
        
        String priceCheckDate = priceCheck.format(currentDate);
        
        String checkOutDate = "Incheckad";
        
        double priceOfStay = 0;
        
        String[] accomodationType = { "Stuga", "Husvagnsplats", "Tältplats" };
            String valdTyp = (String)JOptionPane.showInputDialog( null, "Välj typ av boende:",
                "Logi:",
                JOptionPane.QUESTION_MESSAGE,
                null,
                accomodationType,
                accomodationType[ 0 ]);
            
            Accomodation guestsAccomodation;
            
            int index;
            
            if (valdTyp.equals("Stuga")) {
                
                while (true) {
                    index = (int) Math.floor(Math.random()*(allCabins.size()));
                    guestsAccomodation = allCabins.get(index);
                        if (guestsAccomodation.isRented() == false) {
                             break;
                        }
                }
                
                guestsAccomodation.setRented(true);
                rentedCabins.add(guestsAccomodation);
                
                givenPrice[0] = currentPrices.getCabinDayLowSeason();
                givenPrice[1] = currentPrices.getCabinDayHighSeason();
                givenPrice[2] = currentPrices.getCabinWeekLowSeason();
                givenPrice[3] = currentPrices.getCabinWeekHighSeason();
                givenPrice[4] = currentPrices.getElectricityPricePerkWH();
                
                return new Guest(name, lastname, adress, phoneNumber, checkInDate, 
                                    checkOutDate, givenPrice, guestsAccomodation, priceCheckDate, priceOfStay);
            }
                
            else if (valdTyp.equals("Husvagnsplats")) {
                
                while (true) {
                        index = (int) Math.floor(Math.random()*(allCaravanSpaces.size()));
                        guestsAccomodation = allCaravanSpaces.get(index);
                            if (guestsAccomodation.isRented() == false) {
                                 break;
                            }
                    }
                
                int pwrActivation = JOptionPane.showConfirmDialog(null, "Aktivera Elektricitet?");
                
                if (pwrActivation == JOptionPane.YES_OPTION) {
                   guestsAccomodation.setElectricity(true);
                }
                
                guestsAccomodation.setRented(true);
                rentedCaravanSpaces.add(guestsAccomodation);
                
                
                givenPrice[0] = currentPrices.getCaravanDayLowSeason();
                givenPrice[1] = currentPrices.getCaravanDayHighSeason();
                givenPrice[2] = currentPrices.getCaravanWeekLowSeason();
                givenPrice[3] = currentPrices.getCaravanWeekHighSeason();
                givenPrice[4] = currentPrices.getElectricityPricePerkWH();
                
                return new Guest(name, lastname, adress, phoneNumber, checkInDate, 
                                    checkOutDate, givenPrice, guestsAccomodation, priceCheckDate, priceOfStay);    
            }
                
            else {
                
                guestsAccomodation = new Tent();
                 
                givenPrice[0] = currentPrices.getTentDayLowSeason();
                givenPrice[1] = currentPrices.getTentDayHighSeason();
                givenPrice[2] = currentPrices.getTentWeekLowSeason();
                givenPrice[3] = currentPrices.getTentWeekHighSeason();
                givenPrice[4] = currentPrices.getElectricityPricePerkWH();
                
                return new Guest(name, lastname, adress, phoneNumber, checkInDate, 
                                    checkOutDate, givenPrice, guestsAccomodation, priceCheckDate, priceOfStay); 
            }   
    
    
            }
    }
