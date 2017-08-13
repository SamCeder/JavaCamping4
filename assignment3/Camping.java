/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.io.*;

/**
 *
 * @author sam_e
 */
public class Camping implements Serializable {
    
        private ArrayList<Guest> checkedInGuests;
        private ArrayList<Guest> previousGuests;
        private ArrayList<Accomodation> recentlyCheckedOutCabins;
        private ArrayList<Accomodation> allCabins;
        private ArrayList<Accomodation> rentedCabins;
        private ArrayList<Accomodation> allCaravanSpaces;
        private ArrayList<Accomodation> rentedCaravanSpaces;
        private Prices currentPrices;
        private double cabinIncome;
        private double caravanIncome;
        private double tentIncome;
        private int cabinNights;
        private int caravanNights;
        private int tentNights;
        
        public void Save() { //Sparar data till text-fil.
            try {
            ObjectOutputStream objUt = new ObjectOutputStream(
                                       new FileOutputStream("sparfil.txt"));
            objUt.writeObject(this);
            } catch(Exception e) {
            System.out.println(e);}
        }
        public void Load() { //Laddar data ifrån text-fil
            try {
            ObjectInputStream objIn = new ObjectInputStream
                                        (new FileInputStream("sparfil.txt"));
            Camping javaCamping = (Camping)objIn.readObject();
            checkedInGuests = javaCamping.checkedInGuests;
            previousGuests = javaCamping.previousGuests;
            recentlyCheckedOutCabins = javaCamping.recentlyCheckedOutCabins;
            allCabins = javaCamping.allCabins;
            rentedCabins = javaCamping.rentedCabins;
            allCaravanSpaces = javaCamping.allCaravanSpaces;
            rentedCaravanSpaces = javaCamping.rentedCaravanSpaces;
            currentPrices = javaCamping.currentPrices;
            cabinIncome = javaCamping.cabinIncome;
            caravanIncome = javaCamping.caravanIncome;
            tentIncome = javaCamping.tentIncome;
            cabinNights = javaCamping.cabinNights;
            caravanNights = javaCamping.caravanNights;
            tentNights = javaCamping.tentNights;
            } catch(Exception e) {}
        }

    /**
     * @param args the command line arguments
     */
    public Camping(){ //Skapar de listor som verkstaden behöver
            checkedInGuests = new ArrayList<>();
            previousGuests = new ArrayList<>();
            recentlyCheckedOutCabins = new ArrayList<>();
            allCabins = new ArrayList<>();
            rentedCabins = new ArrayList<>();
            allCaravanSpaces = new ArrayList<>();
            rentedCaravanSpaces = new ArrayList<>();
            currentPrices = new Prices(300, 500, 1900, 3200, 150, 200, 800, 1200, 
                                       75, 100, 400, 550, 1.95);
            cabinIncome = 0;
            caravanIncome = 0;
            tentIncome = 0;
            cabinNights = 0;
            caravanNights = 0;
            tentNights = 0;
            
            FirstTimeSetup.AccomodationPopulator(allCabins, allCaravanSpaces);
            FirstTimeSetup.GuestPopulator(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces, checkedInGuests, currentPrices);
            
        }
    
    public void GuestCheckIn() {
        Guest newGuest = CheckIn.CheckInGuest(allCabins, allCaravanSpaces, rentedCabins, 
                                                rentedCaravanSpaces, currentPrices);
        checkedInGuests.add(newGuest);
    }
    
    public void GuestCheckOutPrep(Guest searchedGuest) {
        CheckOut.CheckOutGuest(searchedGuest);
    }
    
    public String GuestToString (Guest guest) {
        String name = (guest.getName() + " " + guest.getLastname());
        Accomodation accomodation = guest.getAssignedAccomodation();
        String accomodationType = accomodation.getAccomodationType();
        String accomodationName = accomodation.getName();
        String guestString = "Namn: " + name + "\nLogityp: " + accomodationType + 
                                " " + accomodationName;
        return guestString;
    }
    
    public String CheckedInGuestsToString (ArrayList<Guest> checkedInGuests) {
            String guestString ="";
            for (Guest guest : checkedInGuests) {
                String result = GuestToString(guest);
                guestString += result + "\n\n";
            }
            return guestString;
    }
    
    public String GetCheckedInGuests () {
    String guestString = CheckedInGuestsToString (checkedInGuests);
    return guestString;
    }
    
    public String CabinToString (Accomodation cabin) {
        String name = (cabin.getName());
        return name;
    }
    
