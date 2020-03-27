package ch.fhnw.oop2.tasky.part4.ui;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ApplicationUI extends BorderPane {
	Pane newTaskForm;
	Pane taskOverview;
	Pane bottomBar;
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
		bottomBar = new bottomBarUI();
	}
	
	private void layoutControls() {

		setCenter(taskOverview);
		setRight(newTaskForm);
		setBottom(bottomBar);
		setMargin(taskOverview, new Insets(5));
		setMargin(newTaskForm, new Insets(15,50,0,0));

		
	}
}
