import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Stock implements IStock {
    private SimpleStringProperty symbol, name;
    private SimpleIntegerProperty numShares;
    private SimpleDoubleProperty pps, holding;
    private boolean change;

    public Stock(String symbol, String name, double value, int amount, boolean change) {
        this.symbol = new SimpleStringProperty(symbol);
        this.name = new SimpleStringProperty(name);
        this.pps = new SimpleDoubleProperty(value);
        this.numShares = new SimpleIntegerProperty(amount);
        this.holding = new SimpleDoubleProperty(this.pps.get() * this.numShares.get());
        this.change = change;
    }

    public String getSymbol() {
        return symbol.get();
    }

    public String getName() {
        return name.get();
    }

    public int getAmount() {
        return numShares.get();
    }

    @Override
    public String getTickerSymbol() {
        return symbol.get();
    }

    @Override
    public double getPricePerShare() {
        return pps.get();
    }

    @Override
    public boolean setPricePerShare(double pps) {
        if (this.pps.get() < pps)
            setChange(false);
        else
            setChange(true);
        this.pps.set(pps);
        return true;
    }

    @Override
    public int getNumOfShares() {
        return numShares.get();
    }

    @Override
    public boolean setNumOfShares(int num) {
        this.numShares.set(num);
        return true;
    }

    public double getValue() {
        return holding.get();
    }

    @Override
    public boolean getChange() {
        return change;
    }

    public double getTotal() {
        this.holding.set(this.pps.get() * this.numShares.get());
        return holding.get();
    }

    public void setChange(boolean change) {
        this.change = change;
    }


}
