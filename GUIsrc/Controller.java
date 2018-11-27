import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.input.MouseEvent;

public class Controller implements IController
{
    IGUI gui;
    IFolioTracker folioTracker;
    private boolean saving = false;

    public Controller(IGUI gui)
    {
	this.gui = gui;
	folioTracker = new FolioTracker();
    }

    /**
     * executed when the Buy button in the main window is clicked
     */
    public void buttonBuyStockClick(MouseEvent e)
    {
	gui.showBuyStockWindow("", "", 0); // TODO insert variables to display when window opens
    }

    /**
     * executed when the Sell button in the main window is clicked
     */
    public void buttonSellStockClick(MouseEvent e)
    {
	gui.showSellStockWindow("", "", 0, 0); // TODO insert variables to display when window opens
	System.out.println(gui.getStockIndex());
    }

    /**
     * executed when the Create button in the main window is clicked
     */
    public void buttonCreateFolioClick(MouseEvent e)
    {
	gui.showCreateFolioWindow();
    }

    /**
     * executed when the Edit button in the main window is clicked
     */
    public void buttonEditFolioClick(MouseEvent e)
    {
	gui.showEditFolioWindow(gui.getOpenFolioName());
    }

    /**
     * executed when the Delete button in the main window is clicked
     */
    public void buttonDeleteFolioClick(MouseEvent e)
    {
	folioTracker.deleteFolio(gui.getOpenFolioName());
    }

    /**
     * executed when the Open button in the main window is clicked
     */
    public void buttonOpenFolioClick(MouseEvent e)
    {
	gui.showFileWindow("");
	saving = false;
    }

    /**
     * executed when the Save button in the main window is clicked
     */
    public void buttonSaveFolioClick(MouseEvent e)
    {
	folioTracker.saveFolio(gui.getOpenFolioName());
    }

    /**
     * executed when the Sell button in sellStockWindow is clicked
     */
    public void buttonSellNowClick(MouseEvent e)
    {
        Folio folio = folioTracker.getFolio(gui.getOpenFolioName());

      if(folio != null)
		try {
			folio.sellStock(" ", 0);
		} catch (NotEnoughSharesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        gui.closeSellStockWindow();

    }
    
    /**
     * executed when the Buy button in buyStockWindow is clicked
     */
    public void buttonBuyNowClick(MouseEvent e)
    {
        Folio folio = folioTracker.getFolio(gui.getOpenFolioName());
        
        int amount = gui.getBuyAmount();

        System.out.println(folio);
        
        if(folio != null) {
            
        	if(folio.getStock(gui.getBuySymbol()) == null) {
            	folio.addStock(gui.getBuySymbol(), gui.getBuyName(), -1, gui.getBuyAmount(), true);
            }
        	else {
        		folio.buyStock(gui.getBuySymbol(), gui.getBuyAmount());
        	}
        	
        	List<IStock> stockList = new ArrayList<>();
        	stockList.addAll(folio.getStocks());
        	
        	gui.updateFolio(stockList, gui.getBuyName());
        }
        
        gui.closeBuyStockWindow();

    }
    
    /**
     * executed when the Create button in createFolioWindow is clicked
     */
    public void buttonCreateFolioNowClick(MouseEvent e)
    {
    	
    	List<IStock> stockList = new ArrayList<>();
    	
    	
    	folioTracker.createFolio(gui.getCreateName());
    	gui.closeCreateFolioWindow();
    	Folio folio = folioTracker.getFolio(gui.getCreateName());
    	
    	//turn set of Stock to List of Stock
    	stockList.addAll(folio.getStocks());
    	
    	//create new tab in gui
    	gui.addTab(stockList, gui.getCreateName());
    	
    	folioTracker.saveFolio(gui.getCreateName());
    		
    }
    

    /**
     * executed when the Apply button in editFolioWindow is clicked
     */
    public void buttonEditFolioNowClick(MouseEvent e)
    {
    	Folio folio = folioTracker.getFolio(gui.getOpenFolioName());

        if(folio != null)
            folio.setFolioName(gui.getEditName());
        
        gui.closeEditFolioWindow();
    }

    /**
     * executed when the Submit button in fileWindow is clicked
     */
    public void buttonFileClick(MouseEvent e)
    {
	if(saving) // do stuff for saving the folio
	{
	    folioTracker.saveFolio(gui.getOpenFolioName());
	}
	else // TODO do stuff for opening a folio
	{
		List<IStock> stockList = new ArrayList<>();
		
	    folioTracker.openFolio(gui.getFilePath());
    	Folio folio = folioTracker.getFolio(gui.getFilePath());
    	
    	if(folio != null) {
	    	//turn set of Stock to List of Stock
	    	stockList.addAll(folio.getStocks());	
	    	//create new tab in gui
	    	gui.addTab(stockList, gui.getFilePath());
    	}
	}
	gui.closeFileWindow();
    }

}
