/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.controller;

import com.mycompany.service.Change;
import com.mycompany.service.InsufficientFundsException;
import com.mycompany.service.NoItemInventoryException;
import com.mycompany.service.NotFoundException;
import com.mycompany.service.VendingMachineService;
import com.mycompany.service.VendingMachineException;
import com.mycompany.vendingmachine.Snack;
import com.mycompany.vendingmachine.data.DataException;
import com.mycompany.vendingmachine.data.VendingMachineDao;
import com.mycompany.vendingmachine.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.text.View;

/**
 *
 * @author G10-DEV10W3
 */
public class VendingMachineController {
    
     private VendingMachineView view;
     private VendingMachineService service;
     

    public VendingMachineController(VendingMachineView view, VendingMachineService service) {
//        this.dao = dao;
        this.view = view;
        this.service = service;
    }

 
    public void run() throws NotFoundException, NoItemInventoryException, InsufficientFundsException {

         boolean isRunning = true;

        try {
            while (isRunning) {
                //Display all treats
                List<Snack> findAll = service.findAll();
                view.selectFromMainMenu(findAll);
                
                //Display menu and get user selection
                int menuChoice = view.displaySnackAndMakeSelection();

                switch (menuChoice) {
                    case 1:
                        insertMoney();
                        break;
                    case 0:
                        isRunning = false;
                        break;
                }
            }
            view.displayExitMessage();
        } catch (VendingMachineException | DataException e) {
            view.displayErrorMessage(e.getMessage());
        } 
    
 }
public void insertMoney()
            throws VendingMachineException, NotFoundException, 
        NoItemInventoryException, InsufficientFundsException, DataException {
    
    
     boolean hasErrors = false;

        do {
            //Prompt user to add money
            BigDecimal addMoney = view.insertMoney();
            //Prompt user to select a treat to buy
            int mySnackId = view.chooseSnack();
            //Send the treat selection + money amt to service for validation check
            try {
                BigDecimal changeToReturn = service.purchase(mySnackId, addMoney);
                returnChange(changeToReturn);
                hasErrors = false;
            } catch (InsufficientFundsException | NoItemInventoryException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);

    }
    
    public void returnChange(BigDecimal c) {
        Change change = new Change(c);
        int quarters = change.getQuarters();
        int dimes = change.getDimes();
        int nickels = change.getNickels();
        int pennies = change.getPennies();
        
        view.displayChange(quarters, dimes, nickels, pennies);
    }
}

