package animal;

public class Bandwidth {
	private int totalUsage;
	private double totalBill;
	private double costPerByte;
	public void addUsage(int bytesUsed){ //public kell legyen, hogy látszódjon a másik osztályból
		if (bytesUsed>0){                // bytesUsed-nak ne adhassanak negatívot.
			totalUsage=totalUsage+bytesUsed;
			totalBill=totalUsage*costPerByte;
		}
	}

	
}
