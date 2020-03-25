package ch.fhnw.oop2.tasky.part4.ui;

import javafx.scene.control.*;
import javafx.scene.layout.*;

public class InputLabelFielUI extends HBox{
	private Label label;
	private TextField textInput;
	
	
	public InputLabelFielUI(String label ) {
		// TODO Auto-generated constructor stub
		initializeControls(label);
		layoutControls();
		
	}


	private void initializeControls(String label) {
		this.label = new Label(label);
		this.textInput = new TextField();
	}
	
	private void layoutControls() {
		setSpacing(10);
		label.setMinWidth(30);
		getChildren().add(label);
		getChildren().add(textInput);
		
	}

}
