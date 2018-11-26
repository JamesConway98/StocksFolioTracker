import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Folio implements IFolio {
    //private static Set<Stock> stocks;
    private RefreshStocks stocks;
    private String name;

    Folio(String name) {
        this.name = name;
        stocks = new RefreshStocks();
        stocks.start();
    }

    /**
     * Effects: For all Stock in this.stocks, returns the sum of s.getValue() where s is a Stock in this.stocks
     */
    public double totalHolding() {
        double total = 0;
        for (Stock s : stocks.getStocks()) {
            total += s.getValue();
        }
        return total;
    }

    /**
     * Effects: Returns this.stocks
     */
    public Set<Stock> getStocks() {
        return stocks.getStocks();
    }

    /**
     * Effects: Returns a Stock with the specified tickerSymbol if one exists in this, else returns null
     */
    public Stock getStock(String tickerSymbol) {
        for (Stock s : stocks.getStocks()) {
            if (s.getTickerSymbol().equals(tickerSymbol)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Requires: tickerSymbol != null
     * Modifies: this
     * Effects: Increases numShares of Stock in this.stocks with the specified tickerSymbol by amount and returns true if this changed as a result, else returns false.
     * If a Stock does not exist in this with the specified tickerSymbol, returns false.
     */
    public boolean buyStock(String tickerSymbol, int amount) {
        Stock s;
        if ((s = getStock(tickerSymbol)) != null) {
            return s.setNumOfShares(s.getNumOfShares() + amount);
        }
        return false;
    }

    /**
     * Requires: tickerSymbol != null
     * Modifies: this
     * Effects: Decreases numShares of Stock in this.stocks with the specified tickerSymbol by amount and returns true if this changed as a result, else returns false.
     * If a Stock does not exist in this with the specified tickerSymbol, returns false.
     * If the amount to decrease numShares in Stock is greater than numShares, throws NotEnoughSharesException
     */
    public boolean sellStock(String tickerSymbol, int amount) throws NotEnoughSharesException {
        Stock s;
        if ((s = getStock(tickerSymbol)) != null) {
            if (s.getNumOfShares() < amount)
                throw new NotEnoughSharesException(amount + " > " + s.getNumOfShares());
            else
                return s.setNumOfShares(s.getNumOfShares() - amount);
        }
        return false;
    }

    /**
     * Requires: this.name != null, tickerSymbol != null, pricePerShare > 0, numShares >= 0
     * Modifies: this
     * Effects: Creates a new instance of Stock, passing the parameters to the constructor of Stock and adding it to this.stocks, returns true if this changed as a result, else returns false.
     */
    public boolean addStock(String symbol, String name, double value, int amount, boolean change) {
        Stock s = new Stock(symbol, name, value, amount, change);
        return stocks.getStocks().add(s);
    }

    /**
     * Effects: Returns this.name
     */
    public String getName() {
        return name;
    }

    public RefreshStocks getTimer(){
        return stocks;
    }
    
    public void setFolioName(String name){
    	this.name = name;
    }

    class NotEnoughSharesException extends Exception {

        NotEnoughSharesException(String s) {
            super(s);
        }
    }
}