    public String CheckedOutCabinsToString (ArrayList<Accomodation> recentlyCheckedOutCabins) {
            String cabinString ="";
            for (Accomodation cabin : recentlyCheckedOutCabins) {
                String result = CabinToString(cabin);
                cabinString += result + "\n";
            }
            return cabinString;
    }
    
    public String GetRecentlyCheckedOutCabins () {
        String cabinString = CheckedOutCabinsToString (recentlyCheckedOutCabins);
        return cabinString;
    }
    
    public void ClearListRecentlyCheckedOutCabins () {
        recentlyCheckedOutCabins.clear();
    }
    
    public void GuestCheckOut() {
            String phoneNumber = JOptionPane.showInputDialog("Ange gästens telefonnummer", 
                    null);
            Guest searchedGuest = GuestSearch(phoneNumber);
            if (searchedGuest == null) {
                GuestNotFound();
            }
            else {
                GuestCheckOutPrep(searchedGuest);
                ShowCheckOutInfo(searchedGuest);
                Accomodation accomodation = searchedGuest.getAssignedAccomodation();
                if (accomodation.getAccomodationType().equals("Stuga")) {
                    cabinIncome += searchedGuest.getPriceOfStay();
                    cabinNights += LengthOfStay.DaysOfStay(searchedGuest);
                    recentlyCheckedOutCabins.add(accomodation);
                    rentedCabins.remove(accomodation);
                }
                else if (accomodation.getAccomodationType().equals("Husvagnsplats")) {
                    caravanIncome += searchedGuest.getPriceOfStay();
                    caravanNights += LengthOfStay.DaysOfStay(searchedGuest);
                    rentedCaravanSpaces.remove(accomodation);
                    if (accomodation.isElectricity() == true) {
                        accomodation.setElectricity(false);
                    }
                }
                else {
                    tentIncome += searchedGuest.getPriceOfStay();
                    tentNights += LengthOfStay.DaysOfStay(searchedGuest);
                    accomodation = null;
                }
                previousGuests.add(searchedGuest);
                checkedInGuests.remove(searchedGuest);
            }
        }
    
    public Guest GuestSearch (String phoneNumber) {
            for (Guest guest : checkedInGuests) {
                if (phoneNumber.equals(guest.getPhoneNumber())) {
                    return guest;
                }

            }
            return null;
        }
    
    public void GuestNotFound () {
            JOptionPane.showMessageDialog(null, "Telefonnumret matchade inte någon av de nuvarande gästernas");
        }
    
    public void ShowCheckOutInfo (Guest guest) {
            Accomodation accomodation = guest.getAssignedAccomodation();
            String accomodationName = accomodation.accomodationType + ": " + 
                    accomodation.name;
            JOptionPane.showMessageDialog(null, "Namn: " + guest.getName() + " " +
                    guest.getLastname() + "\nAdress: " + guest.getAdress() + "\nTelefonnummer: " + 
                    guest.getPhoneNumber() + "\nAnkomstdatum: " + guest.getCheckInDate() + 
                    "\nAvfärdsdatum: " + guest.getCheckOutDate() + "\nLogi: " + 
                    accomodationName + "\nTotal kostnad: " + guest.getPriceOfStay() + " kr");
        }
    
    public void ShowPreviousGuestInfo () {
        String guestString ="";
            for (Guest guest : previousGuests) {
                String result = PreviousGuestToString(guest);
                guestString += result + "\n" + "\n";    
        }
        JOptionPane.showMessageDialog(null, "Tidigare incheckade gäster:\n\n" + guestString);    
    }
    
    public void ShowCurrentGuestInfo () {
        String guestString ="";
            for (Guest guest : checkedInGuests) {
                String result = CurrentGuestToString(guest);
                guestString += result + "\n" + "\n";    
        }
        JOptionPane.showMessageDialog(null, "Nuvarande gäster:\n\n" + guestString);    
    }
    
    public void ShowAllGuestInfo () {
        String guestString = "";
        String previousGuestString = "";
            for (Guest guest : checkedInGuests) {
                String result = CurrentGuestToString(guest);
                guestString += result + "\n" + "\n";    
            }
            for (Guest guest : previousGuests) {
                String result = PreviousGuestToString(guest);
                previousGuestString += result + "\n" + "\n";    
        }
            
        JOptionPane.showMessageDialog(null, "Nuvarande gäster:\n\n" + guestString + 
                                        "\n\nTidigare incheckade gäster:\n\n" + 
                                            previousGuestString);    
    }
    
