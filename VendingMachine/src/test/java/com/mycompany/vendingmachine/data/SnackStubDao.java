/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.data;

import com.mycompany.vendingmachine.Snack;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G10-DEV10W3
 */
public class SnackStubDao implements VendingMachineDao {

    private final ArrayList<Snack> snacks = new ArrayList<>();
    
    public SnackStubDao(){
        snacks.add(new Snack(1, "One", new BigDecimal("1.50"), 0));
        snacks.add(new Snack(2, "Two", new BigDecimal("1.50"), 1));
        snacks.add(new Snack(3, "Three", new BigDecimal("1.50"), 100));
    }
    
    @Override
    public List<Snack> findAll() {
        return new ArrayList<>(snacks);
    }

    @Override
    public Snack findById(int snackId) {
        return snacks.stream()
                .filter(s -> s.getId() == snackId)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean update(Snack s) throws DataException {
        return true;
    }
    
}
