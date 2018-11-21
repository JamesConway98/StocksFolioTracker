import java.util.HashSet;
import java.util.Set;

public class Folio implements IFolio {
	private Set<Stock> stocks;
	private String name;
	private StrathQuoteServer server;
	private double totalHolding;
	
	Folio(String name){
		this.name = name;
		stocks = new HashSet<Stock>();
	}
	
	private double calcTotalHolding() {
		double total = 0;
			for(Stock x: stocks) {
				total = x.getValue();
			}return total;
	}
	
	public double totalHolding() {
		return calcTotalHolding();
	}

	
	public Set<Stock> getStocks() {
		return stocks;
	}

	
	public Stock getStock(String tickerSymbol) {
		for(Stock s: stocks) {
			if(s.getSymbol().equals(tickerSymbol)) {return s;}
		}return null;
	}

	
	public boolean addStock(String name, String ticker, double pricePerShare, int numShares) {
		Stock x = new Stock(name, ticker, pricePerShare, numShares);
		return stocks.add(x);
	}

	
	public boolean updateStock() {
		// TODO Auto-generated method stub
		return null;
	}


}
