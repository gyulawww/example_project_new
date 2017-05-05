package exercise.exercise;

public class Constructor {
	public String seq="a";
    public Constructor(){
    	this("abc");
    	seq +="d";
    } 
    public Constructor (String st){
    	seq +="z";
    }
    public static void main(String[] args){
    	Constructor c= new Constructor();
    	System.out.println(c.seq);
    }
}
