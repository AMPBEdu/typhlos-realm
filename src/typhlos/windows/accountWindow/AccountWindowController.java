package typhlos.windows.accountWindow;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AccountWindowController implements Initializable {

	@FXML Button save;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		save.setOnAction(e -> {
			
		});
	}
	
	
}
