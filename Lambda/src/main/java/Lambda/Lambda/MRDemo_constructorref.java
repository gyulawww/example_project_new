package Lambda.Lambda;

import java.util.function.Supplier;

public class MRDemo_constructorref {
	// Ez a contructor referenciajat adja vissza
	 public static void main(String[] args)
	   {
		 // Supplier: Represents a supplier of results. 
	      Supplier<MRDemo_constructorref> supplier = MRDemo_constructorref::new;
	      System.out.println(supplier.get());
	   }
}
