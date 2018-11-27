import java.util.List;
import java.util.Set;

public interface IFolio {

    /**
     * Effects: Returns the sum of s.getValue() where s is a Stock in this.stocks, for all Stock in this.stocks
     */
    double totalHolding();

    /**
     * Effects: Returns this.stocks
     */
    Set<Stock> getStocks();

    /**
     * Requires: tickerSymbol != null
     * Effects: Returns a Stock with the specified tickerSymbol if one exists in this, else returns null
     */
    Stock getStock(String tickerSymbol);

    /**
     * Requires: this.name != null, tickerSymbol != null, pricePerShare > 0, numShares >= 0
     * Modifies: this
     * Effects: Creates a new instance of Stock, passing the parameters to the constructor of Stock and adding it to this.stocks, returns true if this changed as a result, else returns false.
     */
    boolean addStock(String name, String ticker, double pricePerShare, int numShares, boolean change);

  //  boolean updateStock();

    /**
     * Requires: tickerSymbol != null
     * Modifies: this
     * Effects: Increases numShares of Stock in this.stocks with the specified tickerSymbol by amount and returns true if this changed as a result, else returns false.
     * If a Stock does not exist in this with the specified tickerSymbol, returns false.
     */
    boolean buyStock(String tickerSymbol, int amount);

    /**
     * Requires: tickerSymbol != null
     * Modifies: this
     * Effects: Decreases numShares of Stock in this.stocks with the specified tickerSymbol by amount and returns true if this changed as a result, else returns false.
     * If a Stock does not exist in this with the specified tickerSymbol, returns false.
     */
    boolean sellStock(String tickerSymbol, int amount) throws NotEnoughSharesException;

    /**
     * Effects: Returns this.name
     */
    String getName();
}
