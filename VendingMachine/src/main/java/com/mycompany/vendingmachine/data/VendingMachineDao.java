/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.data;

import com.mycompany.vendingmachine.Snack;
import java.util.List;

/**
 *
 * @author G10-DEV10W3
 */
public interface VendingMachineDao {

    List<Snack> findAll() throws DataException;

    Snack findById(int snackId) throws DataException;

    boolean update(Snack s) throws DataException;
    
}
