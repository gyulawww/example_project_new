package animal;

import com.github.fge.jsonschema.main.cli.Main;

class Emlos{
	public Emlos(String s1){
		System.out.println(s1);
	}
}
class Ragcsalo extends Emlos{
//	public Ragcsalo(){  Csak ez lesz hibás
// }
	public Ragcsalo(String s2){
		super("hamm");
	}
}
public class Eger extends Ragcsalo {
    public Eger(){
    	super("valami");
      }
    public static void main(String[] args){
    	new Eger();  //Tanulságos a printoutja
    }      
}

