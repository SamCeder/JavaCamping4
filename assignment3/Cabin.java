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
public class Cabin extends Accomodation {

    public Cabin(String name, boolean rented) {
        this.name = name;
        this.rented = rented;
        accomodationType = "Stuga";
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
    
    
    
}
