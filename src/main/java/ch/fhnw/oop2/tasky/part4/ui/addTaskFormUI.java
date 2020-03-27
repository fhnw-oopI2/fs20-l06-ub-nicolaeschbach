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


public class addTaskFormUI extends VBox{
	private Label titel;
	private HBox idField;
	private HBox titleField;
	private HBox descField;
	private HBox dateField;
	private HBox stateField;
	private HBox bestatigenFeld;
	private ComboBox<State> stateDropDown;
	private DatePicker checkInDatePicker;
	


	public addTaskFormUI() {
		// TODO Auto-generated constructor stub
		initializeControls();
		layoutControls();	
	}

	private void initializeControls() {
		titel = new Label("Task Management");
		idField = new InputTextField("ID: ");
		titleField = new InputTextField("Title: ");
		descField = new InputTextArea("Desc:");
		checkInDatePicker = new DatePicker(LocalDate.of(1998, 10, 8));
		checkInDatePicker.setValue(LocalDate.now());
		stateDropDown = new ComboBox<State>();
		stateDropDown.getItems().addAll(Arrays.stream(State.values()).collect(Collectors.toCollection(FXCollections::observableArrayList)));
		dateField = new LabelPaneUI("Due", checkInDatePicker);
		stateField = new LabelPaneUI("State:", stateDropDown);
		bestatigenFeld = new ButtonsGridUI(List.of("Save", "Delete"));
	}
	
	private void layoutControls() {
		setMaxWidth(300);
		titel.setFont(Font.font("",FontWeight.BOLD,15));
		titel.setPadding(new Insets(5,5,10,0));
		getChildren().add(titel);
		getChildren().add(idField);
		getChildren().add(titleField);
		getChildren().add(descField);
		getChildren().add(dateField);
		getChildren().add(stateField);	
		getChildren().add(bestatigenFeld);

	}

}
