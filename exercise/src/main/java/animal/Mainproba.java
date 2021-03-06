package animal;

public class Mainproba {
	public static void main(String[] args) {
		System.out.println("normál");
		
		int a=8;
		for(int i=0; i<a-1;i++)System.out.println("i: "+i); 
		
		int [] arr1={1,2,3,4};
		int arr2[] = new int [4];
		// int arr2[] = new int [];  Nem fordul
		arr2=arr1;
		System.out.println("harmadik: "+arr2[2]);
		
		// Miért van az exception handling. Mi az előnye?
		//   Lehet új exception-öket létrehozni+ elválasztja a kód erre vonatkozó részét.
		
		// Miért jó a polimorfizmus? Dinamikusabb vagy hatékonyabb lesz tőle a kód?
		// Többször felhasználható , dinamikus
		
		// Ternary operátor. x>=90 akkor 0.5 ha 90>x>80 akkor 0.2
		
		// Ternary operátorhoz egy módszer, ami eldönti, hogy jó-e.
		// Egy belső kérdőjelből kell kiindulni. Le kell írni zárójelezni kell.
		
		// Tervezzél olyan metódust, ami bill=a*const-al tér vissza.
		// és a customer nem tudja módosítani.
		// Sima encapsulation A public-ot és a paraméter nagyobb, mint >0 vizsgálatot kell
		// választani.
		
		// Egy metódus, ami String-el tér vissza. Megkap egy bankszámla számot
		// és az utolsó 4 jegyét adja vissza. A return-t össze kell konkatenálni,
		// vagy valahogy összerakni.
		// Főleg a számolásra megy rá, ill, hogy a String-nek nincs append metódusa.
		// meg nem lehet változtatni.
		
		// this() super() használata többszörös öröklődésnél.
		//  Csak első sorban állhatnak, kétszer nem fordulhatnak elő.
		// pl 1. super();
		//    2. this(); Nem fordul le.
		// Osztályon belül sem tudsz new Constructor(); -t hívni, ha csak 
		// paraméteres constructorod van definiálva. Constructor(String s){}
		// Ekkor főltétlen kell egy Constructor(){} is.
		
		// Példányosított egy osztályt és úgy hivatkozott változókra.Külön package.
		//Különböző hozzáférés. Variable-VariableDriver példa.
		// Csak a public változó látszik másik package-ből. 
		// Magában a protected is látszik, ha static lenne. Ugye a main() is static.
		
		// Ha elrontok egy konstruktort, akkor a rá hivatkozó konstruktor is hibát ad?
		// Nem ad hibát az elrontott construktorra hivatkozás.
		
		// Exception dobás. Mikor kell deklarálni és hol?
		// Mivel checked exception ezért ahol hívják dekralálni kell.
		
		// A arraylist.remove(object) csak az első olyan objectet veszi ki, ha több is van.
		
		// A datum visszatérő formátuma. Parse-al, now-val, ISO formátummal.
		// Mindegyik 2015-01-12 formátumú lesz.
		
		// trim(" ")
		//   Az egy blank line lesz.
		
		 // Több overload-olt main method. Mi lesz vele?
		// Attól még a jó main lefut és azt hajtja végre.
		
		// Ha be-pars-olok csak dátumot, aztán formattálni akarom DateTime-ra akkor 
		// compilation error lesz.
		
		String s3=" ";
		String s4=s3.trim();
		System.out.println("A trimmelt space:"+s4);
		System.out.println("A nem trimmelt space:"+s3); 
		
		final short s=1;
		short s2=2;
		byte b =s;
	    // b=s2; az már nem fordul le.
		// char c=s2; sem fordul le.
		
	}
	public static void main(Object[] args2) {
		System.out.println("obj");
	}
	public static void main(int[] args3) {
		System.out.println("int tömb");
	}
	public static void main(String args4) {
		System.out.println("String");
	}

}
