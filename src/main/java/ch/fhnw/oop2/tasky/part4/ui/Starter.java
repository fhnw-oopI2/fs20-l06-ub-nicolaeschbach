package ch.fhnw.oop2.tasky.part4.ui;


import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {


	@Override
	public void start(Stage primaryStage)  {
	
		Parent parentRoot = new ApplicationUI(primaryStage);
		Scene scene = new Scene(parentRoot);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Tasky");
		primaryStage.setHeight(600);
		primaryStage.setWidth(800);
		primaryStage.show();
	}


	public static void main(String[] args) {
		Application.launch(args);

	}
	

}
