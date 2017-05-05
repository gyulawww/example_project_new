package animal;

public class Marsupial {
    static int m=10;
	public boolean isBiped()/*throws Exception*/ {
		return false;
		}
	public static boolean isStatic() {
		return false;
		}
  private final void isPrivate(){  // Éppen lehet final is, mert private, és nem írja fölül.
		System.out.println("Private Marsupial.");
	}
		public void getMarsupialDescription() {
		System.out.println("Marsupial walks on two legs: "+isBiped());
		}
}
