package animal;

import com.github.fge.jsonschema.main.cli.Main;

public class Operators {
	public static int operators(){
		int x1 = -4;
		int x2 = x1--;
		int x3 = ++x2;
		if(x2 > x3){
			--x3;
			}else{
				x1++;
			}
		System.out.println("x1:"+ x1);
		System.out.println("x2:"+ x2);
		System.out.println("x3:"+ x3);
				return x1 + x2 + x3;
				}
		public static void main(String[] args){
			System.out.println(operators());
		//	System.out.println(true + null);   true+null nem megy true+false sem.
		}
		
}
