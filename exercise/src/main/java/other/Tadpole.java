package other;
import animal.*;
public class Tadpole extends Frog {
   public static void main(String[] args) {
	   Tadpole t= new Tadpole();
	   t.ribbit();
	   // t.jump();  // Ez nem látszik a package private miatt.
	   Frog f=new Tadpole();
	  // f.ribbit(); // Ez maga a döbbenet. Valahogy megszakítja a protected
	   // viszonyt is.
	   // f.jump();  // Ez nem látszik a package private miatt.
}
}
