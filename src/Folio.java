import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Folio implements IFolio {
	private static Set<Stock> stocks;
	private static List<String> tickers;
	private String name;
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

	public boolean buyStock(String tickerSymbol, int amount) {
		return false; //TODO
	}

	public boolean sellStock(String tickerSymbol, int amount) {
		return false; //TODO
	}

	public boolean addStock(String symbol, String name, double value, int amount) {
		Stock x = new Stock(symbol, name, value, amount);
		return stocks.add(x);
	}
	
	public boolean updateStock(List<String> tickers) {
		new refreshData(tickers);
		return true;
	}
	
	private static List<String> getListTicker() {
		List<String> tickerSymbols = new ArrayList<String>();
		for(Stock s: stocks) {
			tickerSymbols.add(s.getSymbol());
			System.out.println("stock here: "  + s.getSymbol());
		}return tickerSymbols;
	}

	public String getName(){
		return name;
	}

}
