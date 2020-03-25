package ch.fhnw.oop2.tasky.part4.ui;

import java.time.LocalDate;

import ch.fhnw.oop2.tasky.Core.State;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;



public class TaskUI extends VBox {
	private long id;
	private LocalDate due;
	private String title;
	private State state;

	private Label idLabel;
	private Label dueLabel;
	private Label titleLabel;
	

	public TaskUI(long id, String title, LocalDate due, State state) {
		// TODO Auto-generated constructor stub
		this.due = due;
		this.id = id;
		this.title = title;
		this.state = state;
		
		initializeControls();
		layoutControls();
		
	}



	private void initializeControls() {
		this.dueLabel = new Label("Due: "+ due);
		this.idLabel = new Label("ID: "+ id);
		this.titleLabel = new Label("Title: " + title);
		
	}
	
	private void layoutControls() {
		setMargin(this, new Insets(5,0,5,0));
		setStyle("-fx-border-color: black;");
		getChildren().add(idLabel);
		getChildren().add(titleLabel);
		getChildren().add(dueLabel);
	//	idField.getChildren().addAll((Collection<? extends Node>) new TextField("id"));
	}
	


}


