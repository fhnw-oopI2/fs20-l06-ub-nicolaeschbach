package ch.fhnw.oop2.tasky.part4.ui;


import java.util.List;
import java.util.stream.Collectors;

import ch.fhnw.oop2.tasky.Core.Repository;
import ch.fhnw.oop2.tasky.Core.State;
import ch.fhnw.oop2.tasky.Core.Task;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;


public class StateOverviewUI extends VBox{
	private List<Task> tasks;
	private State state;
	
	public StateOverviewUI(Repository repository, State state) {
		// TODO Auto-generated constructor stub
		
		tasks = repository.read().stream()
			.filter(x -> x.data.state == state)
			.collect(Collectors.toList());
		
		initializeControls();
		layoutControls();
	}

	private void initializeControls() {
		tasks.stream()
			.forEach(x -> getChildren().add(new TaskUI(x.id, x.data.title, x.data.dueDate, x.data.state)));
	}
	
	private void layoutControls() {
		setMinHeight(500);
		setMargin(this, new Insets(5,0,5,0));
		setPadding(new Insets(0,20,0,20));
		setStyle("-fx-border-color: blue;");	
		setSpacing(5);
		
	}
}
