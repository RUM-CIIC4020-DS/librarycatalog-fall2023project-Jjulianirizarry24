package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Frame extends JFrame {
//	JButton buttonAdd;
//	JTextField textFieldAdd;
		Frame(){
			this.setLayout(new FlowLayout());;
			this.setTitle("Library User Interface");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit app
			this.setSize(1280,720); 
			//this.setVisible(false); //Frame visibility
			this.getContentPane().setBackground(new Color(54, 112, 85));

		}

		
		
		
}
