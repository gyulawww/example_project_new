package exercise.exercise;

public class Ifstatement {
public static void main(String[] args) {
	Integer i=9;
	Double d= 9.0;
	short sh=9;
	byte b=9;
	float f=9.0f;
	System.out.println(sh ==i);
	System.out.println(i== sh);  // Elfogadja, mert az Integert autoboxolja.
	System.out.println(b== sh);  // Az összes integral primitivet össze tudja hasonlítani.
	System.out.println(b== f);   // Az összes integral primitivet össze tudja hasonlítani.
	// System.out.println(d== i);  Ez már nem megy
	System.out.println(d== b);   // de ezt megint autoboxolja.
	char c;
    final int j=12; 
    final short sho=10;
	c=j;     // A char = int értékadást csak akkor fogadja el, ha konstans az int.
	c=sho;   // A char= short-ot is csak akkor fogadja el,ha final a short.
	// sho =c;  Nem fogadja el a short = char-t sem, mert lehet olyanra állítani, ami nem jó.
	boolean b1=false;
	boolean b2=false;
	if(b2 != b1 != b2){             // A hármas összehasonlítás megy csak akkor nem, ha
		                           // helyette értékadás van () = !b2
		System.out.println("igaz");
	}else{
		System.out.println("hamis");
	}
	StringBuilder sb = new StringBuilder("animals");
	sb.insert(7, "-"); // sb = animals-
	sb.insert(0, "-"); // sb = -animals-
	sb.insert(4, "-"); // sb = -ani-mals-
	System.out.println(sb);
	String String="s";
	
	

}
}
