package exercise.exercise;

import java.util.ArrayList;
import java.util.List;

public class Listset {
public static void main(String[] args) {
	List<Integer> list= new ArrayList<Integer>();
	list.add(2);
	list.add(3);
	// list.set(2,3);
	StringBuilder a=new StringBuilder("we");
	StringBuilder b=new StringBuilder("we");
	StringBuilder c=b;
	String s= "we";
	System.out.println(c.equals(b));
	System.out.println(a.equals(b));
	System.out.println(s.equals("we"));
	System.out.println(s.equals(b.toString()));
	// if(a=="we")System.out.println(we);
}
}
