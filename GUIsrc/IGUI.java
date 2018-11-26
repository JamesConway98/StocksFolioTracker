import java.util.List;

public interface IGUI
{
    // methods to show other windows
    
    /**
     * opens the createFolioWindow
     */
    public void showCreateFolioWindow();

    /**
     * opens the buyStockWindow and sets the contents of the TextFields to the specified parameters
     * @param symbol
     * @param name
     * @param amount
     */
    public void showBuyStockWindow(String symbol, String name, int amount);

    /**
     * opens the sellStockWindow and sets the contents of the TextFields to the specified parameters
     * @param symbol
     * @param name
     * @param value
     * @param amount
     */
    public void showSellStockWindow(String symbol, String name, double value, int amount);

    /**
     * opens the editFolioWindow and sets the contents of the TextField to the specified parameters
     * @param name
     */
    public void showEditFolioWindow(String name);
    
    /**
     * opens the fileWindow and sets the contents of the TextField to the specified parameters
     * @param path
     */
    public void showFileWindow(String path);
    
    
    //methods to close other windows
    
    public void closeCreateFolioWindow();

    /**
     * closes the buyStockWindow
     */
    public void closeBuyStockWindow();

    /**
     * closes the sellStockWindow 
     */
    public void closeSellStockWindow();

    /**
     * closes the editFolioWindow 
     */
    public void closeEditFolioWindow();
    
    /**
     * closes the fileWindow 
     */
    public void closeFileWindow();
    
    
    // methods to modify/access data in main window
    
    /**
     * adds a new tab (i.e. folio) to the tabPane in the main window
     * @param content list of stock contained in the respective folio
     * @param name name of tab (i.e. name of the folio)
     */
    public void addTab(List<Stock> content, String name);
    
    /**
     * lets gui know that something has changed
     * 
     */
    public void update();
    
    /**
     * 
     * @return the name of the currently selected folio tab
     */
    public String getOpenFolioName();
    
    /**
     * 
     * @return the index of the currently selected stock, -1 if no stock is selected
     */
    public int getStockIndex();
    
    // methods to get data from fileWindow
    
    /**
     * 
     * @return the file path
     */
    public String getFilePath();
    
    // methods to get data from buyStockWindow
    
    /**
     * 
     * @return the name of the stock to buy
     */
    public String getBuyName();
    
    /**
     * 
     * @return the ticker symbol of the stock to buy
     */
    public String getBuySymbol();
    
    /**
     * 
     * @return the amount of stock to buy
     */
    public int getBuyAmount();
    
    // methods to get data from sellStockWindow
    
    /**
     * 
     * @return the name of the stock to sell
     */
    public String getSellName();
    
    /**
     * 
     * @return the symbol of the stock to sell
     */
    public String getSellSymbol();
    
    /**
     * 
     * @return the amount of stock to sell
     */
    public int getSellAmount();
    
    /**
     * 
     * @return the price at which the stock is to be sold
     */
    public double getSellValue();
    
    // methods to get data from editFolioWindow
    
    /**
     * 
     * @return the new name of the folio
     */
    public String getEditName();
    
    // methods to get data from createFolioWindow
    
    /**
     * 
     * @return the name of the folio to create
     */
    public String getCreateName();
}
