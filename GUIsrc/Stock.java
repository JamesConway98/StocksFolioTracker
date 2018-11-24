import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Stock // TODO interface
{
    private SimpleStringProperty symbol, name;
    private SimpleIntegerProperty amount;
    private SimpleDoubleProperty value, total;
    
    public Stock(String symbol, String name, double value, int amount)
    {
	this.symbol = new SimpleStringProperty(symbol);
	this.name = new SimpleStringProperty(name);
	this.value = new SimpleDoubleProperty(value);
	this.amount = new SimpleIntegerProperty(amount);
	this.total = new SimpleDoubleProperty(this.value.get() * this.amount.get());
    }

    public String getSymbol()
    {
	return symbol.get();
    }

    public String getName()
    {
        return name.get();
    }

    public int getAmount()
    {
	return amount.get();
    }

    public double getValue()
    {
	return value.get();
    }

    public double getTotal()
    {
	this.total.set(this.value.get() * this.amount.get());
        return total.get();
    }
    
    
}
