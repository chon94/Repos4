/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.data;

import com.mycompany.service.VendingMachineException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author G10-DEV10W3
 */
public class VendingMachineAuditDao {
   
    public static final String AUDIT_FILE = "audit.txt";
   
    public void writeAuditEntry(String entry) throws VendingMachineException {
        PrintWriter out;
       
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new VendingMachineException("Could not persist audit information.", e);
        }
 
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
 
}
    

