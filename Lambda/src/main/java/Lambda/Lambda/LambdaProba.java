package Lambda.Lambda;

import java.util.function.Consumer;

public class LambdaProba {
	static String simi="Lalalala";
	public static void main(String[] args){
		//Consumer: Represents an operation that accepts a single input argument and returns no result.
		Consumer<String> consumer =(s) -> System.out.println(s);
		consumer.accept(simi);
		
		Consumer<String> consumer2 = System.out::println; // The 'method reference' is shorter.
		consumer2.accept("Hello"); // Pass "Hello" to lambda body. Print Hello to standard output.

	}

}
