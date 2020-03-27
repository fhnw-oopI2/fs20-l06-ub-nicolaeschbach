package ch.fhnw.oop2.tasky.part4.ui;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ApplicationUI extends BorderPane {
	Pane newTaskForm;
	Pane taskOverview;
	Stage stage;
	
	public ApplicationUI(Stage stage) {
		// TODO Auto-generated constructor stub
		initializeControls();
		layoutControls();
		this.stage = stage;
	}



	private void initializeControls() {
		newTaskForm = new addTaskFormUI();
		taskOverview = new BoardTasksUI();
	}
	
	private void layoutControls() {

		setCenter(taskOverview);
		setRight(newTaskForm);
		setMargin(taskOverview, new Insets(5));
		setMargin(newTaskForm, new Insets(50,50,0,0));

		
	}
}
