package typhlos.windows.mainwindow;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import typhlos.client.Client;

public class MainWindowController implements Initializable{
	
	@FXML private TextField server;
	@FXML private TextField port;
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private Button login;
	@FXML private Button sendHello;
	Client client;
	
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		
		login.setOnAction(e -> {
			System.out.println(server.getText() + ":" + port.getText());
			client = new Client(username.getText(), password.getText(), server.getText(), Integer.parseInt(port.getText()));
			client.connect();
		});
		
		sendHello.setOnAction(e -> {
			//client.sendHello();
		});
		
	}
	
}
