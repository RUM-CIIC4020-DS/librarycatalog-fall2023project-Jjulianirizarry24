package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import data_structures.ArrayList;
import data_structures.DoublyLinkedList;
import data_structures.SinglyLinkedList;
import interfaces.FilterFunction;
import interfaces.List;


/**
 * LibraryCatalog class
 *
 * @author Jose Irizarry
 */


public class LibraryCatalog {
	List<Book> catalog = new ArrayList<>();
	List<User> users = new ArrayList<>();
	
	// LibraryCatalog Constructor
	public LibraryCatalog() throws IOException {
		catalog = this.getBooksFromFiles();
		users = this.getUsersFromFiles();
		
	}
	/**
	 *  Extracts books from a CSV File
	 *  
	 *  @return list of books 
	 */
	private List<Book> getBooksFromFiles() throws IOException {
		List<Book> booksFromFiles = new ArrayList<>();

		 try {
			 	String bookPath = "./data/catalog.csv";
			 	File file = new File(bookPath);
	            FileReader fileReader = new FileReader(file);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);

	            String line = bufferedReader.readLine();
	            
	            while ((line = bufferedReader.readLine()) != null) {    
	            	
	                String[] fields = line.split(",");
	                
	                	Integer tempId= Integer.parseInt(fields[0]);
	                	String tempTitle = fields[1];
	                	String tempAuthor = fields[2];
	                	String tempGenre = fields[3];
	                	String date = fields[4];
	                	LocalDate tempDate = LocalDate.parse(date);      
	                	String boolVal = fields[5];
	                	
	                	boolean tempCheck = Boolean.parseBoolean(boolVal);
	                	Book temp = new Book(tempId, tempTitle, tempAuthor, tempGenre, tempDate, tempCheck);
	                	booksFromFiles.add(temp);

	            }

	            // Close the BufferedReader when done
	            bufferedReader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		 
	            
		return booksFromFiles;
	}
	
	/**
	 *  Extracts users from a CSV File
	 *  
	 *  @return list of users 
	 */
	
	List<User> getUsersFromFiles() throws IOException {
		List<User> usersFromFiles = new ArrayList<>();
		
		 try {
			 	String userPath = "./data/user.csv";
			 	File file = new File(userPath);
	            FileReader fileReader = new FileReader(file);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);


	            String line = bufferedReader.readLine();
	            while ((line = bufferedReader.readLine()) != null) {
	            	
	               
	            	// Split the CSV line into fields using a comma as the delimiter
	                String[] fields = line.split(",");
	                
	                
	                Integer tempId = Integer.valueOf(fields[0]);
	                String tempName = fields[1];
	                List<Book> tempList = new ArrayList<>();
	                
	                if(fields.length == 3) {
	                	
	                	fields[2] = fields[2].substring(1,fields[2].length()-1);
	                	
	                		String[] ownedBooks  = fields[2].split("\\s");
	                		//System.out.println(ownedBooks);
	                		for(int i = 0;i < ownedBooks.length;i++) {
	                			
	                			Integer currID = Integer.parseInt(ownedBooks[i]);
	                	
	                			for(int j = 0; j < catalog.size();j++) {
	                				if(currID == catalog.get(j).getId()) {
	                					tempList.add(catalog.get(j));
	                				}
	                			}
	                		
	                		}
	                	}
	                
	                
	                User temp = new User(tempId,tempName,tempList);
	                usersFromFiles.add(temp);
	                          
	            }

		
       bufferedReader.close();
   } catch (IOException e) {
       e.printStackTrace();
   }

