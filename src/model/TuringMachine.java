package model;

public class TuringMachine {
	private Tape first;
	private Tape c0;
	private Tape c1;
	private Tape c2;
	private int n;
	public TuringMachine() {
		first=null;
		c0=c1=c2=null;
		n=-1;
	}
	public char read(char head) {
		if(first!=null) {
			if(head=='0') {
				return c0.getName();
			}else if(head=='1') {
				return c1.getName();
			}else if(head=='2') {
				return c2.getName();
			}
		}
		return '#';
	}
	public void add(char head,char name) {
		Tape add=new Tape(name);
		if(first!=null) {
			if(head=='0') {
				Tape tmp=first;
				tmp.setPrevious(add);
				add.setNext(tmp);
				first=add;
				c0=first;
				n++;//01
				if(n%2!=0)c1=c1.getPrevious();
				n+=0;
			}else if(head=='1') {
				if(n%2==0) {
					Tape prev=c1.getPrevious();
					if(prev==null) {
						add.setNext(c1);
						c1.setPrevious(add);
						first=add;
						c0=first;
						c1=first;
					}else {
						prev.setNext(add);
						add.setPrevious(prev);
						add.setNext(c1);
						c1.setPrevious(add);
						c1=c1.getPrevious();
					}
				}else {
					Tape next=c1.getNext();
					c1.setNext(add);
					add.setPrevious(c1);
					add.setNext(next);
					next.setPrevious(add);
					c1=c1.getNext();
				}
				n++;
			}else if(head=='2') {
				add.setPrevious(c2);
				c2.setNext(add);
				c2=c2.getNext();
				n++;
				if(n%2==0)c1=c1.getNext();
			}
		}else {
			first=add;
			c0=c1=c2=first;
			n++;
		}
	}
	public void delete(char head) {
		if(first!=null) {
			if(head=='0') {
				Tape next=first.getNext();
				if(next!=null) {
					next.setPrevious(null);
					first=next;
					if(n%2!=0)c1=c1.getNext();
				}else {
					first=null;
					c1=c2=first;
				}
				c0=first;
				n--;
			}else if(head=='1') {
				Tape prev=c1.getPrevious();
				Tape next=c1.getNext();
				if(prev!=null) {
					c1.setPrevious(null);
					c1.setNext(null);
					prev.setNext(next);
					next.setPrevious(prev);
					if(n%2==0)c1=prev;
					if(n%2!=0)c1=next;
				}else {
					c1.setNext(null);
					if(next!=null)next.setPrevious(null);
					first=next;
					c0=first;
					c1=first;
					c2=first;
				}
				n--;
			}else if(head=='2') {
				Tape prev=c2.getPrevious();
				if(prev!=null) {
					prev.setNext(null);
					c2.setPrevious(null);
					c2=prev;
					if(n%2==0)c1=c1.getPrevious();
				}else {
					first=null;
					c0=c1=c2=first;
				}
				n--;
			}
		}
	}
}
