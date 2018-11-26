import java.util.ArrayList;
import java.util.List;

import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

public class GUI extends Application implements IGUI
{
    private IController controller;
    private GridPane grid;
    private Scene scene;
    
    private Button buttonCreateFolio;    
    private Button buttonDeleteFolio;
    private Button buttonSaveFolio;
    private Button buttonBuyStock;
    private Button buttonSellStock;
    private Button buttonOpenFolio;
    private Button buttonEditFolio;
    private Text folioText, stockText;
    private TabPane tabPane;
    private List<Tab> tabs; // used to store tabs so they're accessible later
    
    private BuyStockWindow buyStockWindow;
    private SellStockWindow sellStockWindow;
    private CreateFolioWindow createFolioWindow;
    private EditFolioWindow editFolioWindow;
    private FileWindow fileWindow;

    public void start(Stage primaryStage) throws Exception
    {
	controller = new Controller(this);
	
	buyStockWindow = new BuyStockWindow(controller);
	sellStockWindow = new SellStockWindow(controller);
	createFolioWindow = new CreateFolioWindow(controller);
	editFolioWindow = new EditFolioWindow(controller);
	fileWindow = new FileWindow(controller);
	
	grid = new GridPane();
	grid.setVgap(10);
	
	ColumnConstraints c1 = new ColumnConstraints();
	c1.setPercentWidth(15);
	ColumnConstraints c2 = new ColumnConstraints();
	c2.setPercentWidth(70);
	ColumnConstraints c3 = new ColumnConstraints();
	c3.setPercentWidth(15);
	grid.getColumnConstraints().addAll(c1, c2, c3);
	c1.setHalignment(HPos.CENTER);
	c2.setHalignment(HPos.CENTER);
	c3.setHalignment(HPos.CENTER);
	
	tabs = new ArrayList<>();
	tabPane = new TabPane();
	grid.add(tabPane, 1, 0);
	GridPane.setRowSpan(tabPane, 8);
	
	/*
	// TEST TABS
	Tab tab1 = new Tab("Portfolio 1");
	tab1.setClosable(false);
	Tab tab2 = new Tab("Portfolio 2");
	tab2.setClosable(false);
	Tab tab3 = new Tab("Portfolio 3");
	tab3.setClosable(false);
	Tab tab4 = new Tab("Portfolio 4");
	tab4.setClosable(false);
	tabPane.getTabs().addAll(tab1, tab2, tab3, tab4);
	// uncomment or delete that stuff when implemented
	
	// TEST TABLE
	TableView<Stock> table = new TableView<>();
	ObservableList<Stock> stockList = FXCollections.observableArrayList();
	stockList.add(new Stock("AAA", "Stock1", 15.5, 3, true));
	stockList.add(new Stock("BBB", "Stock2", 36.2, 4, true));
	stockList.add(new Stock("CCC", "Stock3", 29.4, 2, true));
	table.setItems(stockList);
	// same as above
	
	TableColumn<Stock, String> symbolCol = new TableColumn<>("Ticker Symbol");
	symbolCol.setCellValueFactory(new PropertyValueFactory<>("symbol"));
	TableColumn<Stock, String> nameCol = new TableColumn<>("Stock Name");
	nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
	TableColumn<Stock, Integer> amountCol = new TableColumn<>("Number of Shares");
	amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
	TableColumn<Stock, Double> valueCol = new TableColumn<>("Price per Share");
	valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
	TableColumn<Stock, Double> totalCol = new TableColumn<>("Value of Holding");
	totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
	table.getColumns().setAll(symbolCol, nameCol, amountCol, valueCol, totalCol);
	
	tab1.setContent(table);
	*/
	
	// Folio side (left)
	
	folioText = new Text("Folio");
	grid.add(folioText, 0, 0);
	
	buttonCreateFolio = new Button("Create");
	buttonCreateFolio.setOnMouseClicked(controller::buttonCreateFolioClick);
	grid.add(buttonCreateFolio, 0, 1);
	
	buttonOpenFolio = new Button("Open");
	buttonOpenFolio.setOnMouseClicked(controller::buttonOpenFolioClick);
	grid.add(buttonOpenFolio, 0, 2);
	
	buttonDeleteFolio = new Button("Delete");
	buttonDeleteFolio.setOnMouseClicked(controller::buttonDeleteFolioClick);
	grid.add(buttonDeleteFolio, 0, 3);
	
	buttonSaveFolio = new Button("Save");
	buttonSaveFolio.setOnMouseClicked(controller::buttonSaveFolioClick);
	grid.add(buttonSaveFolio, 0, 4);
	
	buttonEditFolio = new Button("Edit");
	buttonEditFolio.setOnMouseClicked(controller::buttonEditFolioClick);
	grid.add(buttonEditFolio, 0, 5);
	
	// Stock side (right)
	
	stockText = new Text("Stock");
	grid.add(stockText, 2, 0);
	
	buttonBuyStock = new Button("Buy");
	buttonBuyStock.setOnMouseClicked(controller::buttonBuyStockClick);
	grid.add(buttonBuyStock, 2, 1);
	
	buttonSellStock = new Button("Sell");
	buttonSellStock.setOnMouseClicked(controller::buttonSellStockClick);
	grid.add(buttonSellStock, 2, 2);
	

	scene = new Scene(grid, 800, 500);
	primaryStage.setTitle("FolioTracker");
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public static void Main(String args[])
    {
	launch(args);
    }
    
    /**
     * This magic method makes a normal list observable
     * "Alohomora!"
     */
    private ObservableList<Stock> doObservableMagic(List<Stock> input)
    {
	ObservableList<Stock> l = FXCollections.observableArrayList();
	for(Stock s : l)
	{
	    l.add(s);
	}
	return l;
    }

    // methods to show other windows
    
    public void showCreateFolioWindow()
    {
	createFolioWindow.showWindow();
    }

    public void showBuyStockWindow(String symbol, String name, int amount)
    {
	buyStockWindow.showWindow(symbol, name, amount);
    }

    public void showSellStockWindow(String symbol, String name, double value, int amount)
    {
	sellStockWindow.showWindow(symbol, name, value, amount);
    }

    public void showEditFolioWindow(String name)
    {
	editFolioWindow.showWindow(name);
    }
    
    public void showFileWindow(String path)
    {
	fileWindow.showWindow(path);
    }
    
    // methods to modify/access data in main window
    
    public void addTab(List<Stock> content, String name)
    {
	Tab tab = new Tab(name);
	tabs.add(tab);
	TableView<Stock> table = new TableView<>();
	table.setItems(doObservableMagic(content));
	TableColumn<Stock, String> symbolCol = new TableColumn<>("Ticker Symbol");
	symbolCol.setCellValueFactory(new PropertyValueFactory<>("symbol"));
	TableColumn<Stock, String> nameCol = new TableColumn<>("Stock Name");
	nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
	TableColumn<Stock, Integer> amountCol = new TableColumn<>("Number of Shares");
	amountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
	TableColumn<Stock, Double> valueCol = new TableColumn<>("Price per Share");
	valueCol.setCellValueFactory(new PropertyValueFactory<>("value"));
	TableColumn<Stock, Double> totalCol = new TableColumn<>("Value of Holding");
	totalCol.setCellValueFactory(new PropertyValueFactory<>("total"));
	table.getColumns().setAll(symbolCol, nameCol, amountCol, valueCol, totalCol);
	tab.setContent(table);
	tabPane.getTabs().add(tab);
    }
    
    public String getOpenFolioName()
    {
	int i = 0;
	for(Tab tab : tabPane.getTabs())
	{
	    if(tabPane.getSelectionModel().isSelected(i))
	    {
		return tab.getText(); // return the folio name
	    }
	    i++;
	}
	return null;
    }
    
    public int getStockIndex()
    {
	int i = 0;
	for(Tab tab : tabPane.getTabs())
	{
	    if(tabPane.getSelectionModel().isSelected(i))
	    {
		int j = 0;
		for(Object o : ((TableView) tab.getContent()).getItems())
		{
		    if(((TableView) tab.getContent()).getSelectionModel().isSelected(j))
		    {
			return j;
		    }
		    j++;
		}
	    }
	    i++;
	}
	return -1; // no stock selected
    }
    
    // methods to get data from fileWindow
    
    public String getFilePath()
    {
	return fileWindow.getFilePath();
    }
    
    // methods to get data from buyStockWindow
    
    public String getBuyName()
    {
	return buyStockWindow.getName();
    }
    
    public String getBuySymbol()
    {
	return buyStockWindow.getSymbol();
    }
    
    public int getBuyAmount()
    {
	return buyStockWindow.getAmount();
    }
    
    // methods to get data from sellStockWindow
    
    public String getSellName()
    {
	return sellStockWindow.getName();
    }
    
    public String getSellSymbol()
    {
	return sellStockWindow.getSymbol();
    }
    
    public int getSellAmount()
    {
	return sellStockWindow.getAmount();
    }
    
    public double getSellValue()
    {
	return sellStockWindow.getValue();
    }
    
    // methods to get data from editFolioWindow
    
    public String getEditName()
    {
	return editFolioWindow.getNameText();
    }
    
    // methods to get data from createFolioWindow
    
    public String getCreateName()
    {
	return createFolioWindow.getNameText();
    }
}
