import java.util.List;
import java.util.Set;

public interface IFolio {

    double totalHolding();

    Set<Stock> getStocks();

    Stock getStock(String tickerSymbol);

    boolean addStock(String name, String ticker, double pricePerShare, int numShares, boolean change);

    boolean updateStock(List<String> t);

    boolean buyStock(String tickerSymbol, int amount);

    boolean sellStock(String tickerSymbol, int amount);

    String getName();
}
