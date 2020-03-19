package model;

public class TuringMachine {
	private Tape first;
	private Tape c0;
	private Tape c1;
	private Tape c2;
	private int n;
	public TuringMachine() {
		first=null;
		c0=null;
		c1=null;
		c2=null;
		n=-1;
	}
	public void add(char head,char name) {
		Tape add=new Tape(name);
		if(first!=null) {
			Tape curr=first;
			if(head=='0') {
				add.setNext(curr);
				first=add;
			}else if(head=='1') {
				
			}else if(head=='2') {
				
			}
		}else {
			first=add;
			c0=first;
			c1=first;
			c2=first;
		}
	}
	/*public char read(char head) {
		Tape current = first;
		int c1=n==0?0:n/2;
		int c=0;
		while(current!=null) {
			if(head=='0') {
				return current.getName();
			}else if(head=='1'&&c==c1) {
				return current.getName();
			}else if(head=='2'&&c==n) {
				return current.getName();
			}
			current=current.getNext();
			c++;
		}
		return '#';
	}
	public void add(char head, char name) {
		Tape add=new Tape(name);
		Tape current = first;
		if(first==null) {
			first=add;
			n++;
		}else {
			int c1=n==0?0:n/2;
			int c = 0;
			while(current!=null) {
				if(head=='0') {
					add.setNext(current);
					first=add;
					n++;
					break;
				}else if(head=='1'&&c==c1) {
					Tape next=current.getNext();
					current.setNext(add);
					add.setNext(next);
					n++;
					break;
				}else if(head=='2'&&current.getNext()==null){
					current.setNext(add);
					n++;
					break;
				}
				current=current.getNext();
				c++;
			}
		}
	}
	public void delete(char head) {
		Tape prev=null;
		Tape current=first;
		Tape next=current.getNext();
		int c1=n==0?0:n/2;
		int c=0;
		while(current!=null) {
			if(head=='0') {
				first=next;
				n--;
				break;
			}else if(head=='1'&&c==c1) {
				if(prev==null) {
					first=next;
				}else {
					prev.setNext(next);
				}
				n--;
				break;
			}else if(head=='2'&&next==null) {
				current=null;
				n--;
				break;
			}
			prev=current;
			current=current.getNext();
			next=next.getNext();
			c++;
		}
	}
	*/
}
