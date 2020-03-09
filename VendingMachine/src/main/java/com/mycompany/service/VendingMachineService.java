/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.vendingmachine.Snack;
import com.mycompany.vendingmachine.data.DataException;
import com.mycompany.vendingmachine.data.VendingMachineAuditDao;
import java.math.BigDecimal;
import com.mycompany.vendingmachine.data.VendingMachineDao;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author G10-DEV10W3
 */
public class VendingMachineService {
    
    private final VendingMachineDao snackDao;
    private final VendingMachineAuditDao auditDao;
    
    public VendingMachineService(VendingMachineDao snackDao, VendingMachineAuditDao auditDao){
        this.snackDao = snackDao;
        this.auditDao = auditDao;
    }

    VendingMachineService(SnackStubDao snackStubDao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public BigDecimal purchase(int snackId,BigDecimal payment) 
            throws NotFoundException, NoItemInventoryException, 
            InsufficientFundsException, DataException, VendingMachineException{
        
        if (payment == null || payment.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException(); //uncheck
        }
        
        Snack s = snackDao.findById(snackId);
        if(s == null){
            throw new NotFoundException("Snack id " + snackId + " not found.");
        }
        
        if(s.getInventory() < 1) {
            throw new NoItemInventoryException(s.getSnackName() + " is out of stock!");
        }
        
        BigDecimal effectiveCost = s.getCost();
        
      if (payment.compareTo(effectiveCost) < 0) {
            throw new InsufficientFundsException("Not enough $.");
        }

        s.setInventory(s.getInventory() - 1);
        snackDao.update(s);

        auditDao.writeAuditEntry(s.getId() + s.getSnackName() + LocalDate.now());
        
        return payment.subtract(effectiveCost);
        
        }
    public List<Snack> findAll() throws DataException{
        return snackDao.findAll();

        
    
//    public BigDecimal purchase(int snackId, int quantity, BigDecimal payment) 
//            throws NotFoundException, NoItemInventoryException, 
//            InsufficientFundsException, DataException{
//        
//        if (quantity <= 0 || payment == null || payment.compareTo(BigDecimal.ZERO) <= 0){
//            throw new IllegalArgumentException(); //uncheck
//        }
//        
//        Snack s = snackDao.findById(snackId);
//        if(s == null){
//            throw new NotFoundException("Snack id " + snackId + " not found.");
//        }
//        
//        if(s.getInventory() < quantity) {
//            throw new NoItemInventoryException(s.getSnackName() + " is out of stock!");
//        }
//        
//        BigDecimal effectiveCost = s.getCost().multiply(new BigDecimal(quantity));
//        
//      if (payment.compareTo(effectiveCost) < 0) {
//            throw new InsufficientFundsException("Not enough $.");
//        }
//
//        s.setInventory(s.getInventory() - quantity);
//        snackDao.update(s);
//
//        return payment.subtract(effectiveCost);
//        
//        }
//    public List<Snack> findAll() throws DataException{
//        return snackDao.findAll();
    }

    void purchase(int i, int i0, BigDecimal bigDecimal) {
        
    }

    private static class SnackStubDao {

        public SnackStubDao() {
        }
    }
        
    }

