package animal;
import exercise.exercise.*;

public class ImplementInterface implements I,HasTail{
	int x=20; // de x=321; nem menne, mert az interface-ben is van ilyen változó, ami 
	          // public static final. Egy másik hasonló nevű változóval lehet shadow-olni.
	public int getTailLength(){
		return x*10;
	}
public static void main(String[] args) {
	I ref=new ImplementInterface();
	ImplementInterface ref2=(ImplementInterface)ref;
	System.out.println(ref.x);
	System.out.println(ref2.x);
}
}
