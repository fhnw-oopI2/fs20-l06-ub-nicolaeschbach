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
		taskOverview = new TaskOverview();
	}
	
	private void layoutControls() {

		setCenter(taskOverview);
		setRight(newTaskForm);
		setHeight(400);
		setWidth(500);
		setMargin(taskOverview, new Insets(5));
		newTaskForm.setMinWidth(getHeight()/5*2);
		taskOverview.setMinWidth(getHeight()/5*3);		
		
	}
}
