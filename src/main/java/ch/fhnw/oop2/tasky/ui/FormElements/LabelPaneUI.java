package ch.fhnw.oop2.tasky.ui.FormElements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class LabelPaneUI extends HBox{
	private Label label;
	private Control control;
	
	
	public LabelPaneUI(String label, Control control) {
		// TODO Auto-generated constructor stub
		initializeControls(label, control);
		layoutControls();
	}


	private void initializeControls(String label, Control control) {
		this.label = new Label(label);
		this.control = control;

	}
	
	private void layoutControls() {
		setPadding(new Insets(5));
		setAlignment(Pos.TOP_LEFT);
		setSpacing(10);
		setMaxHeight(80);
		label.setMinWidth(30);
		control.setMinWidth(this.getWidth());

		getChildren().add(label);
		getChildren().add(control);
		
	}
}
