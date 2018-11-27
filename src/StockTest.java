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

 
    @Test
    void stockGetterTest() {
        // 1st Test
        assertEquals(stock.getTickerSymbol(), "TSLA");
        // 2nd Test
        assertEquals(stock.getName(), "Tesla");
        // 4th Test
        assertEquals(stock.getPricePerShare(), 5);
        // 5th Test
        assertEquals(stock.getNumShares(), 5);
        // 6th Test
        assertEquals(stock.getChange(), true);
        // 7th Test
        assertEquals(stock.getHolding(), 25);
    }
    
    @Test
    void stockSetterTest() {
    	
    	// 1st test
    	stock.setPricePerShare(2);
        assertEquals(stock.getPricePerShare(), 2);
        assertEquals(stock.getHolding(), 10);
        assertEquals(stock.getChange(), false);
    	// 2nd Test
    	stock.setPricePerShare(10);
        assertEquals(stock.getPricePerShare(), 10);
        assertEquals(stock.getHolding(), 50);
        assertEquals(stock.getChange(), true);
        // 3rd Test
        stock.setNumShares(10);
        assertEquals(stock.getNumShares(), 10);
        assertEquals(stock.getHolding(), 100);
        // 4th Test
        stock.setChange(false);
        assertEquals(stock.getChange(), false);
        
    }
    
    
    
}
