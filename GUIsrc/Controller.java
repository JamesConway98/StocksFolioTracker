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
	gui.showFileWindow(""); // TODO set the file path to the currently open folio
	saving  = true;
    }

    /**
     * executed when the Sell button in sellStockWindow is clicked
     */
    public void buttonSellNowClick(MouseEvent e)
    {
        Folio folio = folioTracker.getFolio(gui.getOpenFolioName());

        if(folio != null)
            folio.sellStock(" ", 0);

    }
    
    /**
     * executed when the Buy button in buyStockWindow is clicked
     */
    public void buttonBuyNowClick(MouseEvent e)
    {
        Folio folio = folioTracker.getFolio(gui.getOpenFolioName());

        if(folio != null)
            folio.buyStock(" ", 0);

    }
    
    /**
     * executed when the Create button in createFolioWindow is clicked
     */
    public void buttonCreateFolioNowClick(MouseEvent e)
    {
	
    }
    

    /**
     * executed when the Apply button in editFolioWindow is clicked
     */
    public void buttonEditFolioNowClick(MouseEvent e)
    {
	
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
	    
	}
    }
}
