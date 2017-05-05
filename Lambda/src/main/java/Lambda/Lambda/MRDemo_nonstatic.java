package Lambda.Lambda;

import java.util.function.Supplier;

public class MRDemo_nonstatic {
	  public static void main(String[] args)
	   {  
		  // Ez a nem static, amit felul lehet irni, de ennel van jobb pelda.
	      String s = "The quick brown fox jumped over the lazy dog";
	      print(s::length);
	      print(() -> s.length());
	      print(new Supplier<Integer>()
	      {
	         @Override
	         public Integer get()
	         {
	            return s.length(); // closes over s
	         }
	      });
	   }

	   public static void print(Supplier<Integer> supplier)
	   {
		   // Supplier Represents a supplier of results.
           // There is no requirement that a new or distinct result be returned
		   // each time the supplier is invoked. 
	      System.out.println(supplier.get());
	   }
}
