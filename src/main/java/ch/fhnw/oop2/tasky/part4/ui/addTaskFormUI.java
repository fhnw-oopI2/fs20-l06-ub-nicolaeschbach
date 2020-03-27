package ch.fhnw.oop2.tasky.part4.ui;


import java.awt.TextField;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import ch.fhnw.oop2.tasky.Core.State;
import ch.fhnw.oop2.tasky.ui.FormElements.InputTextArea;
import ch.fhnw.oop2.tasky.ui.FormElements.InputTextField;
import ch.fhnw.oop2.tasky.ui.FormElements.LabelPaneUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class addTaskFormUI extends VBox{
	private HBox idField;
	private HBox titleField;
	private HBox descField;
	private HBox dateField;
	private HBox stateField;
	private ComboBox<State> stateDropDown;
	private DatePicker checkInDatePicker;


	public addTaskFormUI() {
		// TODO Auto-generated constructor stub
		initializeControls();
		layoutControls();
		
	}



	private void initializeControls() {
		
		idField = new InputTextField("ID: ");
		titleField = new InputTextField("Title: ");
		descField = new InputTextArea("Desc:");
		checkInDatePicker = new DatePicker(LocalDate.of(1998, 10, 8));
		checkInDatePicker.setValue(LocalDate.now());
		stateDropDown = new ComboBox<State>();
		stateDropDown.getItems().addAll(Arrays.stream(State.values()).collect(Collectors.toCollection(FXCollections::observableArrayList)));
		dateField = new LabelPaneUI("Due", checkInDatePicker);
		stateField = new LabelPaneUI("State:", stateDropDown);
		
	}
	
	private void layoutControls() {

		setMargin(this, new Insets(80,20,0,0));
		setMaxWidth(300);
		getChildren().add(idField);
		getChildren().add(titleField);
		getChildren().add(descField);
		getChildren().add(dateField);
		getChildren().add(stateField);		

	}

}
