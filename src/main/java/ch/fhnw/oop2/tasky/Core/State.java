package ch.fhnw.oop2.tasky.Core;

public enum State {

	Todo("bed4f4"),
	InProgress("f3f4be"),
	Done("bef4cd");
//	Review("f4c2be");
	
	private String color;

	private State(String color){
		this.color= color;
	}
	
	public String getColor() {
		return this.color;
	}
	
}