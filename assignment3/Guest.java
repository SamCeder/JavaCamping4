/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import java.io.*;

/**
 *
 * @author sam_e
 */
public class Guest implements Serializable{
    String name;
    String lastname;
    String adress;
    String phoneNumber;
    String checkInDate;
    String checkOutDate;
    double[] givenPrice;
    Accomodation assignedAccomodation;
    String priceCheckDate;
    double priceOfStay;

    public Guest(String name, String lastname, String adress, String phoneNumber, 
            String checkInDate, String checkOutDate, double[] givenPrice, 
            Accomodation assignedAccomodation, String priceCheckDate, double priceOfStay) {
        this.name = name;
        this.lastname = lastname;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.givenPrice = givenPrice;
        this.assignedAccomodation = assignedAccomodation;
        this.priceCheckDate = priceCheckDate;
        this.priceOfStay = priceOfStay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double[] getGivenPrice() {
        return givenPrice;
    }

    public void setGivenPrice(double[] givenPrice) {
        this.givenPrice = givenPrice;
    }

    public Accomodation getAssignedAccomodation() {
        return assignedAccomodation;
    }

    public void setAssignedAccomodation(Accomodation assignedAccomodation) {
        this.assignedAccomodation = assignedAccomodation;
    }

    public String getPriceCheckDate() {
        return priceCheckDate;
    }

    public void setPriceCheckDate(String priceCheckDate) {
        this.priceCheckDate = priceCheckDate;
    }

    public double getPriceOfStay() {
        return priceOfStay;
    }

    public void setPriceOfStay(double priceOfStay) {
        this.priceOfStay = priceOfStay;
    }
    
    
    
    
    
    
}
