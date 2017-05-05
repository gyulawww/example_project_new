package Lambda.Lambda;

import java.util.function.Function;

public class MRDemo_function {
	private String name;

	MRDemo_function()
	   {
	      name = "";
	   }

	MRDemo_function(String name)
	   {
	      this.name = name;
	      // A kovetkezo sort szedd ki ha meg akarod érteni.	      
	      System.out.printf("MRDemo(String name) called with %s%n", name);
	   }

	   public static void main(String[] args)
	   {
		  // Function: Represents a function that accepts one argument and produces a result. 
	      Function<String, MRDemo_function> function = MRDemo_function::new;
	      System.out.println(function.apply("some name"));
	      String s =new String();
	      System.out.println(s.getBytes());
	   }
}
