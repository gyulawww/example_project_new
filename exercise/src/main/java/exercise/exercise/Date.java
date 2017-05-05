package exercise.exercise;

import java.time.LocalDate;

public class Date {
	public static void main(String[] args) {
		LocalDate l= LocalDate.of(2014, 1, 31).plusMonths(1);
		LocalDate l1=LocalDate.parse("2016-02-26");
		
		System.out.println(l);
		System.out.println(l1);
	
	}

}
