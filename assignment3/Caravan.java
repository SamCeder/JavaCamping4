/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author sam_e
 */
public class Caravan extends Accomodation {
    boolean electricity;
    double electricityMeter;

    public Caravan(String name, boolean rented, boolean electricity, double electricityMeter) {
        this.name = name;
        this.rented = rented;
        this.electricity = electricity;
        this.electricityMeter = electricityMeter;
        accomodationType = "Husvagnsplats";
    }
    
    @Override
    public boolean isElectricity() {
        return electricity;
    }
    
    @Override
    public void setElectricity(boolean electricity) {
        this.electricity = electricity;
    }
    
    @Override
    public double getElectricityMeter() {
        return electricityMeter;
    }
    
    @Override
    public void setElectricityMeter(double electricityMeter) {
        this.electricityMeter = electricityMeter;
    }
    
    
}
