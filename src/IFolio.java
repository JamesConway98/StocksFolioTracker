import java.util.Set;
import java.util.List;

public interface IFolio {

	public double totalHolding();
	
	public Set<Stock> getStocks();
	
	public Stock getStock(String tickerSymbol);
	
	public boolean addStock(String name, String ticker, double pricePerShare, int numShares);
	
	public boolean updateStock(List<String> t);
}
