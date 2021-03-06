package ch.fhnw.oop2.tasky.Core;

import java.time.LocalDate;

/**
 * Die Daten einer Task. Diese Klasse hat keine Identität und wird immer zusammen
 * mit der Klasse Task gebraucht. Objekte dieser Klasse sind immutable.
 *
 */
public class TaskData {
	
	/**
	 * Die Zustände, welche eine Task haben kann.
	 */

	public final LocalDate dueDate;
	public final State state;
	public final String title;
	public final String description;
	
	/**
	 * Erzeugt ein neues TaskData.
	 * 
	 * @param title  Der Titel
	 * @param desc  Die Beschreibung
	 * @param dueDate  Das Datum an dem die Task erledigt sein soll
	 * @param state  Der Zustand der Task
	 */
	public TaskData(String title, String desc, LocalDate dueDate, State state) {
		this.dueDate = dueDate;
		this.state = state;
		this.title = title;
		this.description = desc;
	}
	
	@Override
	public String toString() {
		return "title= " + title + ", desc= " + description + ", dueDate= " + dueDate +", state= " + state;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TaskData other = (TaskData) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (dueDate == null) {
            if (other.dueDate != null)
                return false;
        } else if (!dueDate.equals(other.dueDate))
            return false;
        if (state != other.state)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }
	
	
}