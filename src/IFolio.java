import java.util.Set;

public interface IFolio {

	public Double totalHolding();
	
	public Set<Stock> getStocks();
	
	public Stock getStock(String tickerSymbol);
	
	public Boolean addStock(String name, String ticker, double pricePerShare, int numShares);
	
	public Boolean updateStock();
}
