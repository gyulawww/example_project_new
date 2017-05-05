package exercise.exercise;

public class Arrayparam {
public static void main(String[] args) {
	int[] ary={1,2,3};
	double d=1.1D;
	boolean b=true;
	Boolean b2=new Boolean(true);
	change(ary[2]);
	change(ary);
	System.out.println("ary 1: "+ary[1]);
	System.out.println("ary 2: "+ary[2]);
	System.out.println(ary[1]+ary[2]);
	System.out.println(b2);
}
public static void change(int x) {
	x=1;
}
public static void change(int[] x) {
	x[1]=0;
}
}
