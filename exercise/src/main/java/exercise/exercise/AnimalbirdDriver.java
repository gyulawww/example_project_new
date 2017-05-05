package exercise.exercise;

public class AnimalbirdDriver {
   static Animal a= new Bird();
   static Animal b= new Animal();
   static float f=1;
   public static void main(String[] args) {
	System.out.println(a instanceof Fly);
	// Itt az határozza meg az instanceof-ot hogy milyen class-al példányosítom
	System.out.println(b instanceof Fly);
	
}
}
