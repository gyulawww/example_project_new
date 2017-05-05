package animal;
import exercise.exercise.A;
public class B extends A {
	public B(){
		x=16; // A konstruktorában a másik package-ből is elérhető a protected változója az
		      // A-nak.
	}
   public static void main(String[] args) {
	B wh=new B();
	wh.print(5);
	
	System.out.println("Az ős static változója: "+B.stat); //De sima package private-ként nem érhető el.
	
	
}
   public void print(int y){
	   B a =new B(); // Ez az amikor öröklés miatt látszik a protected x
	   // A a=new A();  Igy viszont nem látszik a protected x.
	   A c= new B();
	   System.out.println(a.x);
	   // System.out.println(c.x); Os_sub példányosítás esetén sem látszik.
	   System.out.println(x);
   }
}
