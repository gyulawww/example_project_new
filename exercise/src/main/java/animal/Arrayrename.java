package animal;

public class Arrayrename {
	public static void main(String[] args) {
		int[] arr1= new int[]{5,6};
		int[] arr2= new int[]{1,2,3,4};
		arr1=arr2;   //Simán át lehet nevezni hiába különböző méretű.
		int i= arr1[3];
		System.out.println(i);
		
	}	

}
