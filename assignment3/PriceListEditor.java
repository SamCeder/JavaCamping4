/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import javax.swing.JOptionPane;

/**
 *
 * @author sam_e
 */
public class PriceListEditor {
    
    public static Prices ChangePrice(Prices currentPrices) {
        
        String[] specificPrice = { "Stuga-dygnspris Lågsäsong", "Stuga-dygnspris Högsäsong", 
                                    "Stuga-veckopris Lågsäsong", "Stuga-veckopris Högsäsong",
                                    "Husvagn/husbil-dygnspris Lågsäsong", "Husvagn/husbil-dygnspris Högsäsong", 
                                    "Husvagn/husbil-veckopris Lågsäsong", "Husvagn/husbil-veckopris Högsäsong", 
                                    "Tält-dygnspris Lågsäsong", "Tält-dygnspris Högsäsong", 
                                    "Tält-veckopris Lågsäsong", "Tält-veckopris Högsäsong", 
                                    "Elpris per kWh"};
        String choice = (String)JOptionPane.showInputDialog( null, "Vilket pris vill du ändra?",
            "Prisändring",
            JOptionPane.QUESTION_MESSAGE,
            null,
            specificPrice,
            specificPrice[ 0 ]);

        if (choice.equals("Stuga-dygnspris Lågsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setCabinDayLowSeason(newPrice);
        }
        
        else if (choice.equals("Stuga-dygnspris Högsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setCabinDayHighSeason(newPrice);
        }
        
        else if (choice.equals("Stuga-veckopris Lågsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setCabinWeekLowSeason(newPrice);
        }
        
        else if (choice.equals("Stuga-veckopris Högsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setCabinWeekHighSeason(newPrice);
        }
        
        else if (choice.equals("Husvagn/husbil-dygnspris Lågsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setCaravanDayLowSeason(newPrice);
        }
        
        else if (choice.equals("Husvagn/husbil-dygnspris Högsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setCaravanDayHighSeason(newPrice);
        }
        
        else if (choice.equals("Husvagn/husbil-veckopris Lågsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setCaravanWeekLowSeason(newPrice);
        }
        
        else if (choice.equals("Husvagn/husbil-veckopris Högsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setCaravanWeekHighSeason(newPrice);
        }
        
        else if (choice.equals("Tält-dygnspris Lågsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setTentDayLowSeason(newPrice);
        }
        
        else if (choice.equals("Tält-dygnspris Högsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setTentDayHighSeason(newPrice);
        }
        
        else if (choice.equals("Tält-veckopris Lågsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setTentWeekLowSeason(newPrice);
        }
        
        else if (choice.equals("Tält-veckopris Högsäsong")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr:"));
            currentPrices.setTentWeekHighSeason(newPrice);
        }
        
        else if (choice.equals("Elpris per kWh")) {
            double newPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Ange nytt pris i kr per kWh:"));
            currentPrices.setElectricityPricePerkWH(newPrice);
        }
    
        return null;
    }
    
}
