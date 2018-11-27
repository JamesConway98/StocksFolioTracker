import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class FolioTracker implements IFolioTracker {
    private Set<Folio> folios; // The currently opened folios

    FolioTracker() {
        folios = new HashSet<>(); 
    }

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: Checks if a Folio with the specified name exists in this, returns false if it does. If not, adds a Folio with the specified name to this and returns true if this changed as a result.
     */
    public boolean createFolio(String name) {
        // Check if a Folio with the specified name is already in this, and return false if it is.
        for (Folio f : folios) {
            if (f.getName().equals(name))
                return false;
        }
        // Add a new Folio with the specified name to this and return true if this changed as a result.
        Folio folio = new Folio(name);
        return folios.add(folio); 
    }

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: If a File with a name prefixed by the specified name does not exist in the filesystem, returns null, else it parses the File according to an expected format and creates a Folio from the read data, returns the Folio.
     */
    public Folio openFolio(String name) {
        try {
            // Checks if a file for the specified Folio exists in the filesystem and returns null if it does not.
            File folioFile = new File(name + "_DATA.txt");
            if (!folioFile.exists()) {
                System.out.println("There is no saved data for folio:\t" + name);
                return null;
            }
            // Reads the file and creates a Folio object based the data in it according to an expected standard format.
            BufferedReader reader = new BufferedReader(new FileReader(folioFile));
            Folio folio = new Folio(name);
            String str = reader.readLine();
            StringTokenizer tok;
            while ((str = reader.readLine()) != null) {
                tok = new StringTokenizer(str);
                String stockName = tok.nextToken(";");
                String stockTicker = tok.nextToken(";");
                Double stockPPS = Double.parseDouble(tok.nextToken(";"));
                int stockNumShares = Integer.parseInt(tok.nextToken(";"));
                boolean stockChange = Boolean.parseBoolean(tok.nextToken(";"));
                folio.addStock(stockTicker, stockName, stockPPS, stockNumShares, stockChange);
            }
            reader.close();
            if (folios.add(folio))
                return folio; // Returns the Folio
            else
                return null;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            // Return null if there was error reading from the file
            return null;
        }
    }

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: Saves a Folio's data to the filesystem if a Folio with the specified name exists in this and returns true if this changed as a result, else returns false.
     */
    public boolean saveFolio(String name) {
        try {
            // Saves the Folio with the specified name's data to the filesystem according to a standard format so it can be read later.
            Folio folio = getFolio(name);
            if (folio != null) {
                Set<Stock> stocks = folio.getStocks();
                File folioFile = new File(name + "_DATA.txt");
                if (folioFile.createNewFile())
                    System.out.println("Folio file created for:\t" + name);
                BufferedWriter writer = new BufferedWriter(new FileWriter(folioFile));
                writer.write(name + '\n');
                for (Stock s : stocks) {
                    writer.write(s.getName() + ";" + s.getTickerSymbol() + ";" + s.getPricePerShare() + ";" + s.getNumOfShares() + ";" + s.getChange() + ";\n");
                }
                System.out.println("File saved for folio:\t" + name);
                writer.close();
                // Return true if the Folio data was written to the file and this changed as a result.
                return true;
            } else {
                // Return false if a Folio with the specified name does not exist.
                System.out.println("Folio " + name + " does not exist to be saved.");
                return false;
            }
        } catch (IOException e) {
            // Returns false if there was an error reading from the file
            System.out.println("File not saved for folio:\t" + name);
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: Removes a Folio with the specified name from this if a Folio with the specified name exists in this, and removes the corresponding file in the filesystem if it exists and returns true if this changed as result, else returns false.
     */
    public boolean deleteFolio(String name) {
        // Removes the Folio with the specified name from this if it exists in this.
        // Returns false if the Folio with the specified name does not exist in this.
        if (!folios.remove(getFolio(name)))
            return false;
        // Returns true if the file for the corresponding Folio exists and is deleted, else returns false due to an IO error.
        if (new File(name + "_DATA.txt").exists())
            return new File(name + "_DATA.txt").delete();
        // Returns true if the Folio with the specified name wa removed from this previously and it does not have a corresponding file in the filesystem to delete.
        return true;
    }

    /**
     * Requires: name != null
     * Effects: Returns a folio with the specified name if it exists in this, else returns null.
     */
    public Folio getFolio(String name) {
        // Iterate through the Folios in this and return the Folio with the specified name
        for (Folio folio : folios) {
        	System.out.println(folio.getName());
            if (folio.getName().equals(name))
                return folio;
        }
        // Return null no Folio exists in this with the specified name.
        return null;
    }

    /**
     * Effects: Returns this.folios
     */
    public Set<Folio> getFolios(){
    	return folios;
    }

    /**
     * Requires: name != null
     * Modifies: this
     * Effects: Removes a Folio with the specified name from this if a Folio with the specified name exists in this, and returns true if this changed as result, else returns false.
     */
    public boolean closeFolio(String name){
        // Removes the Folio with the specified name from this if it exists in this.
        // Returns false if the Folio with the specified name does not exist in this.
        return folios.remove(getFolio(name));
    }
}
