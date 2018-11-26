public interface IStock {

    public String getTickerSymbol();

    public double getPricePerShare();

    public boolean setPricePerShare(double pps);

    public int getNumOfShares();

    public boolean setNumOfShares(int num);

    public double getValue();

    public boolean getChange();

    public void setChange(boolean change);


}
