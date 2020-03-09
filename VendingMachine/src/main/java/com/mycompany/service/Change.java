/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import java.math.BigDecimal;
import static java.math.RoundingMode.DOWN;

/**
 *
 * @author G10-DEV10W3
 */
public class Change {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

   public Change(BigDecimal change) {
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal changeInPennies = change.multiply(hundred);
        BigDecimal quarter = new BigDecimal("25");
        BigDecimal dime = new BigDecimal("10");
        BigDecimal nickel = new BigDecimal("5");

        //Find out how many quarters are in change
        BigDecimal numQuarters = changeInPennies.divide(quarter, 0, DOWN);

        BigDecimal amountToSubtract = numQuarters.multiply(quarter);

        changeInPennies = changeInPennies.subtract(amountToSubtract);

        //Find out how many dimes are in the remaining change
        BigDecimal numDimes = changeInPennies.divide(dime, 0, DOWN);

        amountToSubtract = numDimes.multiply(dime);

        changeInPennies = changeInPennies.subtract(amountToSubtract);

        //Find out how many nickels are in the remaining change
        BigDecimal numNickels = changeInPennies.divide(nickel, 0, DOWN);

        amountToSubtract = numNickels.multiply(nickel);

        changeInPennies = changeInPennies.subtract(amountToSubtract);

        //Find out how many pennies are in the remaining change
        BigDecimal numPennies = changeInPennies;

        quarters = numQuarters.intValue();
        dimes = numDimes.intValue();
        nickels = numNickels.intValue();
        pennies = numPennies.intValue();
    }

    public int getQuarters() {
        return quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public int getPennies() {
        return pennies;
    }

}
