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
public class Prices implements Serializable {
    
    double cabinDayLowSeason;
    double cabinDayHighSeason;
    double cabinWeekLowSeason;
    double cabinWeekHighSeason;
    double caravanDayLowSeason;
    double caravanDayHighSeason;
    double caravanWeekLowSeason;
    double caravanWeekHighSeason;
    double tentDayLowSeason;
    double tentDayHighSeason;
    double tentWeekLowSeason;
    double tentWeekHighSeason;
    double electricityPricePerkWH;

    public Prices(double cabinDayLowSeason, double cabinDayHighSeason, double cabinWeekLowSeason, 
            double cabinWeekHighSeason, double caravanDayLowSeason, double caravanDayHighSeason, 
            double caravanWeekLowSeason, double caravanWeekHighSeason, double tentDayLowSeason, 
            double tentDayHighSeason, double tentWeekLowSeason, double tentWeekHighSeason, 
            double electricityPricePerkWH) {
        
        this.cabinDayLowSeason = cabinDayLowSeason;
        this.cabinDayHighSeason = cabinDayHighSeason;
        this.cabinWeekLowSeason = cabinWeekLowSeason;
        this.cabinWeekHighSeason = cabinWeekHighSeason;
        this.caravanDayLowSeason = caravanDayLowSeason;
        this.caravanDayHighSeason = caravanDayHighSeason;
        this.caravanWeekLowSeason = caravanWeekLowSeason;
        this.caravanWeekHighSeason = caravanWeekHighSeason;
        this.tentDayLowSeason = tentDayLowSeason;
        this.tentDayHighSeason = tentDayHighSeason;
        this.tentWeekLowSeason = tentWeekLowSeason;
        this.tentWeekHighSeason = tentWeekHighSeason;
        this.electricityPricePerkWH = electricityPricePerkWH;
    }
    
    //PriceList() {
    //cabinDayLowSeason = newCabinDayLowSeason
    //cabinDayHighSeason = newCabinDayHighSeason
    //cabinWeekLowSeason = newCabinWeekLowSeason
    //cabinWeekHighSeason = newCabinWeekHighSeason
    //caravanDayLowSeason = newCaravanDayLowSeason
    //caravanDayHighSeason = newCaravanDayHighSeason
    //caravanWeekLowSeason = newCaravanWeekLowSeason
    //caravanWeekHighSeason = newCaravanWeekHighSeason
    //tentDayLowSeason = newTentDayLowSeason
    //tentDayHighSeason = newTentDayHighSeason
    //tentWeekLowSeason = newTentWeekLowSeason
    //tentWeekHighSeason = newTentWeekHighSeason
    //electricityPricePerkWH = newElectricityPricePerkWH
    //}
    
    //Setters

    public void setCabinDayLowSeason(double cabinDayLowSeason) {
        this.cabinDayLowSeason = cabinDayLowSeason;
    }

    public void setCabinDayHighSeason(double cabinDayHighSeason) {
        this.cabinDayHighSeason = cabinDayHighSeason;
    }

    public void setCabinWeekLowSeason(double cabinWeekLowSeason) {
        this.cabinWeekLowSeason = cabinWeekLowSeason;
    }

    public void setCabinWeekHighSeason(double cabinWeekHighSeason) {
        this.cabinWeekHighSeason = cabinWeekHighSeason;
    }

    public void setCaravanDayLowSeason(double caravanDayLowSeason) {
        this.caravanDayLowSeason = caravanDayLowSeason;
    }

    public void setCaravanDayHighSeason(double caravanDayHighSeason) {
        this.caravanDayHighSeason = caravanDayHighSeason;
    }

    public void setCaravanWeekLowSeason(double caravanWeekLowSeason) {
        this.caravanWeekLowSeason = caravanWeekLowSeason;
    }

    public void setCaravanWeekHighSeason(double caravanWeekHighSeason) {
        this.caravanWeekHighSeason = caravanWeekHighSeason;
    }

    public void setTentDayLowSeason(double tentDayLowSeason) {
        this.tentDayLowSeason = tentDayLowSeason;
    }

    public void setTentDayHighSeason(double tentDayHighSeason) {
        this.tentDayHighSeason = tentDayHighSeason;
    }

    public void setTentWeekLowSeason(double tentWeekLowSeason) {
        this.tentWeekLowSeason = tentWeekLowSeason;
    }

    public void setTentWeekHighSeason(double tentWeekHighSeason) {
        this.tentWeekHighSeason = tentWeekHighSeason;
    }

    public void setElectricityPricePerkWH(double electricityPricePerkWH) {
        this.electricityPricePerkWH = electricityPricePerkWH;
    }
    
    //Getters
    
    public double getCabinDayLowSeason() {
        return cabinDayLowSeason;
    }

    public double getCabinDayHighSeason() {
        return cabinDayHighSeason;
    }

    public double getCabinWeekLowSeason() {
        return cabinWeekLowSeason;
    }

    public double getCabinWeekHighSeason() {
        return cabinWeekHighSeason;
    }

    public double getCaravanDayLowSeason() {
        return caravanDayLowSeason;
    }

    public double getCaravanDayHighSeason() {
        return caravanDayHighSeason;
    }

    public double getCaravanWeekLowSeason() {
        return caravanWeekLowSeason;
    }

    public double getCaravanWeekHighSeason() {
        return caravanWeekHighSeason;
    }

    public double getTentDayLowSeason() {
        return tentDayLowSeason;
    }

    public double getTentDayHighSeason() {
        return tentDayHighSeason;
    }

    public double getTentWeekLowSeason() {
        return tentWeekLowSeason;
    }

    public double getTentWeekHighSeason() {
        return tentWeekHighSeason;
    }

    public double getElectricityPricePerkWH() {
        return electricityPricePerkWH;
    }
    
    
    
}
