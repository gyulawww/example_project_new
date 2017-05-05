package animal;

public class Autoboxint {
			void p(int... x){
		System.out.println("in int...");
	} 
	/*	void p(Integer x){
		System.out.println("in Integer");
	}*/
	void p(Long x){
		System.out.println("in Long");
	}
	/*	void p(long x){
		System.out.println("in long");
	}*/
public static void main(String[] args) {
	Integer a=4;
	int b=4,k=2;
	long c=4;
	Short s=4;
	new Autoboxint().p(a);
	b=b++;   // Ha magával teszem egyenlővé, akkor nem növeli a b értékét.
	System.out.println("b: "+b);
	k=b++;  // Ha egy másikat, k használok, akkor a b-t később megnöveli.
	System.out.println("k: "+k);
	System.out.println("b: "+b);
}
}
