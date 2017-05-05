package ComparableComparator.ComparableComparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FruitDriver {
	public static void main(String [] args){
		
        Fruit[] fruits = new Fruit[4];
		
		Fruit pineappale = new Fruit("Pineapple", "Yellow",70); 
		Fruit apple = new Fruit("Apple", "Red",100); 
		Fruit orange = new Fruit("Orange", "Orange",80); 
		Fruit banana = new Fruit("Banana", "Yellow",90); 
		
		fruits[0]=pineappale;
		fruits[1]=apple;
		fruits[2]=orange;
		fruits[3]=banana;
		
		Arrays.sort(fruits);
		System.out.println("Rendezzuk memmyiség szerint a gyumolcsoket");
		int i=0;
		for(Fruit temp: fruits){
		   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
			", Quantity : " + temp.getQuantity());
		}
		
		System.out.println();
		System.out.println("Rendezzuk most név szerint a gyumolcsoket");
		Arrays.sort(fruits,new FruitNameComparator());
		i=0;
		for(Fruit temp: fruits){
			   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
				", Quantity : " + temp.getQuantity());
			}
		
		System.out.println();
		// Anonymous comparator
		Arrays.sort(fruits, new Comparator<Fruit>(){

               public int compare(Fruit o1, Fruit o2) {  
                   return o1.getFruitDesc().compareTo(o2.getFruitDesc()); 
               } 

		});
		i=0;
		for(Fruit temp: fruits){
			   System.out.println("fruits " + ++i + " : " + temp.getFruitName() + 
				", Description : " + temp.getFruitDesc());
			}
	}

}
