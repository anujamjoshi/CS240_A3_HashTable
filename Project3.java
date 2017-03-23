package edu.csupomona.cs.cs240.A3Cs240;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class Project3 {
	
	public static void main(String[] args) throws IOException {
	    if (args.length < 1) {
	        System.out.println("Error: Directory name is missing");
	        System.out.println("Usage: java numEntryProcess directory_name");
	        return;
	    }
	    File directory = new File(args[0]); // args[0] contains the directory name
	    File[] files = directory.listFiles(); // get the list of files from that directory

	    Scanner input;
	    HashEntryTable table = new HashEntryTable();

	    // process the arguments stores in args
	    for (int i = 0; i < files.length; i++) {
	      input = new Scanner(files[i]);
	      // no error checking done here, add your own
	      String name;
	      Double numEntry = 0.0;
	     
	      while (input.hasNext())
	      {
	      	name = "";
	      	while (!input.hasNextDouble()){
	      		name += input.next() + " ";
	      	}
	      	if (input.hasNextDouble()){
	      	numEntry = new Double(input.next());
	      	}
	      	System.out.println("Name: " + name + " Score: " + numEntry);
	      	//fills the table with the entries 
	      	table.put(name, numEntry);
	      }
	    }
	    System.out.println("All entries have been processed");
//		// TESTING TO SEE IF THE INPUT AND OUTPUT WORKS WITHOUT FILLING IN THE DATA FROM THE FILES 
//		table.put("Marc Bulger", 85.5);
//		table.put("Daunte Culpepper", 119);
//		table.put("Marc Bulger", 95.5);
//		table.put("Daunte Culpepper", 129);
//		table.put("Anuja", 2.0);
//		table.put("Anuja", 1.0);
//		System.out.println("Anuja \t Avg" + table.get("Anuja")/table.getNumScores("Anuja") + "#Scores:"+table.getNumScores("Anuja"));
//		System.out.println("Marc Bulger\t Avg" + table.get("Marc Bulger")/table.getNumScores("Marc Bulger") + "#Scores:"+table.getNumScores("Marc Bulger"));
//		System.out.println("Daunte Culpepper \t Avg" + table.get("Daunte Culpepper")/table.getNumScores("Daunte Culpepper") + "#Scores:"+table.getNumScores("Daunte Culpepper"));
//		if (table.get("DonaldDuck")!=-1){
//		System.out.println("Donald Duck \t Avg" + table.get("Donald Duck")/table.getNumScores("Donald Duck") + "#Scores:"+table.getNumScores("Donald Duck"));
//		}
//		else 
//			System.out.println("Donald Duck is invalid");
//		
//		// END TESTING 
		
		
		// ask the user to enter the name and returns the name the number of numEntrys and the average 
	    // if it is not found return that name is not found 
	    System.out.println("enter the name you want to check! (REMEMBER TO PUT A SPACE AFTER)");
	   
	   
	    Scanner scan = new Scanner(System.in);
	    String keyinputname=scan.nextLine();
	    while (!keyinputname.equals("QUIT")){
	    	double totalScore=table.get(keyinputname);
	    	if (totalScore != -1.0){
	    	int numEntrys = table.getNumScores(keyinputname);
	    	System.out.println(keyinputname + "Avg" + totalScore/numEntrys + "#Scores:"+numEntrys);
	    	}
	    	else {
	    		System.out.println(keyinputname+"Not Found");
	    	}
	    	System.out.println("Enter name you want to check (REMEMBER TO PUT A SPACE AFTER) \n or type 'QUIT' to exit");
	    	keyinputname=scan.nextLine();
	    }
	   scan.close();
	  }

}
