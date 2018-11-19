import java.util.ArrayList;
import java.util.List;

import javafx.application.*;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.collections.FXCollections;

public class GUI extends Application
{
    private Controller controller;
    private GridPane grid;
    private Scene scene;
    
    private Button buttonCreateFolio;    
    private Button buttonDeleteFolio;
    private Button buttonSaveFolio;
    private Button buttonCreateStock;
    private Button buttonEditStock;
    private Button buttonDeleteStock;
    private Button buttonOpenFolio;
    private Button buttonEditFolio;
    private Text folioText, stockText;
    private TabPane tabPane;
    private List<Tab> tabs; // used to store tabs so they're accessible later

    public void start(Stage primaryStage) throws Exception
    {
	controller = new Controller(this);
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
	
	// TEST TABLE
	TableView<Stock> table = new TableView<>();
	ObservableList<Stock> stockList = FXCollections.observableArrayList();
	stockList.add(new Stock("AAA", "Stock1", 15.5, 3));
	stockList.add(new Stock("BBB", "Stock2", 36.2, 4));
	stockList.add(new Stock("CCC", "Stock3", 29.4, 2));
	table.setItems(stockList);
	
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
	
	// Folio side (left)
	
	folioText = new Text("Folio");
	grid.add(folioText, 0, 0);
	
	buttonCreateFolio = new Button("Create");
	buttonCreateFolio.setOnMouseClicked(controller::buttonCreateFolioClick);
	grid.add(buttonCreateFolio, 0, 1);
	
	buttonOpenFolio = new Button("Open");
	// TODO listener
	grid.add(buttonOpenFolio, 0, 2);
	
	buttonDeleteFolio = new Button("Delete");
	buttonDeleteFolio.setOnMouseClicked(controller::buttonDeleteFolioClick);
	grid.add(buttonDeleteFolio, 0, 3);
	
	buttonSaveFolio = new Button("Save");
	// TODO listener
	grid.add(buttonSaveFolio, 0, 4);
	
	buttonEditFolio = new Button("Edit");
	buttonEditFolio.setOnMouseClicked(controller::buttonEditFolioClick);
	grid.add(buttonEditFolio, 0, 5);
	
	// Stock side (right)
	
	stockText = new Text("Stock");
	grid.add(stockText, 2, 0);
	
	buttonCreateStock = new Button("Create");
	buttonCreateStock.setOnMouseClicked(controller::buttonCreateStockClick);
	grid.add(buttonCreateStock, 2, 1);
	
	buttonEditStock = new Button("Edit");
	buttonEditStock.setOnMouseClicked(controller::buttonEditStockClick);
	grid.add(buttonEditStock, 2, 2);
	
	buttonDeleteStock = new Button("Delete");
	// TODO listener
	grid.add(buttonDeleteStock, 2, 3);

	scene = new Scene(grid, 800, 500);
	primaryStage.setTitle("FolioTracker");
	primaryStage.setScene(scene);
	primaryStage.show();
    }

    public static void Main(String args[])
    {
	launch(args);
    }

}
