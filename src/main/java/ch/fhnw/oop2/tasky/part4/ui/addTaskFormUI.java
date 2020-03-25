package ch.fhnw.oop2.tasky.part4.ui;

import java.awt.TextField;
import java.util.Collection;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class addTaskFormUI extends VBox{
	private  Pane idField;
	private Pane titleField;
	private Pane DescField;
	private Pane dateField;
	private Pane stateField;
	private Region idLabel;

	public addTaskFormUI() {
		// TODO Auto-generated constructor stub
		initializeControls();
		layoutControls();
		
	}



	private void initializeControls() {
		idField = new HBox();
		titleField = new HBox();
		DescField = new HBox();
		dateField = new HBox();
		stateField = new HBox();
		idLabel = new InputLabelFielUI("ID:");
		
	}
	
	private void layoutControls() {
		getChildren().add(idLabel);
	//	idField.getChildren().addAll((Collection<? extends Node>) new TextField("id"));
	}

}
