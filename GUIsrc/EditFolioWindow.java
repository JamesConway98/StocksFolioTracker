import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.*;

public class EditFolioWindow extends Stage
{
    private GridPane grid;
    private Scene scene;
    private IController controller;
    
    private Button buttonCreate;
    private TextField textName;
    private Text info;
    
    public EditFolioWindow(IController controller)
    {
	this.controller = controller;
	grid = new GridPane();
	grid.setVgap(10);
	grid.setHgap(10);
	
	buttonCreate = new Button("Apply");
	buttonCreate.setOnMouseClicked(controller::buttonEditFolioNowClick);
	grid.add(buttonCreate, 2, 0);
	GridPane.setHgrow(buttonCreate, Priority.ALWAYS);
	GridPane.setVgrow(buttonCreate, Priority.ALWAYS);
	GridPane.setHalignment(buttonCreate, HPos.CENTER);
	
	textName = new TextField("Portfolio 1");
	grid.add(textName, 1, 0);
	GridPane.setHgrow(textName, Priority.ALWAYS);
	GridPane.setVgrow(textName, Priority.ALWAYS);
	GridPane.setHalignment(textName, HPos.CENTER);
	
	info = new Text("Portfolio Name:");
	grid.add(info, 0, 0);
	GridPane.setHgrow(info, Priority.ALWAYS);
	GridPane.setVgrow(info, Priority.ALWAYS);
	GridPane.setHalignment(info, HPos.CENTER);
	
	scene = new Scene(grid, 400, 200);
	this.setTitle("Edit Folio");
	this.setScene(scene);
    }
    
    public void showWindow(String currentName)
    {
	textName.setText(currentName);
	this.show();
    }
    
    public String getNameText()
    {
	return textName.getText();
    }
}
