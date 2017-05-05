package exercise.exercise;

public class Grasshopper {
	
	   public Grasshopper(String n) {
	     name = n;
		}
		public static void main(String[] args) {
		Grasshopper one = new Grasshopper("g1");
		Grasshopper two = new Grasshopper("g2");
		one = two;
		System.out.println("elso");
		two = null;
		System.out.println("masodik");
		one = null;
		}
		private String name;
		}

