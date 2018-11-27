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
            total += s.getHolding();
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
            int oldNumShares = getStock(tickerSymbol).getNumShares();
            Thread updater = new Thread(){
                @Override
                public void run(){
                    try {
                        getTimer().join();
                        s.setNumShares(s.getNumShares() + amount);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            updater.run();
            assert s.getHolding() >= 0 : "Value must be equivalent to 0 or greater.";
            return(getStock(tickerSymbol).getNumShares() - oldNumShares == amount);
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
            if (s.getNumShares() < amount) {
                throw new NotEnoughSharesException(amount + " > " + s.getNumShares());
            } else {
                int oldNumShares = getStock(tickerSymbol).getNumShares();
                Thread updater = new Thread(){
                    @Override
                    public void run(){
                        try {
                            getTimer().join();
                            s.setNumShares(s.getNumShares() - amount);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                updater.run();
                if (s.getNumShares() == 0) {
                    stocks.getStocks().remove(s);
                    assert !stocks.getStocks().contains(s) : "The stock should no longer be contained after selling stocks";
                }
                return(oldNumShares - getStock(tickerSymbol).getNumShares() == amount);
            }
        } return false;
    }

    /**
     * Requires: this.name != null, tickerSymbol != null, pricePerShare > 0, numShares >= 0
     * Modifies: this
     * Effects: Creates a new instance of Stock, passing the parameters to the constructor of Stock and adding it to this.stocks, returns true if this changed as a result, else returns false.
     */
    public boolean addStock(String symbol, String name, double value, int amount, boolean change) {
        //value = -1.0;
        Stock s = new Stock(symbol, name, value, amount, change);
        boolean result = stocks.getStocks().add(s);
        assert checkStocks(stocks.getStocks()) : "there should be only only one stock per Symbol";
        return result;
    }

    /*used for testing assertion in addStock()
     *
     * Requires: set of stocks
     * Effects: Returns true if the number of stocks per ticker symbol is <= 1
     */
    public boolean checkStocks(Set<Stock> list) {
        Set<Stock> currentStocks = list;
        int counter = 0;
        for (Stock s : currentStocks) {
            for (Stock x : currentStocks) {
                if (s.getTickerSymbol().equals(x.getTickerSymbol())) {
                    counter = +1;
                }
            }
        }
        return (counter <= 1);
    }

    /**
     * Effects: Returns this.name
     */
    public String getName() {
        return name;
    }

    public RefreshStocks getTimer() {
        return stocks;
    }

    public void setFolioName(String name) {
        this.name = name;
    }
}
