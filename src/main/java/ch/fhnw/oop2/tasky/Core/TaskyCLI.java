package ch.fhnw.oop2.tasky.Core;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public final class TaskyCLI {


//    public static void main(String[] args) throws IOException {
//        new TaskyCLI().start();
//    }


    private void start() {
        Repository repository = new InMemoryMapRepository();       
        System.out.println("=Tasky CLI=");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("> ");
                String cmd = scanner.nextLine();
                switch (cmd) {
				
                case "show" :
					System.out.println("Order by, t=Title, d=description, s=state, z=date ?");
					List<Task> allTasks = repository.read();
					String sortCmd = scanner.nextLine();
					try{
						allTasks.sort(compareTask(sortCmd));
						allTasks.forEach(System.out::println);
					}catch(Exception e) {
						System.out.println("Ungültige Sortier Art");
					}
					break;
					
					case "filter" :
					System.out.println("Filter by state. Possible values are: Todo | InProgress | Done");
					//
					String filterCmd = scanner.nextLine();
					try {
					repository.read().stream()
						.filter(x -> x.data.state == State.valueOf(filterCmd))
						.forEach(System.out::println);
					}catch(IllegalArgumentException e) {
						System.out.println("Ungültiger Filter Wert");
					}
					break;
					
                case "add":
                    TaskData addTaskData = askForTaskData(scanner);
                    Task addedTask = repository.create(addTaskData);
                    System.out.println("Added: " + addedTask);
                    break;
                    
                case "get":
                    long id = askForID(scanner);
                    Task task = repository.read(id);
                    System.out.println(task);
                    break;

                case "update":
                    long updateId = askForID(scanner);
                    TaskData updateTaskData = askForTaskData(scanner);
                    Task updateTask = new Task(updateId, updateTaskData);

                    repository.update(updateTask);
                    System.out.println("Update successful");
                    break;

                case "delete":
                    long deleteId = askForID(scanner);
                    
                    repository.delete(deleteId);
                    System.out.println("Deleted: " + deleteId);
                    break;

                default:
                    System.out.println("Supported commands: show | filter | add | get | update | delete");
                }
            }
        }
    }
    

    private long askForID(Scanner scanner) {
        System.out.println("ID:");
        return Long.valueOf(scanner.nextLine());
    }


    private TaskData askForTaskData(Scanner scanner) {
        System.out.println("Title:");
        String addTitle = scanner.nextLine();

        System.out.println("Description:");
        String addDesc = scanner.nextLine();

        System.out.println("Due date (YYYY-MM-DD)");
        LocalDate addDueDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("State (Todo | InProgress | Done):");
        State state = State.valueOf(scanner.nextLine());

        TaskData taskData = new TaskData(addTitle, addDesc, addDueDate, state);
        return taskData;
    }
    
	private Comparator<Task> compareTask(String type){
		switch(type) {
		case"t":
			return (Task t1, Task t2) -> t1.data.title.compareTo(t2.data.title);
		case "z":
			return (Task t1, Task t2) -> t1.data.dueDate.compareTo(t2.data.dueDate);
		case "s":
			return (Task t1, Task t2) -> t1.data.state.compareTo(t2.data.state);
		case "d":
			return (Task t1, Task t2) -> t1.data.description.compareTo(t2.data.description);
		default:
			return null;
		}
	}
}
