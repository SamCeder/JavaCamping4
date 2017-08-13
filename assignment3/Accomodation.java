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
public abstract class Accomodation implements Serializable{
    String accomodationType;
    String name;
    boolean rented;

    public Accomodation() {
    }
    
    public String getAccomodationType() {
        return accomodationType;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
    
    
    public boolean isElectricity() {
        return false;
    }
    
    public void setElectricity(boolean electricity) {
        
    }
    
    public double getElectricityMeter() {
        return 0;
    }
    
    public void setElectricityMeter(double electricityMeter) {
        
    }
    
    
}
