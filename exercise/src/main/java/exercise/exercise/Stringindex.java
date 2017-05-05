package exercise.exercise;

import static java.lang.Integer.*;
public class Stringindex {
	public static void main(String[] args){
		String s="12345";
		int a=s.indexOf("6");
		System.out.println(a);
		String z=new String("a");
		// String z=new String("a");   Nem lehet.
		int s1w2=1; // Belül lehet szám,hátul is, csak az elején nem.
		
		StringBuilder b1=new StringBuilder("neo");
		StringBuilder b2=new StringBuilder("neo");
		if(b1.equals(b2)){System.out.println("igaz");}
		else System.out.println("hamis");
		if(b1.toString()=="neo")System.out.println("ez igaz");
		else System.out.println("ez sem");
		System.out.println(1.2+3.8);
		
		short d=2;
		float f1=2.1f;
		double f=3.3;
		f++;f1++;
		f -=0.5;
		if(d==f){
			d=4;
		}
		System.out.println("Az f erteke: "+f);
		System.out.println("Az f1 erteke: "+f1);
		
		// System.out.println(x++);
		int g=10;
		System.out.println(g%(-3));
		
		String r1="a";
		String r2="B";
		
		System.out.println(r1.compareToIgnoreCase(r2));
		
		Integer w=10;
		Integer q=10;
        final Integer _const =w.MAX_VALUE;
		if(w==q)System.out.println(true);
		int arr []=new int[0];
	}
	static Integer x;
	
}
