/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.ui;

import java.math.BigDecimal;

/**
 *
 * @author G10-DEV10W3
 */
public interface UserIO {
    
    void print(String message);

    String readString(String prompt);

    String readRequiredString(String prompt);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);
    
    BigDecimal readBigDecimalFromString(String prompt);
}
