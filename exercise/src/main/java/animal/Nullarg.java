package animal;

public class Nullarg {
public static void main(String[] args) {
	       try {      System.out.println(args[args.length-1]); } // Nem ad exception-t.
	       catch (ArrayIndexOutOfBoundsException e) {    }      // mert itt elkapja.
	}
}
