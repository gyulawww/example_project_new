package exercise.exercise;

public class GetChars {
public static void main(String[] args) {
	StringBuilder sb= new StringBuilder("Whizlab");
	char[] ch= new char[4];
	sb.getChars(1, 5, ch, 1);
	for(char c:ch)System.out.println(c);
	for(int i=0;i<5;i++);
}
}
