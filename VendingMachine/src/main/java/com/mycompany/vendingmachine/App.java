/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine;

import com.mycompany.service.InsufficientFundsException;
import com.mycompany.service.NoItemInventoryException;
import com.mycompany.service.NotFoundException;
import com.mycompany.service.VendingMachineService;
import com.mycompany.vendingmachine.controller.VendingMachineController;
import com.mycompany.vendingmachine.data.DataException;
import com.mycompany.vendingmachine.data.VendingMachineAuditDao;
import com.mycompany.vendingmachine.data.VendingMachineFileDao;
import com.mycompany.vendingmachine.ui.ConsoleIO;
import com.mycompany.vendingmachine.ui.UserIO;
import javax.swing.text.View;
import com.mycompany.vendingmachine.data.VendingMachineDao;
import com.mycompany.vendingmachine.ui.VendingMachineView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G10-DEV10W3
 */
public class App {
    
    public static void main(String[] args) throws NotFoundException, NoItemInventoryException, InsufficientFundsException {
        UserIO myIo = new ConsoleIO();
        VendingMachineView myView = new VendingMachineView(myIo);
        VendingMachineFileDao myDao = new VendingMachineFileDao();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDao();
        VendingMachineService myService = new VendingMachineService(myDao, auditDao);
        VendingMachineController controller = new VendingMachineController( myView, myService);
        controller.run();
    }
}
