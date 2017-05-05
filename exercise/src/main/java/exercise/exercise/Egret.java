package exercise.exercise;

public class Egret {
	
		private String color;
		public Egret() {
		this("white");
		System.out.println("Itt meg white");
		}
		public Egret(String color) {
		color = color;
		System.out.println("Itt visszairja.");
		}
		public static void main(String[] args) {
		Egret e = new Egret();
		System.out.println("Color:" + e.color);
		}
}


