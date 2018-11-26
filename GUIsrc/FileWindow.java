import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.*;

public class FileWindow extends Stage
{
    private GridPane grid;
    private Scene scene;
    private IController controller;
    
    private Button buttonCreate;
    private TextField textPath;
    private Text info;
    
    public FileWindow(IController controller)
    {
	this.controller = controller;
	grid = new GridPane();
	grid.setVgap(10);
	grid.setHgap(10);
	
	buttonCreate = new Button("Submit");
	buttonCreate.setOnMouseClicked(controller::buttonFileClick);
	grid.add(buttonCreate, 2, 0);
	GridPane.setHgrow(buttonCreate, Priority.ALWAYS);
	GridPane.setVgrow(buttonCreate, Priority.ALWAYS);
	GridPane.setHalignment(buttonCreate, HPos.CENTER);
	
	textPath = new TextField();
	grid.add(textPath, 1, 0);
	GridPane.setHgrow(textPath, Priority.ALWAYS);
	GridPane.setVgrow(textPath, Priority.ALWAYS);
	GridPane.setHalignment(textPath, HPos.CENTER);
	
	info = new Text("File Path:");
	grid.add(info, 0, 0);
	GridPane.setHgrow(info, Priority.ALWAYS);
	GridPane.setVgrow(info, Priority.ALWAYS);
	GridPane.setHalignment(info, HPos.CENTER);
	
	scene = new Scene(grid, 400, 200);
	this.setTitle("Open/Save");
	this.setScene(scene);
    }
    
    public void showWindow(String path)
    {
	textPath.setText(path);
	this.show();
    }
    
    public String getFilePath()
    {
	return textPath.getText();
    }
}
