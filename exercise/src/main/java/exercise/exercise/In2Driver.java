package exercise.exercise;

public class In2Driver implements In2 {
public static void main(String[] args) {
	System.out.println(In2.print());
	In1.print();
	
	short s=10;
	s +=10;
	// s=s+1;   // Will compilation error.
	Character.valueOf('c'); //Csak karaktert adhatok bele.
	System.out.println('a');
	byte i=1, j=1;
	while(i==3&& j<5){
		System.out.println(i);
		System.out.println('a');
	}
	try{
		System.out.println('a');
	}catch(NullPointerException|ClassCastException e){
		
	}
	StringBuilder sb=new StringBuilder("1");
	sb.insert(0, i);
	System.out.println(sb);
} 
}
