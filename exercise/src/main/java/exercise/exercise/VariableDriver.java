package exercise.exercise;
import animal.*;
public class VariableDriver extends Variable{
	public static void main(String[] args) {
		Variable var=new VariableDriver();
		//System.out.println(var.i);
		//System.out.println(var.j);
		// System.out.println(var.k);
		System.out.println(var.c); // Csak a public látszik másik osztályból
		//System.out.println(var.l);
		System.out.println(var.n);   // final az mindegy, ha nem akarom módosítani.
		// System.out.println(k);  Magában akkor látszana, ha static lenne a k, mivel
		//  a main method is static.
		
	}

}
