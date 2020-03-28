package ui;
import java.io.*;

import model.TuringMachine;

public class Main {
	private static final String INPUT="data"+File.separator+"in_turing.txt";
	private static final String OUTPUT="data"+File.separator+"out_turing.txt";
	private TuringMachine tm;
	public Main() {
		tm=new TuringMachine();
	}
	public static void main(String[] args) throws Exception {
		long start=System.currentTimeMillis();
		BufferedReader br=new BufferedReader(new FileReader(INPUT));
		BufferedWriter bw=new BufferedWriter(new FileWriter(OUTPUT));
		Main main = new Main();
		String s=null;
		s=br.readLine();
		while(s!=null) {
			char head='3';
			char action='3';
			int sg=-1;
			for(int i=0;i<s.length();i++) {
				sg++;
				if(sg==0) {
					head=s.charAt(i);
				}else if(sg==1) {
					action=s.charAt(i);
					if(action=='0') {
						bw.write(main.tm.read(head)+"\n");
					}else if(action=='2') {
						main.tm.delete(head);
					}
					if(action!='1')sg=-1;
				}else if(sg==2) {
					main.tm.add(head,s.charAt(i));
					sg=-1;
				}
			}
			main.tm.reset();
			s=br.readLine();
		}
		long end=System.currentTimeMillis();
		System.out.println((double)(end-start)+"ms");
		br.close();
		bw.close();
	}
}
