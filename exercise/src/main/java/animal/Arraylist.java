package animal;

import java.util.ArrayList;

public class Arraylist {
public static void main(String[] args) {
	ArrayList array= new ArrayList();
	array.add("Ablak");
	array.add("Baba");
	array.add("Cukor");
	array.add("Baba");
	array.add("Baba");
	array.remove("Baba");  // A remove csak az elsőt veszi ki.
	System.out.println(array);
	ArrayList<Integer> array2= new ArrayList();
	array2.add(111);
	//ArrayList<Double> array2= new ArrayList();
	// array2.add(111);  De Double-be nem tudok.
    Byte b1=127;
    Byte b2=126;
	Integer i1=122;
	Integer i2=122;
	Short s=127;
	short ss=127;
	if(b1==b2)System.out.println("első: true");
	if(i1==i2)System.out.println("második: true");
	if(b1==ss)System.out.println("harmadikdik: true");
}
}
