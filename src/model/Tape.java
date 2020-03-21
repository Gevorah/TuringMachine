package model;

public class Tape {
	private char name;
	private Tape next;
	private Tape previous;
	public Tape(char name) {
		this.name=name;
	}
	public char getName() {
		return name;
	}
	public Tape getPrevious() {
		return previous;
	}
	public void setPrevious(Tape previous) {
		this.previous = previous;
	}
	public Tape getNext() {
		return next;
	}
	public void setNext(Tape next) {
		this.next=next;
	}
}
