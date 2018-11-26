import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StockTest {

	Stock stock;
	
	/**
     * Create an instance of Stock before each test
     */
    @BeforeEach
    void setUp() {
        stock = new Stock("TSLA", "Tesla", 5, 5, true);
    }

    /**
     * 3 Tests for createFolio(String name):
     * <p>
     * 1st Test: Assert that a call to createFolio(String name) with a name that has not been used for a folio previously, returns true when a new Folio is created with that name.
     * 2nd Test: Assert that the new Folio object from 1st test has the correct name.
     * 3rd Test: Assert that a call to createFolio(String name) with a name that has been used for a folio previously, returns false.
     */
    @Test
    void stockGetterTest() {
        // 1st Test
        assertEquals(stock.getTickerSymbol(), "TSLA");
        // 2nd Test
        assertEquals(stock.getName(), "Tesla");
        // 4th Test
        assertEquals(stock.getPricePerShare(), 5);
        // 5th Test
        assertEquals(stock.getNumOfShares(), 5);
        // 6th Test
        assertEquals(stock.getChange(), true);
        // 7th Test
        assertEquals(stock.getValue(), 25);
    }
    
    @Test
    void stockSetterTest() {
    	
    	// 1st test
    	stock.setPricePerShare(2);
        assertEquals(stock.getPricePerShare(), 2);
        assertEquals(stock.getValue(), 10);
        assertEquals(stock.getChange(), false);
    	// 2nd Test
    	stock.setPricePerShare(10);
        assertEquals(stock.getPricePerShare(), 10);
        assertEquals(stock.getValue(), 50);
        assertEquals(stock.getChange(), true);
        // 3rd Test
        stock.setNumOfShares(10);
        assertEquals(stock.getNumOfShares(), 10);
        assertEquals(stock.getValue(), 100);
        // 4th Test
        stock.setChange(false);
        assertEquals(stock.getChange(), false);
        
    }
    
    
    
}
