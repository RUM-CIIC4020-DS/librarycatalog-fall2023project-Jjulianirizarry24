package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import interfaces.List;
/*
 
 
Create a class called LibraryGUI in the main package and implement a user interface for the 
project that can do the following:
• Can add books to the library.
• Can remove books from the library.
• Can Display the List of books currently in the library.
  
 * */
public class LibraryGUI implements ActionListener{
    LibraryCatalog lc;
	JButton buttonAdd;
	JTextField textFieldAdd;
	JButton buttonRemove;
	JTextField textFieldRemove;
	JTextArea books;


    

    public LibraryGUI() {
        try {
            lc = new LibraryCatalog();
            
            
            Frame mainFrame = new Frame();
            mainFrame.setVisible(true);
            
            buttonAdd = new JButton("Add");
            buttonAdd.addActionListener(this);
            textFieldAdd = new JTextField();
            textFieldAdd.setPreferredSize(new Dimension(200,40));
            buttonRemove = new JButton("Remove");
            buttonRemove.addActionListener(this);
            textFieldRemove = new JTextField();
            textFieldRemove.setPreferredSize(new Dimension(200,40));
            books = new JTextArea();
            
            books.setPreferredSize(new Dimension(400,1200));
            books.setRows(lc.getBookCatalog().size()*2);  // Set the number of rows
            books.setColumns(3);  // Set the number of columns
            books.setLineWrap(true);
            books.setText(lc.allBooks());
            //textFieldBooks.setText("hey");
            //textFieldBooks.setText("First line\nSecond line");
            //JScrollPane scrollPane = new JScrollPane(books);

           
            mainFrame.add(buttonAdd);
            mainFrame.add(textFieldAdd);
            mainFrame.add(buttonRemove);
            mainFrame.add(textFieldRemove);
            mainFrame.add(books);
            //mainFrame.add(scrollPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
        


    public static void main(String[] args) {
        LibraryGUI libraryUI = new LibraryGUI();

    }





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == buttonAdd) {
			String[] input = this.textFieldAdd.getText().split(",");
			//USER MUST ENTER:
				//Title,Author,Genre
				// THIS AND THIS FORMAT ONLY

			lc.addBook(input[0], input[1], input[2]);
			books.setRows(books.getRows()+2);
            books.setText(lc.allBooks());
		}
		if(e.getSource() == buttonRemove) {
			String input = this.textFieldRemove.getText();
			System.out.print(input);
			//USER MUST ENTER:
				//Title,Author,Genre
				// THIS AND THIS FORMAT ONLY

			lc.removeBook(Integer.parseInt(input));
			books.setRows(books.getRows()-2);
            books.setText(lc.allBooks());
		}
		
	}
















}
