import javafx.scene.input.MouseEvent;

public class Controller implements IController
{
    GUI gui; // TODO make this an interface as well
    IFolioTracker folioTracker;

    public Controller(GUI gui)
    {
	this.gui = gui;
	folioTracker = new FolioTracker();
    }

    public void buttonBuyStockClick(MouseEvent e)
    {
	gui.showBuyStockWindow();
    }

    public void buttonSellStockClick(MouseEvent e)
    {
	gui.showSellStockWindow();
    }

    public void buttonCreateFolioClick(MouseEvent e)
    {
	gui.showCreateFolioWindow();
    }

    public void buttonEditFolioClick(MouseEvent e)
    {
	gui.showEditFolioWindow();
    }

    public void buttonDeleteFolioClick(MouseEvent e)
    {
	folioTracker.deleteFolio("");
    }

    public void buttonOpenFolioClick(MouseEvent e)
    {
	folioTracker.openFolio("");
    }

    public void buttonSaveFolioClick(MouseEvent e)
    {
	folioTracker.saveFolio("");
    }

    public void buttonSellNowClick(MouseEvent e)
    {
        Folio folio = folioTracker.getFolio(" ");

      //  if(folio != null)
          //  folio.sellStock(" ", 0);

    }
    
    public void buttonBuyNowClick(MouseEvent e)
    {
        Folio folio = folioTracker.getFolio(" ");

        if(folio != null)
            folio.buyStock(" ", 0);

    }
}
