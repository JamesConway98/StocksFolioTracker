import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FolioTrackerTest {

    FolioTracker tracker;

    /**
     * Create a fresh instance of FolioTracker before each test so each test may construct the FolioTracker as needed
     */
    @BeforeEach
    void setUp() {
        tracker = new FolioTracker();
    }

    /**
     * 3 Tests for createFolio(String name):
     * <p>
     * 1st Test: Assert that a call to createFolio(String name) with a name that has not been used for a folio previously, returns true when a new Folio is created with that name.
     * 2nd Test: Assert that the new Folio object from 1st test has the correct name.
     * 3rd Test: Assert that a call to createFolio(String name) with a name that has been used for a folio previously, returns false.
     */
    @Test
    void createFolioTest() {
        // 1st Test
        assertTrue(tracker.createFolio("TEST"));
        // 2nd Test
        assertEquals(tracker.getFolio("TEST").getName(), "TEST");
        // 3rd Test
        assertFalse(tracker.createFolio("TEST"));
    }

    /**
     * 3 Tests for openFolio(String name):
     * <p>
     * 1st Test: A new Folio object is created and added to the FolioTracker, A Stock object is added to it and asserted to return true when added. The Folio is saved using saveFolio(String name).
     * An instance of Folio is set to the returned object of openFolio(String name). The File where the Folio is saved is asserted as not null to test if it was properly saved and the contents of this Folio are asserted as being equal to the test data used to create it.
     * 2nd Test: A call to openFolio(String name) is made on a file that has restricted access, this asserts that the return to the call is null as an IOException is thrown.
     * 3rd Test: A call to openFolio(String name) is made with a file name for a file that does not exist, the return is asserted to be null.
     */
    @Test
    void openFolioTest() {
        // 1st Test
        if (tracker.createFolio("TEST")) {
            Folio fSAVE = tracker.getFolio("TEST");
            assertTrue(fSAVE.addStock("test", "TestStock", 1.00, 66, true));
            if (tracker.saveFolio("TEST")) {
                Folio fOPEN = tracker.openFolio("TEST");
                assertNotNull(fOPEN);
                System.out.println(fOPEN.getName());
                for (Stock s : fOPEN.getStocks()) {
                    System.out.println(s.getName() + "\t\t" + s.getTickerSymbol() + "\t\t" + s.getPricePerShare() + "\t\t" + s.getNumOfShares() + "\t\t" + s.getValue() + "\t\t" + s.getChange() + "\n");
                    assertEquals(s.getName(), "TestStock");
                    assertEquals(s.getSymbol(), "test");
                    assertEquals(s.getPricePerShare(), 1.00);
                    assertEquals(s.getNumOfShares(), 66);
                    assertTrue(s.getChange());
                }
                tracker.deleteFolio("TEST");
            }
            // 2nd Test
            // IF THIS FAILS YOU NEED TO SET THE PERMISSIONS OF SECURE_FILE_DATA.txt TO NO READ/WRITE/EXEC FOR ANY USER
            assertNull(tracker.openFolio("SECURE_FILE"));
            // 3rd Test
            assertNull(tracker.openFolio("NULL_FILE"));
        }
    }

    /**
     * 3 Tests for saveFolio(String name):
     * <p>
     * 1st Test: A new Folio object is created and added to the FolioTracker, A Stock object is added to it and asserted to return true when added.
     * The return of a call to saveFolio(String name) is asserted to be true as it should be safely saved.
     * 2nd Test: A call to saveFolio(String name) is made for a String that does not match the name of an existing Folio, the return is asserted to be false.
     * 3rd Test: A call to saveFolio(String name) is made with a file name for a file that has restricted access, this asserts that the return to the call is false as an IOException is thrown.
     */
    @Test
    void saveFolioTest() {
        // 1st Test
        if (tracker.createFolio("TEST")) {
            Folio fSAVE = tracker.getFolio("TEST");
            assertTrue(fSAVE.addStock("test", "TestStock", 1.00, 66, true));
            assertTrue(tracker.saveFolio("TEST"));
            // 2nd Test
            assertFalse(tracker.saveFolio("FALSE_TEST"));
            // 3rd Test
            if (tracker.createFolio("SECURE_FILE"))
                assertFalse(tracker.saveFolio("SECURE_FILE"));
        }
    }

    /**
     * 3 Tests for deleteFolio(String name):
     * <p>
     * 1st Test: A Folio object is added to FolioTracker with a call to createFolio(String name) and a file created and saved with a call to saveFolio(String name).
     * The return value of a call to deleteFolio(String name) is asserted to be true as the new Folio should successfully be removed from the Folio
     * The existence of the file is asserted to be false to check that its file has been deleted from the filesystem.
     * 2nd Test: A call to deleteFolio(String name) is asserted to be false for a name that does not correspond to a Folio in the tracker.
     * 3rd Test: A Folio object is added to FolioTracker with a call to createFolio(String name).
     * The return value of a call to deleteFolio(String name) is asserted to be true as the new Folio should successfully be removed from the Folio, even though it was never saved and thus a file for it never existed so did not need to be deleted.
     */
    @Test
    void deleteFolioTest() {
        // Test 1
        if (tracker.createFolio("TEST")) {
            tracker.saveFolio("TEST");
            assertTrue(tracker.deleteFolio("TEST"));
            assertFalse(new File("TEST_DATA.txt").exists());
        }
        // Test 2
        assertFalse(tracker.deleteFolio("FALSE_TEST"));
        // Test 3
        if (tracker.createFolio("NOFILE_TEST")) {
            assertTrue(tracker.deleteFolio("NOFILE_TEST"));
        }
    }

    /**
     * 2 Tests for getFolio(String name)
     * <p>
     * 1st Test: A Folio is created with a call to createFolio(String name).
     * The String name of the returned Folio of a call to getFolio(String name) is asserted to be equal to the given name when the Folio was created. This will be true if getFolio(String name) returned the correct Folio.
     * 2nd Test: The return of getFolio(String name) is asserted to be null for a name given that does not correspond to a Folio in the FolioTracker.
     */
    @Test
    void getFolioTest() {
        // Test 1
        if (tracker.createFolio("TEST")) {
            assertEquals(tracker.getFolio("TEST").getName(), "TEST");
        }
        // Test 2
        assertNull(tracker.getFolio("NULL_TEST"));
    }
}