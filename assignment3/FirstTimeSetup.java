/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author sam_e
 */
public class FirstTimeSetup {
    
    public static Accomodation AccomodationPopulator(ArrayList<Accomodation> allCabins, 
                                ArrayList<Accomodation> allCaravanSpaces) {
        
            Accomodation cabinOne = new Cabin("Harry", false);
            allCabins.add(cabinOne);
            
            Accomodation cabinTwo = new Cabin("Ron", false);
            allCabins.add(cabinTwo);
            
            Accomodation cabinThree = new Cabin("Hermione", false);
            allCabins.add(cabinThree);
            
            Accomodation cabinFour = new Cabin("Hagrid", false);
            allCabins.add(cabinFour);
            
            Accomodation cabinFive = new Cabin("Dumbledore", false);
            allCabins.add(cabinFive);
            
            Accomodation cabinSix = new Cabin("Snape", false);
            allCabins.add(cabinSix);
            
            Accomodation cabinSeven = new Cabin("Hedvig", false);
            allCabins.add(cabinSeven);
            
            Accomodation cabinEight = new Cabin("Voldemort", false);
            allCabins.add(cabinEight);
            
            Accomodation cabinNine = new Cabin("Draco", false);
            allCabins.add(cabinNine);
            
            Accomodation cabinTen = new Cabin("Dudley", false);
            allCabins.add(cabinTen);
            
            Accomodation cabinEleven = new Cabin("Neville", false);
            allCabins.add(cabinEleven);
            
            Accomodation cabinTwelve = new Cabin("McGonagall", false);
            allCabins.add(cabinTwelve);
            
            for (int i = 1; i <= 32; i++) {
                int electricityMeter = (int) Math.floor(Math.random()*(2001)+2000);
                Accomodation caravanSpace = new Caravan(("Plats " + i), false, false, electricityMeter);
                allCaravanSpaces.add(caravanSpace);
            }
            
    return null;
    }
    
    public static Accomodation AccomodationPicker(ArrayList<Accomodation> allCabins, ArrayList<Accomodation> allCaravanSpaces, 
                                        ArrayList<Accomodation> rentedCabins, ArrayList<Accomodation> rentedCaravanSpaces) {
        
        int randomInt = ((int) Math.floor(Math.random()*(3)));
                
        int randomIntTwo = ((int) Math.floor(Math.random()*(2)));
        
        double[] givenPrice;
            
        int index;
        
        Accomodation guestsAccomodation;

        if (randomInt == 0) {

            while (true) {
                index = (int) Math.floor(Math.random()*(allCabins.size()));
                guestsAccomodation = allCabins.get(index);
                    if (guestsAccomodation.isRented() == false) {
                         break;
                    }
            }

            guestsAccomodation.setRented(true);
            rentedCabins.add(guestsAccomodation);

            return guestsAccomodation;
        }

        else if (randomInt == 1) {

            while (true) {
                    index = (int) Math.floor(Math.random()*(allCaravanSpaces.size()));
                    guestsAccomodation = allCaravanSpaces.get(index);
                        if (guestsAccomodation.isRented() == false) {
                             break;
                        }
                }

            if (randomIntTwo == 1) {
               guestsAccomodation.setElectricity(true);
            }

            guestsAccomodation.setRented(true);
            rentedCaravanSpaces.add(guestsAccomodation);

            return guestsAccomodation;    
        }

        else {

            guestsAccomodation = new Tent();

            return guestsAccomodation; 
        }
        
    }
    
    public static double[] PricePicker(Prices currentPrices, Accomodation accomodation) {
        
        double[] givenPrice = new double[5];
        
        Accomodation priceCheckAccomodation = accomodation;
        
        String priceCheck = priceCheckAccomodation.getAccomodationType();
        
        if (priceCheck.equals("Stuga")) {
            
            givenPrice[0] = currentPrices.getCabinDayLowSeason();
            givenPrice[1] = currentPrices.getCabinDayHighSeason();
            givenPrice[2] = currentPrices.getCabinWeekLowSeason();
            givenPrice[3] = currentPrices.getCabinWeekHighSeason();
            givenPrice[4] = currentPrices.getElectricityPricePerkWH();
            
            return givenPrice;
        }
        
        else if (priceCheck.equals("Husvagnsplats")) {

            givenPrice[0] = currentPrices.getCaravanDayLowSeason();
            givenPrice[1] = currentPrices.getCaravanDayHighSeason();
            givenPrice[2] = currentPrices.getCaravanWeekLowSeason();
            givenPrice[3] = currentPrices.getCaravanWeekHighSeason();
            givenPrice[4] = currentPrices.getElectricityPricePerkWH();
            
            return givenPrice;
        }
        
        else {

            givenPrice[0] = currentPrices.getTentDayLowSeason();
            givenPrice[1] = currentPrices.getTentDayHighSeason();
            givenPrice[2] = currentPrices.getTentWeekLowSeason();
            givenPrice[3] = currentPrices.getTentWeekHighSeason();
            givenPrice[4] = currentPrices.getElectricityPricePerkWH();
            
            return givenPrice;
        }
    }
    
    
        
