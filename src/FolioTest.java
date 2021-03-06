import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class FolioTest {

    Folio folio;

    /**
     * Create a fresh instance of Folio before each test so each test may construct the Folio as needed
     */
    @BeforeEach
    void setUp(){
        folio = new Folio("Folio 1");
        folio.addStock("AAA", "Stock1", 10.0, 10, true);
        folio.addStock("BBB", "Stock2", 20.0, 1, true);
        folio.addStock("CCC", "Stock3", 5.0, 1, true);
    }

    @Test
    void totalHoldingTest() {
        // 1st Test
        assertEquals(folio.totalHolding(), 125.0);

    }

    @Test
    void getStocksTest(){
        // 1st Test
        //TODO



    }

    @Test
    void getStockTest(){
        // 1st Test
        Stock testStock = new Stock("BBB", "Stock2", 20.0, 1, true);
        assertTrue(folio.getStock("BBB").equals(testStock));


    }

    @Test
    void buyStockTest(){
        // 1st Test
        assertTrue(folio.buyStock("AAA", 20));
        // 2nd Test
        assertFalse(folio.buyStock("FFF", 20));



    }

    @Test
    void sellStockTest() throws NotEnoughSharesException {
        // 1st Test
        assertTrue(folio.sellStock("AAA", 5));
        // 2nd Test
        assertThrows(NotEnoughSharesException.class, () -> {
            folio.sellStock("AAA", 100);
        });



    }

    @Test
    void addStockTest(){
        // 1st Test
        assertTrue(folio.addStock("EEE", "Stock4", 30.6, 5, true));

    }

   

    @Test
    void getNameTest(){
        // 1st Test
        assertEquals(folio.getName(), "Folio 1");
        // 2nd Test
        assertNotEquals(folio.getName(), "Folio 27");


    }
}
