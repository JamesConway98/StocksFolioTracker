import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.*;

public class SellStockWindow extends Stage
{
    private GridPane grid;
    private Scene scene;
    private Controller controller; // TODO interface
    
    private Button buttonSellNow;
    private TextField textSymbol, textName, textValue, textAmount;
    private Text infoSymbol, infoName, infoValue, infoAmount;
    
    public SellStockWindow(Controller controller)
    {
	this.controller = controller;
	grid = new GridPane();
	grid.setVgap(10);
	grid.setHgap(10);
	
	// Button
	buttonSellNow = new Button("Sell");
	buttonSellNow.setOnMouseClicked(controller::buttonBuyNowClick);
	grid.add(buttonSellNow, 2, 3);
	GridPane.setHgrow(buttonSellNow, Priority.ALWAYS);
	GridPane.setVgrow(buttonSellNow, Priority.ALWAYS);
	GridPane.setHalignment(buttonSellNow, HPos.CENTER);
	
	// Symbol
	infoSymbol = new Text("Ticker Symbol:");
	grid.add(infoSymbol, 0, 0);
	GridPane.setHgrow(infoSymbol, Priority.ALWAYS);
	GridPane.setVgrow(infoSymbol, Priority.ALWAYS);
	GridPane.setHalignment(infoSymbol, HPos.CENTER);
	
	textSymbol = new TextField("AAA");
	grid.add(textSymbol, 1, 0);
	GridPane.setHgrow(textSymbol, Priority.ALWAYS);
	GridPane.setVgrow(textSymbol, Priority.ALWAYS);
	GridPane.setHalignment(textSymbol, HPos.CENTER);
	
	// Name
	infoName = new Text("Stock Name:");
	grid.add(infoName, 0, 1);
	GridPane.setHgrow(infoName, Priority.ALWAYS);
	GridPane.setVgrow(infoName, Priority.ALWAYS);
	GridPane.setHalignment(infoName, HPos.CENTER);
	
	textName = new TextField("Stock1");
	grid.add(textName, 1, 1);
	GridPane.setHgrow(textName, Priority.ALWAYS);
	GridPane.setVgrow(textName, Priority.ALWAYS);
	GridPane.setHalignment(textName, HPos.CENTER);
	
	// Value
	infoValue = new Text("Price per Share:");
	grid.add(infoValue, 0, 2);
	GridPane.setHgrow(infoValue, Priority.ALWAYS);
	GridPane.setVgrow(infoValue, Priority.ALWAYS);
	GridPane.setHalignment(infoValue, HPos.CENTER);
	
	textValue = new TextField("15.5");
	grid.add(textValue, 1, 2);
	GridPane.setHgrow(textValue, Priority.ALWAYS);
	GridPane.setVgrow(textValue, Priority.ALWAYS);
	GridPane.setHalignment(textValue, HPos.CENTER);
	
	// Amount
	infoAmount = new Text("Number of Shares:");
	grid.add(infoAmount, 0, 3);
	GridPane.setHgrow(infoAmount, Priority.ALWAYS);
	GridPane.setVgrow(infoAmount, Priority.ALWAYS);
	GridPane.setHalignment(infoAmount, HPos.CENTER);
	
	textAmount = new TextField("3");
	grid.add(textAmount, 1, 3);
	GridPane.setHgrow(textAmount, Priority.ALWAYS);
	GridPane.setVgrow(textAmount, Priority.ALWAYS);
	GridPane.setHalignment(textAmount, HPos.CENTER);
	
	scene = new Scene(grid, 400, 200);
	this.setTitle("Sell Stock");
	this.setScene(scene);
    }
    
    public void showWindow() // TODO add arguments to set TextFields
    {
	// TODO set TextFields
	this.show();
    }
}
