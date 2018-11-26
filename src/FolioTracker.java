import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class FolioTracker implements IFolioTracker {
    private Set<Folio> folios; // The currently opened folios

    FolioTracker() {
        folios = new HashSet<>();
    }

    public boolean createFolio(String name) {
        for (Folio f : folios) {
            if (f.getName().equals(name))
                return false;
        }
        Folio folio = new Folio(name);
        return folios.add(folio);
    }

    public Folio openFolio(String name) {
        try {
            File folioFile = new File(name + "_DATA.txt");
            if (!folioFile.exists()) {
                System.out.println("There is no saved data for folio:\t" + name);
                return null;
            }
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
            return folio;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean saveFolio(String name) {
        try {
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
                return true;
            } else {
                System.out.println("Folio " + name + " does not exist to be saved.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("File not saved for folio:\t" + name);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteFolio(String name) {
        if (!folios.remove(getFolio(name)))
            return false;
        if (new File(name + "_DATA.txt").exists())
            return new File(name + "_DATA.txt").delete();
        return true;
    }

    public Folio getFolio(String name) {
        for (Folio folio : folios) {
            if (folio.getName().equals(name))
                return folio;
        }

        return null;
    }


}
