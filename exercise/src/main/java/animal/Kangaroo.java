package animal;

import exercise.exercise.I;

public class Kangaroo extends Marsupial implements I{
	public boolean isBiped() {
		return true;
		}
	protected static String inBiped(int h){
		return "Overload-olt";
	}   // static-ra is overload-olhatunk.
	public static boolean isStatic() {
		return true;
		}
	private void isPrivate(){
		System.out.println("Private Kangaroo.");
		
	}
		public void getKangarooDescription() {
		System.out.println("Kangaroo hops on two legs: "+isBiped());
		}
		public static void main(String[] args) {
	    System.out.println("Az ősben lévő m: "+m);		
		Kangaroo sub_sub = new Kangaroo();
		Marsupial os_sub=new Kangaroo();
		Marsupial os_os=new Marsupial();
		
		sub_sub.getMarsupialDescription();
		sub_sub.getKangarooDescription();
		System.out.println();
		
		System.out.println("public overriding question:");
		System.out.println(sub_sub.isBiped()); //true
		System.out.println(os_sub.isBiped());  //true   Mindig a fölülírtat látja.
		System.out.println(os_os.isBiped());   //false  Kivéve ha os_os a példányosítás.
		                                          
		
		
		System.out.println();
		System.out.println("static method question:");
		System.out.println(sub_sub.isStatic()); //true
		System.out.println(os_sub.isStatic());  //false  A Hiding static-ot a referenciának megfelelően látja.
		                                               // Vagy aszerint amelyik osztályból hívja.
		Boolean b=Boolean.TRUE;
		
		System.out.println();
		System.out.println("Instance of? "); // A Kangaroo-ban van implementálva.
		System.out.println(os_sub instanceof I); //true
		System.out.println(os_os instanceof I);  //false
		// Itt is csak akkor nem instance-e, ha os_os -ként példányosítom.
		
		System.out.println("Private question:");
		sub_sub.isPrivate(); // Csak saját class-ából lehet meghívni saját referenciával.
		// os_sub.isPrivate(); Az os_sub referenciával sem lehet.
		// os_os.isPrivate(); Az os os referenciával sem látszik innen, mert private.
		// Ugyanígy egy másik osztályból sem látszik, mert private. Compilation error.
		System.out.println("Final question:");
		// Ha az ősben csak final, akkor a subclassban sem private-al,
		// sem private final-el nem fogad el method-ot, mert az már overriding lenne.
		// Ha az ősben private final, akkor elfogad a sub-ban private-et,
		// private final-t, vagy public-ot protected-et is akár.
		
		
		
		System.out.println("The protected question:");
		System.out.println(sub_sub.m);
		System.out.println(os_sub.m);
		System.out.println(os_os.m);  // Mindig látszik, mert ugyanabban a package-ben van.
		// Ha más package-ben vannak, akkor csak sub_sub példány esetén látszik
		// az ősben levő protected változó. Egyébként nem számít öröklöttnek.
		
		for(int e=0;e<3;){
			e++; //e=e++; végtelen ciklus, mert először teszi 0-val egyenlővé. e++-al jó.
			     // e=e++ az egy semmire való sor. Trükkös!!!
			System.out.println("hh");			
		}
		String str="animal";
		str= str.replace('a','A');
		System.out.println(str);
		System.out.println();
		
		String x = new String("Hello World");
		String y = "Hello World";
		String z = new String("Hello World");
		
		StringBuilder sb=new StringBuilder("Hello World");
		StringBuilder sb2=new StringBuilder("Hello World");
		StringBuilder sb3=new StringBuilder("one");
		StringBuilder sb4=new StringBuilder("one");
		
		int [] arr=new int[2]; //{1,2};
		x.length();
		sb.length();
		int d=arr.length;
		
		
		System.out.println("String osszehasonlítás:");
		System.out.println(x == y); // false
		System.out.println("Hello World" == y); //true
		System.out.println("Hello World" == x); //false
		System.out.println(y.equals("Hello World")); //true 
		System.out.println(x.equals(y)); //true
		System.out.println(x.equals(z)); //true
		
		System.out.println("StringBuilderes osszehasonlítás:");
		System.out.println(x.equals(sb)); // false Az equals elsőnek nézi, hogy ugyanolyan típusúak-e.
		System.out.println(sb.equals(x)); // false Az equals elsőnek nézi, hogy ugyanolyan típusúak-e.
		// System.out.println(x==sb); Compilation error ha nem ugyanolyan tipus.
		System.out.println(sb.toString().equals(x)); //true		
		System.out.println(sb.equals(sb2)); //false 
		System.out.println(sb2.toString()== "Hello World"); //false
		sb2=sb;
		System.out.println(sb2.equals(sb)); //true
		System.out.println(sb2==sb); //true
		System.out.println(sb3.equals(sb4)); //false
		
		final int movie=4;
		int bad=0;
		switch(bad){
		//case 4:  // Mindkettő hibás lesz, ha constans a case statement.
		case movie:System.out.println();break;
		}
		}
}
