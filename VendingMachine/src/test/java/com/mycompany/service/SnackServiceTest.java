
package com.mycompany.service;

import com.mycompany.vendingmachine.data.SnackStubDao;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SnackServiceTest {
    
    private VendingMachineService service;
    
//    public SnackServiceTest() {
//        this.service = new VendingMachineService(newSnackStubDao());
//    }

    @Test
    public void testPurchaseIllegalArgs() throws Exception {
        try{
        service.purchase(1, 0, new BigDecimal("1.00"));
        fail("Expected IllegalArgumentException for quantity 0.");
        } catch (IllegalArgumentException ex) {
            //This is a good thing
        }
        try {
            service.purchase(1, 1, null);
            fail("Expected IllegalArgumentException for null payment.");
        } catch (IllegalArgumentException ex) {
            // this is a good thing
        }

        try {
            service.purchase(1, 1, new BigDecimal("-1.00"));
            fail("Expected IllegalArgumentException for negative payment.");
        } catch (IllegalArgumentException ex) {
            // this is a good thing
        }
    }
     
    
     @Test
    public void testPurchaseNotFound() throws Exception {

        service.purchase(15, 1, new BigDecimal("10.00")); // this is good!
//        assertThrows(
//                NotFoundException.class,
//                () -> service.purchase(15, 1, new BigDecimal("10.00"))
//        );
fail("Expected NotFoundException");
    }

    @Test
    public void testPurchaseOutOfStockQuantityOne() throws Exception {
        service.purchase(1, 1, new BigDecimal("10.00")); // this is good!
        fail("Expected NotFoundException");
    }

    @Test
    public void testPurchaseOutOfStockQuantityTen() throws Exception {
        service.purchase(2, 10, new BigDecimal("10.00")); // this is good!
        fail("Expected NotFoundException");
    }

    @Test
    public void testPurchaseInsufficientFundsQuantityOne() throws Exception {
        service.purchase(3, 1, new BigDecimal("1.00")); // this is good!
        fail("Expected InsufficientFundsException");
    }

    @Test
    public void testPurchaseInsufficientFundsQuantityTen() throws Exception {
        service.purchase(3, 10, new BigDecimal("10.00")); // this is good!
        fail("Expected InsufficientFundsException");
    }

//    @Test
//    public void testPurchase() throws Exception {
//        BigDecimal actual = service.purchase(3, 1, new BigDecimal("10.00"));
//        BigDecimal expected = new BigDecimal("8.50");
//        assertEquals(expected, actual);
//    }
    
}
