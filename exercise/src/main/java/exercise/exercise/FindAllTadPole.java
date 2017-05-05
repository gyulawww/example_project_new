package exercise.exercise;

import java.util.ArrayList;
import java.util.List;

public class FindAllTadPole {
	public interface CanSwim {}
	public class Amphibian implements CanSwim {}
	class Tadpole extends Amphibian {}
	
	public static void main(String[] args) {
	List<Tadpole> tadpoles = new ArrayList<Tadpole>();
	for(Amphibian amphibian : tadpoles) {
		CanSwim tadpole = amphibian;
	}
	}
	}

