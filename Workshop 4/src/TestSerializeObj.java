import java.util.*;
import java.io.*;

public class TestSerializeObj {
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("There are no files in arguments");
		} else {
			Scanner reader = new Scanner(System.in);
	        System.out.println("------->JAC 444 Assignment 4<------");
	        System.out.println("------->Task 1 ... <-------");
	        
	        int exit = 1;
	        do {

		        System.out.println("\nSelect Option\n");
		        System.out.println("1. Student Data Entry.");
		        System.out.println("2. Displaying Student Data.\n");
		        
		        int choice = 0;
		        choice = reader.nextInt(); 
		        
		        if(choice == 1) {
		        	AddStudent(args[0]);
		        }
		        else if(choice == 2) {
		        	ReadStudent(args[0]);
		        }
	        }while(exit != 0);
	        
			reader.close();
		}
	}

	

	public static void ReadStudent(String fileName) {
		Read fileRead;
		File file;
		try {
			file = new File(fileName);
			fileRead = new Read(file);
			fileRead.deserializeObject();
		}catch(ReadException message) {
			System.out.println(message.getMessage());
		}catch(FileNotFoundException message) {
			System.out.println(message.getMessage());
		}catch(ClassNotFoundException message) {
			System.out.println(message.getMessage());
		}catch(	StreamCorruptedException message) {
			System.out.println(message.getMessage());
		}catch(IOException message) {
			System.out.println(message.getMessage());
		}
	}



	public static void printStudentInfo(Student obj) {		
		System.out.println("\nStudent ID: " + obj.getStdID());
		System.out.println("Full Name: " + obj.getFirstName() + " " + obj.getLastName());
		System.out.printf("Courses: ");
		for (String i : obj.getCourses()) {
			System.out.printf("%s ", i);
		}
		System.out.println();
	}
}
