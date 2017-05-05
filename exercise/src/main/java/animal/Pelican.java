package animal;

public class Pelican extends Bird {
protected void fly(){
	System.out.println("Pelican is flying");
}
public static void main(String[] args) {
	Pelican bird= new Pelican();  //Bird bird-el már nem engedi meghívni a fly-t.
	bird.fly();
}
}
