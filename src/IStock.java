public interface IStock {

    /**
     * Effects: Returns this.tickerSymbol
     */
    public String getTickerSymbol();

    /**
     * Effects: Returns the value of this.pps
     */
    public double getPricePerShare();

    /**
     * Requires: pps > 0
     * Modifies: this
     * Effects: Sets the value of this.pps to pps and returns true if this changed as a result.
     */
    public boolean setPricePerShare(double pps);

    /**
     * Effects: Returns the value of this.numShares
     */
    public int getNumOfShares();

    /**
     * Requires: num >= 0
     * Modifies: this
     * Effects: Sets this.numShares to num and returns true if this changed as a result
     */
    public boolean setNumOfShares(int num);

    /**
     * Modifies: this
     * Effects: Sets this.holding to the product of this.pps and this.numShares and returns this.holding
     */
    public double getValue();

    /**
     * Effects: Returns the value of this.change
     */
    public boolean getChange();

    /**
     * Modifies: this
     * Effects: Sets this.change to change and returns the value of this.change
     */
    public boolean setChange(boolean change);

    public String getChangeSymbol();

}
