package main;

import java.io.IOException;

public class TestMain {

	/*
	 * You can use this method for testing. If you run it as is 
	 * you should be able to generate the same report as report/expected_report.txt
	 */
	public static void main(String[] args) {

		try {
			
			LibraryCatalog lc = new LibraryCatalog();
			lc.generateReport();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
