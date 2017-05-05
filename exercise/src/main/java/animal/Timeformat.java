package animal;

import java.time.*;

public class Timeformat {
public static void main(String[] args) {
	LocalDate ldt=LocalDate.now();
	System.out.println(ldt);
	LocalDate ldt2=LocalDate.of(2016, 6, 12);
	System.out.println(ldt2);
	LocalDate ldt3=LocalDate.parse("2016-06-12");
	System.out.println(ldt3);
	LocalDateTime ldt4=LocalDateTime.parse("2016-06-12T11:11:02"); 
	ldt4.plusDays(2);  //Ezt nem adja hozzá, mivel ldt4 nem változtatható.
	System.out.println(ldt4);
	LocalDateTime ldt5=LocalDateTime.parse("2016,06,12,11,11"); //Runtime exception
	System.out.println(ldt5);
}
}
