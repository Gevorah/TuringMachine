package model;

public class TuringMachine {
	private Tape first;
	private int n;
	public TuringMachine() {
		n=-1;
	}
	public char read(int head) {
		Tape tmp = first;
		int c1=n==0?0:n/2;
		int c=0;
		while(tmp!=null) {
			if(head==0) {
				return tmp.getName();
			}else if(head==1&&c==c1) {
				return tmp.getName();
			}else if(head==2&&c==n) {
				return tmp.getName();
			}
			tmp=tmp.getNext();
			c++;
		}
		return '#';
	}
	public void add(int head, char name) {
		Tape add=new Tape(name);
		Tape tmp = first;
		if(first==null) {
			first=add;
		}else {
			int c1=n==0?0:n/2;
			int c = 0;
			while(tmp!=null) {
				if(head==0) {
					add.setNext(tmp);
					first=add;
					n++;
					break;
				}else if(head==1&&c==c1) {
					Tape a=tmp.getNext();
					tmp.setNext(add);
					add.setNext(a);
					n++;
					break;
				}else if(head==2&&tmp.getNext()==null){
					tmp.setNext(add);
					n++
				}
				tmp=tmp.getNext();
				c++;
			}
		}
	}
}
