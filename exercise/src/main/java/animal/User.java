package animal;

public class User {
	  Bandwidth bw=new Bandwidth();
	    public void consume(int bytesUsed){
	    	bw.addUsage(bytesUsed);
	    }
}
