package Lambda.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ReferenceToInstanceMethodOAPO {
	 public static void main(String[] args) {
	        // TODO code application logic here
	        List names = new ArrayList();
	            names.add("David");
	            names.add("Richard");
	            names.add("Samuel");
	            names.add("Rose");
	            names.add("John");
	 
	 
	           ReferenceToInstanceMethodOAPO.printNames(names,System.out::println);
	           ReferenceToInstanceMethodOAPO.printNames(names,System.out::print);
	    }
	 
	 
	    private static void printNames(List list, Consumer c ){
	        list.forEach(x -> c.accept(x));
	    }
}
