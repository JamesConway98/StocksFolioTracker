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
     * Effects: A Folio with the specified name is returned if relevant saved data for it exists in the filesystem, else returns null.
     */
    Folio openFolio(String name);

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: Saves a Folio's data to the filesystem and returns true if this changed as a result, else returns false.
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
    
    Set<Folio> getFolios();
}
