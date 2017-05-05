package Lambda.Lambda;

import java.util.function.Consumer;

public class MRDemo_instance {
	
	  
	class Superclass
	{
	   void print(String msg)
	   {
	      System.out.printf("Superclass print(): %s%n", msg);
	   }
	}

	class Subclass extends Superclass
	{
	   Subclass()
	   {
	      Consumer<String> consumer = Subclass.super::print;
	      consumer.accept("Subclass.super::print");
	      consumer = this::print;
	      consumer.accept("this::print");
	   }

	   @Override
	   void print(String msg)
	   {
	      System.out.printf("Subclass print override(): %s%n", msg);
	   }	   
	}
	
	public static void main(String[] args)
	   {
	     MRDemo_instance demo= new MRDemo_instance();
	     demo.new Subclass();
	   }

}
