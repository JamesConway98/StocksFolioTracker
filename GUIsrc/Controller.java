import javafx.scene.input.MouseEvent;

public class Controller
{
    GUI gui; // TODO make this an interface as well
    
    public Controller(GUI gui)
    {
	this.gui = gui;
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
	System.out.println("delete folio");
    }
    
    public void buttonOpenFolioClick(MouseEvent e)
    {
	System.out.println("open folio");
    }
    
    public void buttonSaveFolioClick(MouseEvent e)
    {
	System.out.println("save folio");
    }
    
    public void buttonSellNowClick(MouseEvent e)
    {
	System.out.println("sell stock");
    }
    
    public void buttonBuyNowClick(MouseEvent e)
    {
	System.out.println("buy stock");
    }
}
