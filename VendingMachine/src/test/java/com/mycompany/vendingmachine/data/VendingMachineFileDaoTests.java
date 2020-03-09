package com.mycompany.vendingmachine.data;

import com.mycompany.vendingmachine.Snack;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class VendingMachineFileDaoTests {
    
    private VendingMachineFileDao dao = new VendingMachineFileDao("inventory.txt");
    
    public VendingMachineFileDaoTests() {
    }

    @Test
    public void testFindAll() throws DataException {
        List<Snack> all = dao.findAll();
        assertEquals(4, all.size());
    }
    
     @Test
    public void testFindById() throws DataException {
        Snack s = dao.findById(4);
        assertNotNull(s);
        assertEquals("Lays", s.getSnackName()); 
    }
    
    @Test
    public void testFindByIdDoesntExist() throws DataException {
        Snack s = dao.findById(10);
        assertNull(s);
    }
    
    @Test
    public void testUpdate() throws DataException {
        
     Snack snack = new Snack();
     //3,Doritos,1.25,5
     snack.setId(3);
     snack.setSnackName("Kitkat");
     snack.setCost(new BigDecimal("2.25"));
     snack.setInventory(0);
     
     boolean actual = dao.update(snack);
     
     assertTrue(actual);
     
     Snack updatedSnack = dao.findById(3);
     assertEquals("Kitkat", updatedSnack.getSnackName());
    }
    
}