    public static Guest GuestPopulator (ArrayList<Accomodation> allCabins, ArrayList<Accomodation> allCaravanSpaces, 
                                        ArrayList<Accomodation> rentedCabins, ArrayList<Accomodation> rentedCaravanSpaces, 
                                        ArrayList<Guest> checkedInGuests, Prices currentPrices) {
            
            Accomodation accomodationOne = AccomodationPicker(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces);
            
            double[] givenPriceOne = PricePicker(currentPrices, accomodationOne);
        
            Guest guestOne = new Guest("Hans", "Göransson", "Halkbacken 14", 
                                "0703825654", "17-08-05", "Incheckad", 
                                givenPriceOne, accomodationOne, "217", 0);
            checkedInGuests.add(guestOne);
            
            Accomodation accomodationTwo = AccomodationPicker(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces);
            
            double[] givenPriceTwo = PricePicker(currentPrices, accomodationTwo);
        
            Guest guestTwo = new Guest("Lisa", "Almqvist", "Stenvägen 15", 
                                "0766670032", "17-08-10", "Incheckad", 
                                givenPriceTwo, accomodationTwo, "222", 0);
            checkedInGuests.add(guestTwo);
            
            Accomodation accomodationThree = AccomodationPicker(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces);
            
            double[] givenPriceThree = PricePicker(currentPrices, accomodationThree);
        
            Guest guestThree = new Guest("Petter", "Hansson", "Gågatan 1", 
                                "0709658745", "17-07-15", "Incheckad", 
                                givenPriceThree, accomodationThree, "196", 0);
            checkedInGuests.add(guestThree);
            
            Accomodation accomodationFour = AccomodationPicker(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces);
            
            double[] givenPriceFour = PricePicker(currentPrices, accomodationFour);
        
            Guest guestFour = new Guest("Lasse", "Larsson", "Skrotgatan 3", 
                                "0708867511", "17-07-28", "Incheckad", 
                                givenPriceFour, accomodationFour, "209", 0);
            checkedInGuests.add(guestFour);
            
            Accomodation accomodationFive = AccomodationPicker(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces);
            
            double[] givenPriceFive = PricePicker(currentPrices, accomodationFive);
        
            Guest guestFive = new Guest("Isa", "Granquist", "Istappen 2", 
                                "0766456300", "17-08-11", "Incheckad", 
                                givenPriceFive, accomodationFive, "223", 0);
            checkedInGuests.add(guestFive);
            
            Accomodation accomodationSix = AccomodationPicker(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces);
            
            double[] givenPriceSix = PricePicker(currentPrices, accomodationSix);
        
            Guest guestSix = new Guest("Jan", "Karlsson", "Kronbacka 431", 
                                "0708547632", "17-07-19", "Incheckad", 
                                givenPriceSix, accomodationSix, "200", 0);
            checkedInGuests.add(guestSix);
            
            Accomodation accomodationSeven = AccomodationPicker(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces);
            
            double[] givenPriceSeven = PricePicker(currentPrices, accomodationSeven);
        
            Guest guestSeven = new Guest("Sigurd", "Rosman", "Silkesvägen 9", 
                                "0709674312", "17-08-03", "Incheckad", 
                                givenPriceSeven, accomodationSeven, "215", 0);
            checkedInGuests.add(guestSeven);
            
            Accomodation accomodationEight = AccomodationPicker(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces);
            
            double[] givenPriceEight = PricePicker(currentPrices, accomodationEight);
        
            Guest guestEight = new Guest("Alfons", "Nilsson", "Brukstorget 8", 
                                "0766211233", "17-08-08", "Incheckad", 
                                givenPriceEight, accomodationEight, "220", 0);
            checkedInGuests.add(guestEight);
            
            Accomodation accomodationNine = AccomodationPicker(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces);
            
            double[] givenPriceNine = PricePicker(currentPrices, accomodationNine);
        
            Guest guestNine = new Guest("Fredrik", "Hultgren", "Karamellstigen 1", 
                                "0709819122", "17-08-01", "Incheckad", 
                                givenPriceNine, accomodationNine, "213", 0);
            checkedInGuests.add(guestNine);
            
            Accomodation accomodationTen = AccomodationPicker(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces);
            
            double[] givenPriceTen = PricePicker(currentPrices, accomodationTen);
        
            Guest guestTen = new Guest("Göran", "Hansson", "Rakvägen 32", 
                                "0701942617", "17-07-23", "Incheckad", 
                                givenPriceTen, accomodationTen, "204", 0);
            checkedInGuests.add(guestTen);
            
            
            
            
            return null;
        }
    }
    
    
