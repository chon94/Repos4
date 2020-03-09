/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.ui;

import com.mycompany.vendingmachine.Snack;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author G10-DEV10W3
 */
public class VendingMachineView {
    
     private ConsoleIO io = new ConsoleIO();

    public VendingMachineView(UserIO myIo) {
       
    }
    
//    public void SnackStubDao(){
//        
//    }
    
    public void selectFromMainMenu(List<Snack> snackList) {
        io.print("THE BEST VENDING MACHINE");
        io.print("==============");
        for(Snack snack : snackList) {
            io.print(snack.getSnackName());
            io.print("Snack ID: " + snack.getId());
            io.print("Cost: " + snack.getCost());
            io.print("Inventory Count: " + snack.getInventory());
            io.print("");
        }
    }
    
    public int displaySnackAndMakeSelection() {
        io.print("Enter '1' to insert money and make selection.");
        io.print("Enter '0' to exit.");

        return io.readInt("Your selection: ", 0, 1);
    }
    
    public BigDecimal insertMoney() {
         BigDecimal moneyInserted = io.readBigDecimalFromString
            ("Please insert your money: ");
         return moneyInserted;
    }
    
  
    public int chooseSnack() {
       int snackSelection = io.readInt("Please enter the snack ID you want to purchase: ");
       return snackSelection;
    }
    
    public void displayChange(int quarters, int dimes, int nickels, int pennies) {
        io.print("Your purchase was successsful. Here's your change!");
        io.print(quarters + " quarters, " 
                    + dimes + " dimes, "
                    + nickels + " nickels, and " 
                    + pennies + " pennies.");
        io.print("");
    }
    
    public void displayError() {
        io.print("Error");
    }
    
    public void displayExitMessage() {
        io.print("Thank you! Goodbye.");
    }
    
     public void displayErrorMessage(String message) {
        io.print(message);
    }
    
}
