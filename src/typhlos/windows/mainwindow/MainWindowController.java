package typhlos.windows.mainwindow;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainWindowController implements Initializable{
	@FXML private Button addAccButton;
	@FXML private Button deleteAccButton;
	@FXML private Button editAccButton;
	@FXML private Button loginAccButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addAccButton.setOnAction(e -> {
			
		});
		deleteAccButton.setOnAction(e -> {});
		editAccButton.setOnAction(e -> {});
		loginAccButton.setOnAction(e -> {});
	}
	
	private void addAccount(){
		Parent root;
		try{
			root = FXMLLoader.load(getClass().getResource("../accountWindow/AccountWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Typhos Realm - Add account");
		stage.setScene(new Scene(root,200,145));
		stage.show();
		}catch(IOException exception){
			exception.printStackTrace();
		}
	}
	
	private void editAccount(String username, String password){
		Parent root;
		try{
			root = FXMLLoader.load(getClass().getResource("../accountWindow/AccountWindow.fxml"));
		Stage stage = new Stage();
		stage.setTitle("Typhos Realm - Edit account");
		stage.setScene(new Scene(root,200,145));
		stage.show();
		}catch(IOException exception){
			exception.printStackTrace();
		}
	}

}
