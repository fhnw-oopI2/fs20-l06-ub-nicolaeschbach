package ch.fhnw.oop2.tasky.part4.ui;

import java.time.LocalDate;
import java.util.*;

import ch.fhnw.oop2.tasky.Core.*;
import ch.fhnw.oop2.tasky.ui.FormElements.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;



public class BoardTasksUI extends HBox{
	private List<Pane> tasks;
	public Repository repository;
	private ButtonsGridUI buttons;
	public BoardTasksUI() {
		// TODO Auto-generated constructor stub
		repository = new InMemoryMapRepository();
		repository.create(new TaskData("A", "A", LocalDate.of(2020, 12, 12), State.InProgress));
		repository.create(new TaskData("B", "B", LocalDate.of(2020, 12, 12), State.Todo));
		repository.create(new TaskData("C", "C", LocalDate.of(2020, 12, 12), State.Todo));
		repository.create(new TaskData("C", "C", LocalDate.of(2020, 12, 12), State.Todo));
		repository.create(new TaskData("C", "C", LocalDate.of(2020, 12, 12), State.Done));
		initializeControls();
		layoutControls();
	}

	private void initializeControls() {
		tasks = new ArrayList<Pane>();
		Arrays.stream(State.values())
				.map(x -> {	
					Pane box =  new VBox();
					Label label = new Label(x.toString());
					label.setFont(Font.font("",FontWeight.BOLD,15));
					box.setMinWidth(180);
					box.getChildren().add(label);
					box.getChildren().add(new TaskofStateUI(repository, x));									
					return box;
				})
				.forEach(x -> tasks.add(x));
	}
	
	
	private void layoutControls() {

		setPadding(new Insets(10,0,0,10));
		setMaxHeight(700);
		setSpacing(15);
		tasks.stream()
			.forEach(x -> getChildren().add(x));
		tasks.stream()
		.forEach(x -> x.setPadding(new Insets(2))	);
	}
}