		return usersFromFiles;
	}
	
	// Return list of books
	public List<Book> getBookCatalog() {
		return this.catalog;
	}
	// Return list of users
	public List<User> getUsers() {
		return this.users;
	}
	
	// HELPER METHOD. Return a string containing all books joined by their id and their toString method
	public String allBooks() {
		String books = ""; 
		for(int i = 0; i < this.catalog.size(); i++) {
			books += this.catalog.get(i).getId() + " " + this.catalog.get(i).toString() + "\n";
		}
		
		return books;
		
	}
	
	// Method that adds book to the list of books
	
	/**
	 *  Method that adds a book to the list of books
	 *  
	 *  @param Title of book
	 *  @param Title of author
	 *  @param Title of genre
	 */
	public void addBook(String title, String author, String genre) {
		LocalDate date = LocalDate.of(2023, 9, 15);
		Book temp = new Book(catalog.size()+1,title,author,genre,date,false);
		this.catalog.add(temp);
	}
	
	/**
	 *  Method that removes a book to the list of books
	 *  
	 *  @param id of book
	 */
	public void removeBook(int id) {
		for(int i = 0; i < catalog.size();i++) {
			int bookIdToRemove = catalog.get(i).getId();
			
			if( bookIdToRemove == id) {
				catalog.remove(i);
				break;
			}
			
		}
		
	}	
	
	/**
	 *  Method that checks if a book is checked out.
	 *  
	 *  If it does not happen to be checked out,
	 *  it's set as checked out and it's last check out
	 *  date is set to the current date (9-15-23)
	 *  
	 *  @param id of book
	 */
	
	public boolean checkOutBook(int id) {
		
		for(int i = 0; i < catalog.size(); i++) {
			
			if(catalog.get(i).getId() == id && !catalog.get(i).isCheckedOut()) {
				catalog.get(i).setLastCheckOut(LocalDate.of(2023, 9, 15));
				catalog.get(i).setCheckedOut(true);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 *  Method that returns a book.
	 *  
	 *  If it happens to be checked out,it's able to
	 *  be returned and method returns true
	 *  otherwise, book cannot be returned and
	 *  returns false
	 *  
	 *  
	 *  
	 *  @param id of book
	 */
	
	
	public boolean returnBook(int id) {
		for(int i = 0; i < catalog.size();i++) {
			if(catalog.get(i).getId() == id && catalog.get(i).isCheckedOut()) {
				catalog.get(i).setCheckedOut(false);
				return true;
			}
			
		}
		return false;
	}
	
	// Method that verifies if a book is available for check out or not
	
	
	/**
	 *  Method that checks if a book is available to be
	 *  picked out
	 *  
	 *  If it does not happen to be checked out, return true
	 *  If it happens to be checked out, it's unavailable and we return false
	 *  @param id of book
	 */
	
	public boolean getBookAvailability(int id) {
		
		for(int i = 0; i < catalog.size(); i++) {
			if(catalog.get(i).getId() == id && !catalog.get(i).isCheckedOut()) {
				return true;
			}
			
		}

		return false;
		
	}
	
	// Counts the books on the catalog that have the same
	// title as the one passed as a parameter
	
	/**
	 *  Method that counts the amount of books with
	 *  the same title as the parameter title
	 * 
	 *  @param title of book
	 */
	
	public int bookCount(String title) {
		int counter = 0;
		
		for(Book b:this.catalog) {
			if(b.getTitle().equals(title)) {
				counter++;
			}
		
		}
		return counter;
	
	}
	
	
	/**
	 *  Method that counts the amount of books with
	 *  the same genre as the parameter title
	 * 
	 *  @param title of book
	 */
	public int genreCount(String genre) {
		int counter = 0;
		
		for(Book b:this.catalog) {
			if(b.getGenre().equals(genre)) {
				counter++;
			}
		
		}
		return counter;
	
	}
	
	
	/**
	 * 
	 *  Method that generates a report of the current amount
	 *  of books and users, sharing information such as the total
	 *  amount that users owe, the amount of books of different genres
	 *  and total amount of books.
	 *  
	 *  Also writes to a file called "report.txt" in the
	 *  report folder.
	 * 
	 */
	
	public void generateReport() throws IOException {
		String output = "\t\t\t\tREPORT\n\n";
		output += "\t\tSUMMARY OF BOOKS\n";
		output += "GENRE\t\t\t\t\t\tAMOUNT\n";
		/*
		 * In this section you will print the amount of books per category.
		 * 
		 * Place in each parenthesis the specified count. 
		 * 
		 * Note this is NOT a fixed number, you have to calculate it because depending on the 
		 * input data we use the numbers will differ.
		 * 
		 * How you do the count is up to you. You can make a method, use the searchForBooks()
		 * function or just do the count right here.
		 */
		
		output += "Adventure\t\t\t\t\t" + (this.genreCount("Adventure")) + "\n";
		output += "Fiction\t\t\t\t\t\t" + (this.genreCount("Fiction")) + "\n";
		output += "Classics\t\t\t\t\t" + (this.genreCount("Classics")) + "\n";
		output += "Mystery\t\t\t\t\t\t" + (this.genreCount("Mystery")) + "\n";
		output += "Science Fiction\t\t\t\t\t" + (this.genreCount("Science Fiction")) + "\n";
		output += "====================================================\n";
		output += "\t\t\tTOTAL AMOUNT OF BOOKS\t" + (this.genreCount("Adventure")+
		this.genreCount("Fiction") + this.genreCount("Classics")+this.genreCount("Mystery") 
		+ this.genreCount("Science Fiction")) + "\n\n";
		
		/*
		 * This part prints the books that are currently checked out
		 */

		output += "\t\t\tBOOKS CURRENTLY CHECKED OUT\n\n";
		/*
		 * Here you will print each individual book that is checked out.
		 * 
		 * Remember that the book has a toString() method. 
		 * Notice if it was implemented correctly it should print the books in the 
		 * expected format.
		 * 
		 * PLACE CODE HERE
		 */
		
		
		// 
		
		
		
		// Here, every book is printed using its toString method
		int counterCheckedOut = 0;
		
		for(int i = 0; i < this.catalog.size(); i++) {
			if(!this.getBookAvailability(catalog.get(i).getId())){
				counterCheckedOut++;
				output += this.catalog.get(i).toString() + "\n";
			}
		}
		//
		
		output += "====================================================\n";
		output += "\t\t\tTOTAL AMOUNT OF BOOKS\t" + (counterCheckedOut) + "\n\n";
		
		
		/*
		 * Here we will print the users the owe money.
		 */
		output += "\n\n\t\tUSERS THAT OWE BOOK FEES\n\n";
		/*
		 * Here you will print all the users that owe money.
		 * The amount will be calculating taking into account 
		 * all the books that have late fees.
		 * 
		 * For example if user Jane Doe has 3 books and 2 of them have late fees.
		 * Say book 1 has $10 in fees and book 2 has $78 in fees.
		 * 
		 * You would print: Jane Doe\t\t\t\t\t$88.00
		 * 
		 * Notice that we place 5 tabs between the name and fee and 
		 * the fee should have 2 decimal places.
		 * 
		 * PLACE CODE HERE!
		 */
		

		
		// Here, every user that owes money is printed 
		float totalDue = 0;
		
		for(int i = 0; i < this.users.size();i++) {
			
			float userDue = 0;
			User curr = users.get(i);
			
			if(!curr.getCheckedOutList().isEmpty()) {
				for(int j = 0; j < curr.getCheckedOutList().size();j++) {
				
					float fee = curr.getCheckedOutList().get(j).calculateFees();
					
					if(fee > 0) {
						userDue += fee;
						
				}
			}
				output += this.users.get(i).getName() + "\t\t\t\t\t" + "$" + String.format("%.2f", userDue) + "\n";
				totalDue += userDue;

			}
		}

		
		output += "====================================================\n";
		output += "\t\t\t\tTOTAL DUE\t$" + (String.format("%.2f", totalDue)) + "\n\n";
		output += "\n\n\n";
		System.out.println(output);// You can use this for testing to see if the report is as expected.
		
		/*
		 * Here we will write to the file.
		 * 
		 * The variable output has all the content we need to write to the report file.
		 * 
		 * PLACE CODE HERE!!
		 */
		
		// Explain TODO
		
		
		// In the following
        BufferedWriter bw = new BufferedWriter(new FileWriter("./report/report.txt"));
        bw.write(output);
        bw.close();
		
		
		
		
		
	}
	
	/*
	 * BONUS Methods
	 * 
	 * You are not required to implement these, but they can be useful for
	 * other parts of the project.
	 */
	
	// Implemented searchForBook method. Method returns a
	// book filtered with a specified value.
	public List<Book> searchForBook(FilterFunction<Book> func) {
		List<Book> newBooks = new ArrayList<>();
		
		for (Book b:this.getBookCatalog()) {
			if(func.filter(b)) {
				newBooks.add(b);
		    }
		}	
		return newBooks;
	}
	
	// Implemented searchForUsers method. Method returns a
	// user filtered with a specified value.
	public List<User> searchForUsers(FilterFunction<User> func) {
		 List<User> newBooks = new ArrayList<>();
		 
		    for (User currUser : this.getUsers()) {
		        if(func.filter(currUser)) {
		        	newBooks.add(currUser);
		        }
		    }
		    return newBooks;
	}
	
}