    public String PreviousGuestToString (Guest guest) {
        Accomodation accomodation = guest.getAssignedAccomodation();
        String accomodationName = accomodation.accomodationType + ": " + 
                                    accomodation.name;
        String guestString = "Namn: " + guest.getName() + " " +
                    guest.getLastname() + "\nAdress: " + guest.getAdress() + "\nTelefonnummer: " + 
                    guest.getPhoneNumber() + "\nAnkomstdatum: " + guest.getCheckInDate() + 
                    "\nAvfärdsdatum: " + guest.getCheckOutDate() + "\nLogi: " + 
                    accomodationName + "\nTotal kostnad: " + guest.getPriceOfStay() + " kr";
        
        return guestString;
        }
    
    public String CurrentGuestToString (Guest guest) {
        Accomodation accomodation = guest.getAssignedAccomodation();
        String accomodationName = accomodation.accomodationType + ": " + 
                                    accomodation.name;
        String guestString = "Namn: " + guest.getName() + " " +
                    guest.getLastname() + "\nAdress: " + guest.getAdress() + "\nTelefonnummer: " + 
                    guest.getPhoneNumber() + "\nAnkomstdatum: " + guest.getCheckInDate() + 
                    "\nAvfärdsdatum: " + guest.getCheckOutDate() + "\nLogi: " + 
                    accomodationName;
        
        return guestString;
        }
    
    public void ShowAllCabins () {
        String cabinString ="";
        for (Accomodation cabin : allCabins) {
            String result = CabinInfoToString(cabin);
            cabinString += result + "\n\n";
        }
        JOptionPane.showMessageDialog(null, cabinString);
            
    }
    
    public String CabinInfoToString (Accomodation cabin) {
        String status;
        if (cabin.isRented() == true) {
            status = "Uthyrd";
        }
        
        else {
            status = "Ledig";
        }
        String info = "Namn: " + cabin.getName() + "\nStatus: " + 
                        status;
        return info;
    }
    
    public void ShowPriceList () {
         String priceList ="Lågsäsong:\n" + "\nStuga-dygnspris: " + currentPrices.cabinDayLowSeason + " kr" + 
                            "\nStuga-veckopris: " + currentPrices.cabinWeekLowSeason + " kr" + 
                            "\n\nHusvagn/husbil-dygnspris: " + currentPrices.caravanDayLowSeason + " kr" + 
                            "\nHusvagn/husbil-veckopris: " + currentPrices.caravanWeekLowSeason + " kr" + 
                            "\n\nTält-dygnspris: " + currentPrices.tentDayLowSeason + " kr" + 
                            "\nTält-veckopris: " + currentPrices.tentWeekLowSeason + " kr" + 
                            "\n\nHögsäsong:\n" + "\nStuga-dygnspris: " + currentPrices.cabinDayHighSeason + " kr" + 
                            "\nStuga-veckopris: " + currentPrices.cabinWeekHighSeason + " kr" + 
                            "\n\nHusvagn/husbil-dygnspris: " + currentPrices.caravanDayHighSeason + " kr" + 
                            "\nHusvagn/husbil-veckopris: " + currentPrices.caravanWeekHighSeason + " kr" + 
                            "\n\nTält-dygnspris: " + currentPrices.tentDayHighSeason + " kr" + 
                            "\nTält-veckopris: " + currentPrices.tentWeekHighSeason + " kr" + 
                            "\n\nElpris per kWh: " + currentPrices.electricityPricePerkWH + " kr";
         
         JOptionPane.showMessageDialog(null, priceList);
    }
    
    public void EditPriceList () {
            PriceListEditor.ChangePrice(currentPrices);

        }
    
    public void ShowIncome () {
        double total = cabinIncome + caravanIncome + tentIncome;
        JOptionPane.showMessageDialog(null, "Intäkter för Java Camping" + 
                                        "\n\nIntäkter från stugor: " + cabinIncome + " kr" + 
                                        "\n\nIntäkter från husvagn/husbil: " + caravanIncome + " kr" + 
                                        "\n\nIntäkter från tält: " + tentIncome + " kr" + 
                                        "\n\nTotala intäkter: " + total + " kr"); 
    }
    
    public void ShowNights () {
        int total = cabinNights + caravanNights + tentNights;
        JOptionPane.showMessageDialog(null, "Antal gästnätter hos Java Camping" + 
                                        "\n\nGästnätter i stugor: " + cabinNights + " nätter" + 
                                        "\n\nGästnätter i husvagn/husbil: " + caravanNights + " nätter" + 
                                        "\n\nGästnätter i tält: " + tentNights + " nätter" + 
                                        "\n\nTotalt antal gästnätter: " + total + " nätter");
    }
}
