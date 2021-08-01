//import javax.swing.border.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.*;
//import java.io.*;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		
        Scanner reader = new Scanner(System.in);
        int choice = 0;
        
        try (BufferedReader read = new BufferedReader(new FileReader("Output.src"))){
        	 do {
             	System.out.println("------->JAC 444 Assignment 4<------");
                 System.out.println("------->Task 1 ... <-------");
                 System.out.println("Select Option");
                 System.out.println("1. Student Data Entry.");
                 System.out.println("2. Displaying Student Data.\n");
                 System.out.println("0. Exit.");
                 
                 try{
                	 System.out.println("\nSelect 1 of the above choices: ");
                     choice = reader.nextInt();   
                 }
                 catch(InputMismatchException e) {
                	 System.out.println("***Error: " + e + " ***\n");
                 }

                 if(choice == 1) {
                     GetStudentInfo.getStudentInfo();     
                  }
                  else if(choice == 2) {
                     ReadStudentInfo.read();
                  }
                  else if(choice == 0) {
                 	 System.out.println("***Program Exited! Thank you!***");
                  }
          	    
             }while(choice != 0);
                
             reader.close();
 	
        }catch(IOException e){
        	System.out.println(e);
        }
     }
}
