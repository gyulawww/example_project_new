package Lambda.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ReferenceToConstructor {
	 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Function: Represents a function that accepts one argument and produces a result. 
         List  numbers = Arrays.asList(4,9,16,25,36);
         List squaredNumbers = ReferenceToConstructor.findSquareRoot(numbers,Double::new);
         System.out.println("Square root of numbers = "+squaredNumbers);
    }
 
    private static List findSquareRoot(List list, Function<Double,Double> f){
        List<Double> result = new ArrayList<Double>();
        list.forEach(x -> { result.add(f.apply(Math.sqrt((int)x)));
        });
        return result;
    
    }     
}