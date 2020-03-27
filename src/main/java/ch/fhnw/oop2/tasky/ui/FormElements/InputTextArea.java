package ch.fhnw.oop2.tasky.ui.FormElements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class InputTextArea extends HBox{
	private Label label;
	private TextArea textInput;
	
	
	public InputTextArea(String label ) {
		// TODO Auto-generated constructor stub
		initializeControls(label);
		layoutControls();
	}


	private void initializeControls(String label) {
		this.label = new Label(label);
		textInput = new TextArea();

	}
	
	private void layoutControls() {
		setPadding(new Insets(5));
		setAlignment(Pos.TOP_LEFT);
		setSpacing(10);
		setMaxHeight(80);
		label.setMinWidth(30);
		textInput.setMinWidth(this.getWidth());

		getChildren().add(label);
		getChildren().add(textInput);
		
	}
}
