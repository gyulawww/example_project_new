package CucumberExample.CucumberExample.Salary;

public class Employee {
	private int id;
	private String user;
	private float salary;
 
	public Employee(int id, String user, float salary){
		this.id=id;
		this.user=user;
		this.salary=salary;
	}
	
	public float getSalary (){
		return this.salary;
	}
	public int getId(){
		return this.id;
	}
	public String getUser(){
		return this.user;
	}
	public void setSalary(float salary){
		this.salary=salary;
	}
	// constructor, getter, setter ommitted
}
