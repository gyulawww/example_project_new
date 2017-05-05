package animal;
import java.lang.*;
class NoMoreException extends Exception{}
public class Exception1 {
public static void ex() throws Exception{
	throw new Exception();
}
public static void main(String[] args) throws Exception { //Kell, mert ez checked exception
	// ex(); // Az ex() majd dobni fogja.
	ex2();
}
public static void ex2(){
	try{ 
	ex();               // Vagy ha az ex()-et használja akkor le kell kezelni try-catch-ben.
	}catch (Exception e){
		System.out.println("Megjött az exception");
	}
}
}
