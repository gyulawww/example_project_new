package Lambda.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ReferenceToInstanceMethodAOPT {
	 
    /**
     * @param args the command line arguments
     */
 
     private static class Person {
 
            private final String name;
            private final Integer age;
 
 
            public Person(String name, Integer age) {
                this.name = name;
                this.age = age;
 
            }
 
            public String getName() {
                return name;
            }
 
            public Integer getAge() {
                return age;
            }
 
 
        }
    public static void main(String[] args) {
        // TODO code application logic here
        List persons = new ArrayList();
            persons.add(new Person("Albert", 80));
            persons.add(new Person("Ben", 15));
            persons.add(new Person("Charlote", 20));
            persons.add(new Person("Dean", 6));
            persons.add(new Person("Elaine", 17));
 
 
            List allAges = ReferenceToInstanceMethodAOPT.listAllAges(persons, Person::getAge);
            System.out.println("Printing out all ages \n"+allAges);
            List allNames = ReferenceToInstanceMethodAOPT.listAllNames(persons, Person::getName);
            System.out.println("Printing out all names \n"+allNames);
    }
 
 
    private static List listAllAges(List person, Function < Person, Integer > f){
        List result = new ArrayList();
        person.forEach(x -> result.add(f.apply((Person)x)));
        return result;
        }
    private static List listAllNames(List person, Function < Person, String > f){   
        	List result = new ArrayList();
            person.forEach(x -> result.add(f.apply((Person)x)));
            return result;
        }
}
