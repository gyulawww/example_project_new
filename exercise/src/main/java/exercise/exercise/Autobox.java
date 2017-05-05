package exercise.exercise;

public class Autobox {
	public void szamol(int n){
		System.out.println("int "+n);
	}
/*	public void szamol(Integer n){
		System.out.println("Integer "+n);
	} */
 public static void main(String[] args) {
	Integer n =new Integer(4);
	new Autobox().szamol(n);
}
}
