package typhlos.windows.mainWindow;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainWindowController implements Initializable{
	@FXML private Button addAccButton;
	@FXML private Button deleteAccButton;
	@FXML private Button editAccButton;
	@FXML private Button loginAccButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addAccButton.setOnAction(e -> {
			-
		});
		deleteAccButton.setOnAction(e -> {});
		editAccButton.setOnAction(e -> {});
		loginAccButton.setOnAction(e -> {});
	}

}
