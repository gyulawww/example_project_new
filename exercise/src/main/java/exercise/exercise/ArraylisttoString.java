package exercise.exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArraylisttoString {
public static void main(String[] args) {
	List<String> strings= new ArrayList<>();
	strings.add("A");
	strings.add("B");
	strings.add("C");
	String[] arr = new String[1];
	arr=strings.toArray(arr); // Mindegy hogy kisebb array-t foglaltam.
	for(String s: arr){
		System.out.print(s);		
	}
	LocalDate ld=LocalDate.of(2016, 2, 27).plusDays(3);
	LocalDateTime lt=ld.atTime(10,10);
	System.out.println(lt);
	System.out.println(lt.getMonth());
	
	
} 
}
