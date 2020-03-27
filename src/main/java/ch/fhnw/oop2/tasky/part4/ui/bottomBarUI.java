package ch.fhnw.oop2.tasky.part4.ui;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import ch.fhnw.oop2.tasky.Core.State;
import ch.fhnw.oop2.tasky.ui.FormElements.ButtonsGridUI;
import ch.fhnw.oop2.tasky.ui.FormElements.InputTextArea;
import ch.fhnw.oop2.tasky.ui.FormElements.InputTextField;
import ch.fhnw.oop2.tasky.ui.FormElements.LabelPaneUI;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class bottomBarUI extends HBox{
	private ButtonsGridUI bottomButtons ;



	public bottomBarUI() {
		// TODO Auto-generated constructor stub
		initializeControls();
		layoutControls();	
	}

	private void initializeControls() {
		bottomButtons = new ButtonsGridUI(List.of("New", "Refresh"));
	}
	
	private void layoutControls() {
		setPadding(new Insets(5,10,15,10));
		getChildren().add(bottomButtons);

	}

}
