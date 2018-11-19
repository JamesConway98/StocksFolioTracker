import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
//import javafx.scene.text.Text;
import javafx.stage.*;

public class CreateStockWindow extends Stage
{
    private GridPane grid;
    private Scene scene;
    private Controller controller;
    
    private Button buttonCreate;
    private TextField textSymbol, textName, textValue, textAmount;
    private Text infoSymbol, infoName, infoValue, infoAmount;
    
    public CreateStockWindow(Controller controller)
    {
	this.controller = controller;
	grid = new GridPane();
	grid.setVgap(10);
	grid.setHgap(10);
	
	// Button
	buttonCreate = new Button("Create");
	// TODO listener
	grid.add(buttonCreate, 2, 3);
	GridPane.setHgrow(buttonCreate, Priority.ALWAYS);
	GridPane.setVgrow(buttonCreate, Priority.ALWAYS);
	GridPane.setHalignment(buttonCreate, HPos.CENTER);
	
	// Symbol
	infoSymbol = new Text("Ticker Symbol:");
	grid.add(infoSymbol, 0, 0);
	GridPane.setHgrow(infoSymbol, Priority.ALWAYS);
	GridPane.setVgrow(infoSymbol, Priority.ALWAYS);
	GridPane.setHalignment(infoSymbol, HPos.CENTER);
	
	textSymbol = new TextField();
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
	
	textName = new TextField();
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
	
	textValue = new TextField();
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
	
	textAmount = new TextField();
	grid.add(textAmount, 1, 3);
	GridPane.setHgrow(textAmount, Priority.ALWAYS);
	GridPane.setVgrow(textAmount, Priority.ALWAYS);
	GridPane.setHalignment(textAmount, HPos.CENTER);
	
	scene = new Scene(grid, 400, 200);
	this.setTitle("Create Stock");
	this.setScene(scene);
    }
}
