import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Folio implements IFolio {
    private static Set<Stock> stocks;
    private String name;

    Folio(String name) {
        this.name = name;
        stocks = new HashSet<>();
    }

    public double totalHolding() {
        double total = 0;
        for (Stock s : stocks) {
            total += s.getValue();
        }
        return total;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public Stock getStock(String tickerSymbol) {
        for (Stock s : stocks) {
            if (s.getTickerSymbol().equals(tickerSymbol)) {
                return s;
            }
        }
        return null;
    }

    public boolean buyStock(String tickerSymbol, int amount) {
        Stock s;
        if ((s = getStock(tickerSymbol)) != null) {
            return s.setNumOfShares(s.getNumOfShares() + amount);
        }
        return false;
    }

    public boolean sellStock(String tickerSymbol, int amount) {
        Stock s;
        if ((s = getStock(tickerSymbol)) != null) {
            return s.setNumOfShares(s.getNumOfShares() - amount);
        }
        return false;
    }

    public boolean addStock(String symbol, String name, double value, int amount, boolean change) {
        Stock s = new Stock(symbol, name, value, amount, change);
        return stocks.add(s);
    }

    public boolean updateStock(List<String> tickers) {
        new refreshData(tickers);
        return true;
    }

    private static List<String> getListTicker() {
        List<String> tickerSymbols = new ArrayList<>();
        for (Stock s : stocks) {
            tickerSymbols.add(s.getTickerSymbol());
            System.out.println("stock here: " + s.getTickerSymbol());
        }
        return tickerSymbols;
    }

    public String getName() {
        return name;
    }

}
