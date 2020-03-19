package ui;
import java.io.*;

import model.TuringMachine;

public class Main {
	private BufferedReader br;
	private BufferedWriter bw;
	private TuringMachine tm;
	public Main() throws FileNotFoundException,IOException {
		br=new BufferedReader(new FileReader("data"+File.separator+"input.txt"));
		bw=new BufferedWriter(new FileWriter("data"+File.separator+"out_turing.txt"));
		tm=new TuringMachine();
	}
	public void init() {}
	public static void main(String[] args) {
		try {
			long start=System.currentTimeMillis();
			Main main = new Main();
			String s=null;
			String toWrite="";
			s=main.br.readLine();
			while(s!=null) {
				char head='3';
				int action=-1;
				int sg=-1;
				for(int i=0;i<s.length();i++) {
					sg++;
					if(sg==0) {
						head=s.charAt(i);
					}else if(sg==1) {
						action=s.charAt(i);
						if(action=='0') {
							toWrite+=main.tm.read(head)+"\n";
						}else if(action=='2') {
							main.tm.delete(head);
						}
						if(action!='1')sg=-1;
					}else if(sg==2) {
						main.tm.add(head,s.charAt(i));
						sg=-1;
					}
				}
				s=main.br.readLine();
			}
			main.bw.write(toWrite);
			Thread.sleep(2000);
			long end=System.currentTimeMillis();
			System.out.println(end-start);
			main.br.close();
			main.bw.close();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
