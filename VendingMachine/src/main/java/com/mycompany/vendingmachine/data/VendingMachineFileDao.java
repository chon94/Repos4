/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.vendingmachine.data;

import com.mycompany.vendingmachine.Snack;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G10-DEV10W3
 */
public class VendingMachineFileDao implements VendingMachineDao {
//    private ArrayList<Snack> snacks;
    private final String FILE_PATH = "inventory.txt";
    
    public VendingMachineFileDao(){
  //      this.FILE_PATH = FILE_PATH;
    }

    VendingMachineFileDao(String inventorytxt) {
        
    }
    
    @Override
    public List<Snack> findAll() throws DataException{
   
           // ArrayList<Snack> snacks = load();
            return load();
      
    }
    @Override
    public Snack findById(int snackId) throws DataException{
        return findAll().stream()
                .filter(s -> s.getId() == snackId)
                .findAny()
                .orElse(null);
    }
    
    @Override
    public boolean update(Snack s) throws DataException{

        ArrayList<Snack> snacks = load();
       
        
        for(int i = 0; i < snacks.size(); i++){
            if(snacks.get(i).getId() == s.getId()){
                snacks.set(i, s);
                write(snacks);
                return true;
            }
        }
        return false;
    }
    
    private ArrayList<Snack> load() throws DataException {
//        
//        if(snacks != null){
//            return;
//        }
        
       ArrayList<Snack> snacks = new ArrayList<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
//            String line = reader.readLine();
            String line = null;

            while((line = reader.readLine()) != null){
                Snack snack = unmarshall(line);
                if(snack != null){
                    snacks.add(snack);
                }
//                line = reader.readLine();
            }
        }catch(IOException ex){
            throw new DataException(ex.getMessage(), ex);
        }
      return snacks;      
    }
    
    private void write(ArrayList<Snack> snacks) throws DataException{
        try(PrintWriter writer = new PrintWriter(FILE_PATH)){
            
           // writer.println("id,item_name,cost,inventory");        
            
            for(Snack s: snacks){
                String line = marshall(s);
                writer.println(line);
           }
        } catch (IOException ex){
            throw new DataException(ex.getMessage(), ex);
        }
    }

    private Snack unmarshall(String line) {
        String[] tokens = line.split(",");
        if(tokens.length != 4){
            return null;
        }
        Snack vendingMachine = new Snack();
        vendingMachine.setId(Integer.parseInt(tokens[0]));
        vendingMachine.setSnackName(tokens[1]);
        vendingMachine.setCost(new BigDecimal(tokens[2]));
        vendingMachine.setInventory(Integer.parseInt(tokens[3]));
        
        return vendingMachine;
    }

    private String marshall(Snack s) {
        return String.format("%s,%s,%s,%s", 
                s.getId(),
                s.getSnackName(),
                s.getCost(),
                s.getInventory());
    }
}
