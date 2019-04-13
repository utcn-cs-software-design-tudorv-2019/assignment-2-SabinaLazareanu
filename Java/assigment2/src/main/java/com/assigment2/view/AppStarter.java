package com.assigment2.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStarter extends Application implements Initializable {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		Stage loginStage = new Stage();
		loginStage.setTitle("Login:");
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("login.fxml"));
			loginStage.setScene(new Scene(root, 500, 250));
			loginStage.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
