package exercise.exercise;

public class StaticInit2 {
	static Integer y;
public static void main (String[] args) {
	int x=10;
	if(x++>10&&y++==1)y+=10;
	// if(x++>10 & y++==1)y+=10;
	System.out.println(y);

}
}
