package ch.fhnw.oop2.tasky.ui.FormElements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class InputTextField extends HBox{
	private Label label;
	private TextField textInput;
	
	
	public InputTextField(String label ) {
		// TODO Auto-generated constructor stub
		initializeControls(label);
		layoutControls();
	}


	private void initializeControls(String label) {
		this.label = new Label(label);
		textInput = new TextField();

	}
	
	private void layoutControls() {
		setPadding(new Insets(5));
		setAlignment(Pos.CENTER_LEFT);
		setSpacing(10);
		setWidth(250);
		label.setMinWidth(30);
		textInput.setMinWidth(this.getWidth());
		textInput.setPadding(new Insets(5));
		getChildren().add(label);
		getChildren().add(textInput);
		
	}

}
