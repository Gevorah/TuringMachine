package model;

public class Tape {
	private char name;
	private Tape next;
	public Tape(char name) {
		this.name=name;
	}
	public char getName() {
		return name;
	}
	public Tape getNext() {
		return next;
	}
	public void setNext(Tape next) {
		this.next=next;
	}
}
