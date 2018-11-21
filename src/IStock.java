public interface IStock {

	public String getTickerSymbol();
	
	public double getPricePerShare();
	
	public boolean setPricePerShare(double pps);
	
	public int getNumOfShares();
	
	public boolean setNumOfShares();
	
	public double getValue();
	
	public boolean getChange();
	
	
	
}
