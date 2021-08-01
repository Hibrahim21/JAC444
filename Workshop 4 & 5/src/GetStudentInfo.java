import java.io.*;
import java.util.*;

public class GetStudentInfo {
	
	 public static void getStudentInfo() {
	        try {
	            FileOutputStream fs = new FileOutputStream("Output.src");
	            ObjectOutputStream OS = new ObjectOutputStream(fs);
	            Scanner reader = new Scanner(System.in);

	            	try {
	            		 int stdID = 0;
	 	                String firstName ;
	 	                String lastName;
	 	                Student student = new Student();

	 	                System.out.println("Enter student number: ");
	 	                while(stdID == 0 || stdID < 0){
	 	                    try{
	 	                        stdID = reader.nextInt();
	 	                        student.setStdID(stdID);
	 	                    } catch (Exception exception) {
	 	                        System.out.println("***Invalid student number!*** \nPlease enter a valid student number: ");
	 	                    }
	 	                    reader.nextLine();
	 	                }

	 	                System.out.println("Enter student's first name: ");
	 	                        firstName = reader.nextLine();
	 	                        student.setFirstName(firstName);

	 	                System.out.println("Enter student's last name: ");
	 	                        lastName = reader.nextLine();
	 	                        student.setLastName(lastName);

	 	                boolean addCourse = true;

	 	                do {
	 	                    System.out.println("Enter student's course <Enter 0 to finish>: ");
	 	                    String course = reader.nextLine();

	 	                    if (course.equals("0")) {
	 	                        addCourse = false;
	 	                    } else {
	 	                        student.setCourses(course);
	 	                    }

	 	                } while (addCourse);
	 	                

	 		            OS.writeObject(student);
	 		            OS.flush();

	            	}catch(NoSuchElementException e) {
	            		System.out.println("***Error: " + e + " ***\n");
	            	}
	               
 		        OS.flush();	
	            fs.close();
	            reader.close();

	        } catch (Throwable e) {
	            System.err.println(e.getMessage());
	        }
	    }
}
