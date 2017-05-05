package Lambda.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ReferenceToStaticMethodExample {
    /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
	   // Predicate: Represents a predicate (boolean-valued function) of one argument.
       List numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16);
       List primeNumbers = ReferenceToStaticMethodExample.findPrimeNumbers(numbers, (number) -> ReferenceToStaticMethodExample.isPrime((int) number));
       
       List primeNumbers2 = ReferenceToStaticMethodExample.findPrimeNumbers(numbers, (number) -> (int)number%2==0);
       List oddNumbers = ReferenceToStaticMethodExample.findPrimeNumbers(numbers, (number) -> (int)number%2!=0);
       System.out.println("Prime Numbers are: " + primeNumbers);
       System.out.println("The Even numbers are: " + primeNumbers2);
       System.out.println("The Odd numbers are: " + oddNumbers);
   }

   public static boolean isPrime(int number) {
       if (number == 1) {
           return false;
       }
       for (int i = 2; i < number; i++) {
           if (number % i == 0) {
               return false;
           }
       }
       return true;
   }

   public static List findPrimeNumbers(List list, Predicate predicate) {
       List sortedNumbers = new ArrayList();
       list.stream().filter((i) -> (predicate.test(i))).forEach((i) -> {
           sortedNumbers.add(i);
       });
       return sortedNumbers;

   }
}