package ch.fhnw.oop2.tasky.ui.FormElements;

import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ButtonsGridUI extends HBox{

	private List<String> buttonList;

	
	public ButtonsGridUI(List<String> buttons) {
		// TODO Auto-generated constructor stub
		buttonList = buttons;
		initializeControls();
		layoutControls();
	}
	
	private void initializeControls() {
		buttonList.stream()
			.forEach(x -> {	Button button= new Button(x);
							getChildren().add(button);
			});

	}
	
	private void layoutControls() {
		setPadding(new Insets(5));
		setAlignment(Pos.TOP_LEFT);
		setSpacing(10);
		setMaxHeight(80);
	
	}
}
