package main;

import interfaces.List;

/**
 * User class
 *
 * @author Jose Irizarry
 */


public class User {
	int id;
	String name;
	List<Book> checkedOutList;
	
	//Default Constructor
	public User(){}
	
	//User Constructor
	public User(int id, String name, List<Book> checkedOutList) {
		this.id = id;
		this.name = name;
		this.checkedOutList = checkedOutList;
	}
	
	
	
	// Return ID
	public int getId() {
		return this.id;
	}
	
	// Set ID
	public void setId(int id) {
		this.id = id;
		
	}

	// Return ID
	public String getName() {
		return this.name;
	}

	// Set ID
	public void setName(String name) {
		this.name = name;
		
	}
	
	// Return the list
	public List<Book> getCheckedOutList() {
		return this.checkedOutList;
	}

	
	public void setCheckedOutList(List<Book> checkedOutList) {
		this.checkedOutList = checkedOutList;
	
	}
	
}