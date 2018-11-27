import java.util.Set;

public interface IFolioTracker {

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: Adds a Folio with the specified name to this and returns true if this changed as a result, else returns false.
     */
    boolean createFolio(String name);

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: Creates a new Folio and constructs it with the data for Stocks detailed in a relevant test file, if one exists. Adds the Folio to this and returns the Folio, else returns null.
     */
    Folio openFolio(String name);

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: If a Folio with the specified name exists in this, returns true if a text file is created and the data from the Folio from the specified name is written to it, else returns false.
     */
    boolean saveFolio(String name);

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: Removes a Folio with the specified name from this if a Folio with the specified name exists in this, and removes the corresponding file in the filesystem if it exists and returns true if this changed as result, else returns false.
     */
    boolean deleteFolio(String name);

    /**
     * Requires: name != null
     * Effects: Returns a folio with the specified name if it exists in this, else returns null.
     */
    Folio getFolio(String name);

    /**
     * Effects: Returns a Set of the Folios that exist in this
     */
    Set<Folio> getFolios();

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: Removes a Folio with the specified name from this if a Folio with the specified name exists in this, and returns true if this changed as result, else returns false.
     */
    boolean closeFolio(String name);
}
