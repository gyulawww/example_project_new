package exercise.exercise;

public class Egyenlo {
	public static void main( String[] args){
		Integer i1=100,i2=128,i3=128,i4=100;
		
		if((i1==i4)^(i2==i3)){
			System.out.println(i1);
		}
		else if ((i1==i4)|(i2==i3)){
			System.out.println(i3);
		}
		else{
			System.out.println(i3+i4);
		}
	}
	// Ha Integer-t vagy Short wrapper class-t hasonlítunk össze
	// az csak -128 és 127 között működik ==-vel.

}
