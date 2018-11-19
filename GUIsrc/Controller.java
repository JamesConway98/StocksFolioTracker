import javafx.scene.input.MouseEvent;

public class Controller
{
    GUI gui;
    
    public Controller(GUI gui)
    {
	this.gui = gui;
    }

    public void buttonCreateFolioClick(MouseEvent e)
    {
	CreateFolioWindow window = new CreateFolioWindow(this);
	window.show();
    }
    
    public void buttonCreateStockClick(MouseEvent e)
    {
	CreateStockWindow window = new CreateStockWindow(this);
	window.show();
    }
    
    public void buttonEditStockClick(MouseEvent e)
    {
	EditStockWindow window = new EditStockWindow(this);
	window.show();
    }
    
    public void buttonEditFolioClick(MouseEvent e)
    {
	EditFolioWindow window = new EditFolioWindow(this);
	window.show();
    }
    
    public void buttonDeleteFolioClick(MouseEvent e)
    {
	System.out.println("delete folio");
    }
}
