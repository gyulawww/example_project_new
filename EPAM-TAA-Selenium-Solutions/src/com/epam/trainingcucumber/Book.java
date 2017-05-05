package com.epam.trainingcucumber;
import java.util.Date;

public class Book {
	private String title;
	private String author;
	private Date published;
	
   public Book(String title, String author, Date published){
	   this.published=published;
	   this.title=title;
	   this.author= author;
   }
	public Date getPublished(){
	  return this.published;
  }
	public String getTitle(){
		  return this.title;
	  }
	public String getAuthor(){
		  return this.title;
	  }
	  
	// constructors, getter, setter ommitted

}
