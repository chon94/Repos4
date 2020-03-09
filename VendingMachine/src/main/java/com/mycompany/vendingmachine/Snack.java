/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine;

import java.math.BigDecimal;

/**
 *
 * @author G10-DEV10W3
 */
public class Snack {
    
    private int id;
    private String snackName;
    private BigDecimal cost;
    private int inventory;

     public Snack() {

    }
     public Snack(int id, String snackName, BigDecimal cost, int inventory) {
        this.id = id;
        this.snackName = snackName;
        this.cost = cost;
        this.inventory = inventory;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSnackName() {
        return snackName;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
