package model;

public class TuringMachine {
	private Tape c0;
	private Tape c1;
	private Tape c2;
	private int n;
	public TuringMachine() {
		c0=c1=c2=null;
		n=-1;
	}
	public char read(char head) {
		if(c0!=null) {
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
		if(c0!=null) {
			if(head=='0') {
				Tape tmp=c0;
				tmp.setPrevious(add);
				add.setNext(tmp);
				c0=add;
				n++;
				if(n%2!=0)c1=c1.getPrevious();
			}else if(head=='1') {
				if(n%2==0) {
					Tape prev=c1.getPrevious();
					if(prev==null) {
						add.setNext(c1);
						c1.setPrevious(add);
						c0=c1=add;
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
			c0=c1=c2=add;
			n++;
		}
	}
	public void delete(char head) {
		if(c0!=null) {
			if(head=='0') {
				Tape next=c0.getNext();
				if(next!=null) {
					next.setPrevious(null);
					c0=next;
					if(n%2!=0)c1=c1.getNext();
				}else {
					c0=c1=c2=null;
				}
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
					c0=c1=c2=next;
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
					c0=c1=c2=null;
				}
				n--;
			}
		}
	}
	public void reset() {
		c0=c1=c2=null;
		n=-1;
	}
}
