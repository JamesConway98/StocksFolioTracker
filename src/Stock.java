import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Stock implements IStock {
    private SimpleStringProperty tickerSymbol, name;
    private SimpleIntegerProperty numShares;
    private SimpleDoubleProperty pps, holding;
    private SimpleStringProperty changeSymbol;
    private boolean change;

    public Stock(String symbol, String name, double pricePerShare, int amount, boolean change) {
        this.tickerSymbol = new SimpleStringProperty(symbol);
        this.name = new SimpleStringProperty(name);
        this.pps = new SimpleDoubleProperty(pricePerShare);
        this.numShares = new SimpleIntegerProperty(amount);
        this.holding = new SimpleDoubleProperty(this.pps.get() * this.numShares.get());
        this.change = change;
        
        if(change)
        {
            this.changeSymbol = new SimpleStringProperty(Character.toString((char)0x2191));
        }
        else
        {
            this.changeSymbol = new SimpleStringProperty(Character.toString((char)0x2193));
        }
    }

    public String getName(){
        return name.get();
    }
    /**
     * Effects: Returns this.symbol.get()
     */
    @Override
    public String getTickerSymbol() {
        return tickerSymbol.get();
    }

    /**
     * Effects: Returns this.pps.get()
     */
    @Override
    public double getPricePerShare() {
        return pps.get();
    }

    /**
     * Requires: pps > 0
     * Modifies: this
     * Effects: Sets the value of this.pps to pps and returns true if this changed as a result.
     */
    @Override
    public boolean setPricePerShare(double pps) {
        if (pps < this.pps.get())
            setChange(false);
        else
            setChange(true);
        this.pps.set(pps);
        return true;
    }

    /**
     * Effects: Returns this.numShares.get()
     */
    @Override
    public int getNumOfShares() {
        return numShares.get();
    }

    /**
     * Requires: num >= 0
     * Modifies: this
     * Effects: Sets this.numShares to num and returns true if this changed as a result
     */
    @Override
    public boolean setNumOfShares(int num) {
        this.numShares.set(num);
        return true;
    }

    /**
     * Modifies: this
     * Effects: Sets this.holding to the product of this.pps.get() and this.numShares.get() and returns this.holding.get()
     */
    @Override
    public double getValue() {
        this.holding.set(this.pps.get() * this.numShares.get());
        return holding.get();
    }

    /**
     * Effects: Returns this.change.get()
     */
    @Override
    public boolean getChange() {
        return change;
    }

    /**
     * Modifies: this
     * Effects: Sets this.change to change and returns the value of this.change.get()
     */
    @Override
    public boolean setChange(boolean change) {
        return this.change = change;
    }

    @Override
    public boolean equals(Object aStock){
        if( !(aStock instanceof Stock )) {

            return false;
        }
        Stock s = (Stock) aStock;

        return s.getTickerSymbol().equals(tickerSymbol.get())
                && s.getName().equals(name.get())
                && s.getNumOfShares() == numShares.get()
                && s.getPricePerShare() == pps.get()
                && s.getChange() == change;


    }

    /**
     * Effects: Returns this.changeSymbol.get()
     */
    public String getChangeSymbol()
    {
	return changeSymbol.get();
    }
}
