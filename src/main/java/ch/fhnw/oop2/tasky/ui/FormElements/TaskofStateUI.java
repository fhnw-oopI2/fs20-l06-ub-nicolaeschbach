package ch.fhnw.oop2.tasky.ui.FormElements;


import java.util.List;
import java.util.stream.Collectors;

import ch.fhnw.oop2.tasky.Core.Repository;
import ch.fhnw.oop2.tasky.Core.State;
import ch.fhnw.oop2.tasky.Core.Task;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;


public class TaskofStateUI extends VBox{
	private List<Task> tasks;
	private State state;
	
	public TaskofStateUI(Repository repository, State state) {
		// TODO Auto-generated constructor stub
		this.state = state;
		tasks = repository.read().stream()
			.filter(x -> x.data.state == state)
			.collect(Collectors.toList());
		
		initializeControls();
		layoutControls();
	}

	private void initializeControls() {
		tasks.stream()
			.forEach(x -> getChildren().add(new SingleTaskUI(x.id, x.data.title, x.data.dueDate, x.data.state)));
	}
	
	private void layoutControls() {

		setMinHeight(600);
		setMargin(this, new Insets(10,0,5,0));
		setPadding(new Insets(10,20,0,20));
		setStyle("-fx-background-color: #" + state.getColor() + ";");
		setSpacing(5);
		
	}
}
