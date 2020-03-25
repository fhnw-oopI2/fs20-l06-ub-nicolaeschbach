package ch.fhnw.oop2.tasky.part4.ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import ch.fhnw.oop2.tasky.Core.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;


public class TaskOverview extends HBox{
	private List<Pane> tasks;
	public Repository repository;
	
	public TaskOverview() {
		// TODO Auto-generated constructor stub
		repository = new InMemoryMapRepository();
		repository.create(new TaskData("A", "A", LocalDate.of(2020, 12, 12), State.InProgress));
		repository.create(new TaskData("B", "B", LocalDate.of(2020, 12, 12), State.Todo));
		repository.create(new TaskData("C", "C", LocalDate.of(2020, 12, 12), State.Todo));
		repository.create(new TaskData("C", "C", LocalDate.of(2020, 12, 12), State.Todo));
		initializeControls();
		layoutControls();
	}

	
	
	private void initializeControls() {
		tasks = new ArrayList<Pane>();
		Arrays.stream(State.values())
				.map(x -> {
							Pane box =  new VBox();
							Label label = new Label(x.toString());
							box.setMinWidth(150);
							box.getChildren().add(label);
							box.getChildren().add(new StateOverviewUI(repository, x));
																	
							return box;
				})
				.forEach(x -> tasks.add(x));
	}
	
	
	private void layoutControls() {
		setSpacing(10);
		tasks.stream()
			.forEach(x -> getChildren().add(x));

		tasks.stream()
		.forEach(x -> x.setPadding(new Insets(0,20,0,20))	);
	
	}
}
