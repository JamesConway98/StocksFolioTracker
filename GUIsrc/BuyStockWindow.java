import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.*;

public class BuyStockWindow extends Stage
{
    private GridPane grid;
    private Scene scene;
    private IController controller;

    private Button buttonBuyNow;
    private TextField textSymbol, textName, textAmount;
    private Text infoSymbol, infoName, infoAmount;

    public BuyStockWindow(IController controller)
    {
	this.controller = controller;
	grid = new GridPane();
	grid.setVgap(10);
	grid.setHgap(10);

	// Button
	buttonBuyNow = new Button("Buy");
	buttonBuyNow.setOnMouseClicked(controller::buttonBuyNowClick);
	grid.add(buttonBuyNow, 2, 3);
	GridPane.setHgrow(buttonBuyNow, Priority.ALWAYS);
	GridPane.setVgrow(buttonBuyNow, Priority.ALWAYS);
	GridPane.setHalignment(buttonBuyNow, HPos.CENTER);

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

	// Amount
	infoAmount = new Text("Number of Shares:");
	grid.add(infoAmount, 0, 2);
	GridPane.setHgrow(infoAmount, Priority.ALWAYS);
	GridPane.setVgrow(infoAmount, Priority.ALWAYS);
	GridPane.setHalignment(infoAmount, HPos.CENTER);

	textAmount = new TextField();
	grid.add(textAmount, 1, 2);
	GridPane.setHgrow(textAmount, Priority.ALWAYS);
	GridPane.setVgrow(textAmount, Priority.ALWAYS);
	GridPane.setHalignment(textAmount, HPos.CENTER);

	scene = new Scene(grid, 400, 200);
	this.setTitle("Buy Stock");
	this.setScene(scene);
    }

    public void showWindow(String symbol, String name, int amount)
    {
	textSymbol.setText(symbol);
	textName.setText(name);
	textAmount.setText(String.valueOf(amount));
	this.show();
    }

    public String getName()
    {
	return textName.getText();
    }

    public String getSymbol()
    {
	return textSymbol.getText();
    }

    public int getAmount()
    {
	try
	{
	    return Integer.parseInt(textAmount.getText());
	}
	catch (Exception e)
	{
	    return 0;
	}
    }
}
