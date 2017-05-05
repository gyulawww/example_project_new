package exercise.exercise;

import java.util.ArrayList;
import java.lang.System;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static java.lang.System.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	out.println("haho");
    	Character ch=new Character('a');
    	int [] uj= {1,2,3,4,5,6};
    	System.out.printf("%18s%8s\n","Position","Value" );
    	for(int i =0;i<uj.length;i++){
        System.out.printf("%18d%8d\n", i,uj[i] );
    	} 
    	System.out.println(args[0]);
    	System.out.println(args[1]);
    	System.out.println(017);
    	System.out.println(0x17);
    	System.out.println(0b11);
    	System.out.println(1_000_000);
    	// De az elejére, végére, tizedespont elé-mögé nem lehet tenni aláhúzást.
    
    	String s1 = "java";
    	StringBuilder s2 = new StringBuilder("java");
        if (s2.equals(s1))
    	System.out.print("1");
    	if (s1.equals(s2)){
    	System.out.print("2");
    	}else System.out.println("Not equals");
    	
    	List<String> one = new ArrayList<String>();
    	one.add("abc");
    	List<String> two = new ArrayList<>();
    	two.add("abc");
    	if (one == two)
    	System.out.println("A");
    	else if (one.equals(two))
    	System.out.println("B");
    	else
    	System.out.println("C");
    	
    	int[] random = { 6, -4, 2, 12, 0, -10, 5 };
    	int x = 12;
    	int y = Arrays.binarySearch(random, x);
    	System.out.println(y);
    	
    	String valami= "abcda";
    	String ujabb= valami.replace('a', 'A');
    	valami.replace('a', 'A');
    	valami.concat("123");
    	System.out.println("ujabb: "+ujabb);
    	System.out.println("valami:"+valami);
    	valami= valami.replace('a', 'A');
    	System.out.println("valami:"+valami);
    	valami= valami.concat("123");
    	System.out.println("valami:"+valami);
    	
    	float jajj= 1.23f;
    	double jajj2= 1.23;
    	
    	String[] names= new String[3];
    	for(String name:names){
    		System.out.println("names:"+name);
    	}
    	String name1="animal";
    	String res=name1.replace('a','A');
    	System.out.println(res);
    	
    	//List<String> list= new ArrayList<String>{"a","B","d","c"};
    	//Collections.sort(list);
    String [] gr = new String []{"a","b"};
     String s="alma";
     int a=s.indexOf("z");
     System.out.println(a);
     char c= 'a';
     char b= c++;
     System.out.println(b);
     if(c<=a){   	 
     }
     final int trukk=1;
     // trukk=1;  Igy mar nem megy.
     switch (3){
     case 4: case 2:
     case trukk: 
     case 5: System.out.println("5-os case");     
     break;
     default: System.out.println("default");
     }
     
     String string= "ja";
     StringBuilder sb= new StringBuilder("ja");
     sb.setLength(1);
     System.out.println("stringbuilder "+sb);
     
     if(string.equals(sb))System.out.println("equals megy");
     for(int i=0;i<=10;i++)
    	 System.out.println("sor "+i);
     
    
     
     Double number= Double.valueOf("120D");
     Float n2= Float.valueOf("120f");
     Long n3= Long.valueOf("1000"); // A longnál nem tehetek mögé l-et
     Long n4= 1000L;
     System.out.println("A Double érték: "+ number);
     System.out.println("A Float érték: "+ n2);
     System.out.println("A Long érték: "+ n3);
     
     int f=0;
     do{ 
    	  f=0;
     }while(f<5);
   
     z:for(int i=0;i<5;i++){ 
    	
    	 if (x== 1){
    		 System.out.println(x);
    	     continue;
    	 }
    	 if (x== 3)break z;
    	 System.out.println(x);
     }
     
     
    }
    public interface Herbivore {
		int amount = 10;
		public  void eatGrass();
		public static int chew() {
		return 13;
		}
		}
}
