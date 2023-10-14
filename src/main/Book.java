package main;

import java.time.LocalDate;

/**
 * Book class
 *
 * @author Jose Irizarry
 */

public class Book {
	

	int id;
	String title;
	String author;
	String genre;
	LocalDate date;
	Boolean checkOut;
	
	// Default Constructor
    public Book(){}
    
    // Book Constructor
	public Book(int id, String title, String author, String genre, LocalDate date, Boolean checkOut){
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.date = date;
		this.checkOut = checkOut;
	}
	

	// Returns ID
	public int getId() {
		return id;
	}
	// Updates ID value
	public void setId(int id) {
		this.id = id;
		
	}
	
	// Returns Title
	public String getTitle() {
		return this.title;
	}
	// Update Title Value
	public void setTitle(String title) {
		this.title=title;
	}
	
	// Returns author
	public String getAuthor() {
		return this.author;
	}
	
	// Updates author
	public void setAuthor(String author) {
		this.author=author;
	}
	
	// Returns genre
	public String getGenre() {
		return this.genre;
	}
	
	// Updates genre
	public void setGenre(String genre) {
		this.genre=genre;
		
	}
	
	// Returns the last check out date
	public LocalDate getLastCheckOut() {
		return this.date;
	}
	
	// Updates date
	public void setLastCheckOut(LocalDate lastCheckOut) {
		this.date=lastCheckOut;
	}
	
	// Returns if the book is checked out or not
	public boolean isCheckedOut() {
		return this.checkOut;
	}
	
	// Updates checked out value
	public void setCheckedOut(boolean checkedOut) {
		this.checkOut=checkedOut;
	}
	
	

	
	@Override
	public String toString() {
		/*
		 * This is supposed to follow the format
		 * 
		 * {TITLE} BY {AUTHOR}
		 * 
		 * ALL MUST BE UPPERCASE.
		 */
		return this.title.toUpperCase() + " BY " + this.author.toUpperCase();
	}
	public float calculateFees() {
		/*
		 * fee (if applicable) = base fee + 1.5 per additional day
		 *
		 *
		 *The fee is calculated as follows, if the book has been checked out for 31 days or more then the
	     base fee is $10. Then an added $1.50 is owed per day passed 31. To keep it simple, assume
         today's date is September 15, 2023, for all calculations in the project.
		 *
		 *
		 */


        LocalDate startDate = this.getLastCheckOut(); // Start date
        LocalDate endDate = LocalDate.of(2023, 9, 15);  // End date (inclusive)
        int counter = 0;
        float fee = 0;
        
        while(!startDate.equals(endDate)) {
        	if(counter == 30) {
        		fee += 10;
        	}
        	else if(counter > 30){
        		fee += 1.50;
        	}
        	
        	startDate = startDate.plusDays(1);
        	counter++;
        }


		
		
		return fee;
	}
}