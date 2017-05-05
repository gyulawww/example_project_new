package exercise.exercise;

public class DoubleFloat {
	public static void main(String [] args){
	float f= 12.0f;
	double d=f++;
	long l=13;
	d--;
	d -=0.3;
	System.out.print((f==d)+" d: "+d+" f: "+f);
	System.out.print((d==l)+" l: "+l);
	System.out.println("  "+(f==l));
	float g=0.0012f;
	}
}
