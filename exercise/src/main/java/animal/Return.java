package animal;

public class Return {
   public String kartyaszam="1234-5678-1234-5678";
   public String szamla(String s){
	   StringBuilder sb=new StringBuilder(s);
	   String s1= "xxxx-xxxx-xxxx-";
	   //return s1+s.substring(15, 19);  
	   //return s1+sb.substring(15, 19).toString();
	   return s1+sb.substring(15, 19);   
	   // return sb.toString();          // Mindegyik jó.
   }
   public static void main(String[] args) {
	  Return ref=new Return();
	  System.out.println(ref.szamla(ref.kartyaszam));
}
}
