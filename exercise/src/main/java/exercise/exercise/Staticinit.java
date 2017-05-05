package exercise.exercise;

public class Staticinit {
	int i=j;
	static int j=4;
	public static void main(String[] args) {
		j=8;
		System.out.println(new Staticinit().i+j);
		int j=16;
		System.out.println(Boolean.valueOf(true));
		System.out.println(Boolean.parseBoolean("yes"));
		System.out.println(Boolean.getBoolean("true"));
	}	

}
