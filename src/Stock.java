import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Stock implements IStock {
    private SimpleStringProperty symbol, name;
    private SimpleIntegerProperty numShares;
    private SimpleDoubleProperty pps, holding;
    private boolean change;

    public Stock(String symbol, String name, double pricePerShare, int amount, boolean change) {
        this.symbol = new SimpleStringProperty(symbol);
        this.name = new SimpleStringProperty(name);
        this.pps = new SimpleDoubleProperty(pricePerShare);
        this.numShares = new SimpleIntegerProperty(amount);
        this.holding = new SimpleDoubleProperty(this.pps.get() * this.numShares.get());
        this.change = change;
    }

    public String getName(){
        return name.get();
    }
    /**
     * Effects: Returns this.symbol.get()
     */
    @Override
    public String getTickerSymbol() {
        return symbol.get();
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
}
