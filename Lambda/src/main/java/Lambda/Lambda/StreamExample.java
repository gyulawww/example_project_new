package Lambda.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args){
		List<String> myList =
			    Arrays.asList("a1", "a2", "b1", "c2", "c1");
		List<Integer> myList2 =
			    Arrays.asList(55, 10, 135, 20, 15);
			myList
			    .stream()
			    .filter(s -> s.startsWith("c"))
			    .map(String::toUpperCase)
			    .sorted()
			    .forEach(System.out::println);
			
			myList2.stream().filter((x) -> x%3==0).sorted().forEach(System.out::println); 
			//15
			//135
			
			Arrays.stream(new int[] {1, 2, 3})
		    .map(n -> 2 * n + 1)
		    .average()
		    .ifPresent(System.out::println);  // 5.0
			
			Stream.of("a1", "a2", "a3")
		    .map(s -> s.substring(1))
		    .mapToInt(Integer::parseInt)
		    .max()
		    .ifPresent(System.out::println);  // 3
			
			IntStream.range(1, 4)
		    .mapToObj(i -> "a" + i)
		    .forEach(System.out::println);

		    // a1
	     	// a2
		    // a3
			
			Stream.of(1.0, 2.0, 3.0)
		    .mapToInt(Double::intValue)
		    .mapToObj(i -> "a" + i)
		    .forEach(System.out::println);

		    // a1
		    // a2
		    // a3
			
			Stream.of("d2", "a2", "b1", "b3", "c","d2bc")
		    .filter(s -> {
		        System.out.println("filter: " + s);
		        return true;
		    })
		    .forEach(s -> System.out.println("forEach: " + s));

	}

}
