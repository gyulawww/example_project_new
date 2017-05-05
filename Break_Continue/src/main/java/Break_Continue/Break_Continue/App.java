package Break_Continue.Break_Continue;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	for(int i=0; i<10; ++i){
    	if (i==5)continue;	
    	if (i==8)break;
        System.out.println( "Hello World!"+i );
    	 }
    	int k=5;
    	System.out.println("A k értéke: "+k);
    	System.out.println("Postfix-el: "+ k++);
    	System.out.println("Prefix-el: " + ++k);
    	
    	Kiir(k);
    	int[][] tomb2= new int[10][10];
    	String[] tomb3= new String[]{"alma","korte","banan","citrom","narancs"};
    	for(String tmp: tomb3)
    	{
    		System.out.println(tmp);
    	}
    	
    	List<String> list= new ArrayList<String>(3);
    	list.add("alma");
    	
    	int count=0;
    	int[][] arr = new int[3][4];
    	for(int i=0; i<arr.length; i++)
    	    for(int j=0; j<arr[i].length; j++)
    	        if(j<2) count++;
    	System.out.println(count);
    	
    }
    static void Kiir(int szam)
    {
		System.out.println(szam);
    }
   
}
