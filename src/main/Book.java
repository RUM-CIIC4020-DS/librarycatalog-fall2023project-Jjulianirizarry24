package main;

import java.time.LocalDate;

public class Book {
	
	int id;
	String title;
	String author;
	String genre;
	LocalDate date;
	Boolean checkOut;
	
	
    public Book(){}
    
	public Book(int id, String title, String author, String genre, LocalDate date, Boolean checkOut){
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.date = date;
		this.checkOut = checkOut;
	}
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author=author;
		
	}
	public String getGenre() {
		return this.genre;
	}
	public void setGenre(String genre) {
		this.genre=genre;
		
	}
	public LocalDate getLastCheckOut() {
		return this.date;
	}
	public void setLastCheckOut(LocalDate lastCheckOut) {
		this.date=lastCheckOut;
	}
	public boolean isCheckedOut() {
		return this.checkOut;
	}
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
		
		//EDGECASE!
			// What if start date > end date? TODO
			

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