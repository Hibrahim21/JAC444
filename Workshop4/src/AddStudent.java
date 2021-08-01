//import javax.swing.*;
//import java.awt.*;
import java.util.*;


public class AddStudent {

    public static void main(String[] args) {
    	
    	
        ArrayList<Student> array = new ArrayList<Student> (  );
        array = GetStudent.loader ( array );
        try {

            System.out.println ( "------->JAC 444 Workshop 5<--------" );
            System.out.println ( "------------->Task 1 <-------------" );
            int option = 0;
            int stdID = 0;
            String firstName = null;
            String lastName = null;
            String[] courses = null;
            boolean error = false;
            boolean flag = true;
            while ( option != 3 && flag) {
                try {
                		System.out.println("\n1. Student Data Entry.");
                		System.out.println("2. Displaying Student Data.");
                		System.out.println("3. Exit\n");

                        System.out.print ( "Select from one of the above options: " );
                        Scanner in = new Scanner ( System.in );
                        option = in.nextInt ( );
                    if(option >0 ) {
                        switch (option) {
                            case 1:
                                System.out.println ( "\nEnter Student Account Details" );
                                System.out.println ( "---------------------" );
                                Boolean errorid = true;
                                do {

                                try {
                                    System.out.print ( "Student ID : " );
                                    String sid = in.next ();

                                    stdID = Integer.parseInt ( sid );
                                    if (stdID <0 ){
                                        throw new Exception ( "Invalid student ID! ID Should be positive and not have Character" );
                                    }
                                    errorid = false;

                                } catch ( Exception l ) {

                                    System.out.println ( "Invalid student ID!" );
                                }
                                } while (errorid);
                                 do {
                                System.out.print ( "First Name : " );
                                firstName = in.next ( );
                                if ( firstName.length ( ) < 1 ) {
                                    error = true;
                                    System.out.println ( "First Name should be atleast 1 Character long! Try Again." );
                                } else {
                                    error = false;
                                }
                                } while ( error == true );
                                 do {
                                System.out.print ( "Last Name : " );
                                lastName = in.next ( );
                                if ( lastName.length ( ) < 1 ) {
                                    error = true;
                                    System.out.println ( "Last Name should be at least 1 Character long! Try Again." );
                                } else {
                                    error = false;
                                }
                                  }
                                 while ( error == true );
                                System.out.print ( "\n Seperate each course by a ' ,' if more than 1 \n" );
                                System.out.print ( "courses : " );
                                String oneline = in.next ( );
                                String[] Tempcourses = oneline.split ( "," );
                                courses = Tempcourses;

                                if ( lastName.length ( ) < 1 ) {
                                    error = true;
                                    System.out.println ( "courses should be atleast 1 Character long! Try Again." );
                                } else {
                                    error = false;
                                }
                                Student account = new Student ( stdID, firstName, lastName, courses );
                                array.add(account);
                                ReadStudent.saver ( array );
                                break;
                            case 2:

                            	GetStudent.read ( );
                                break;
                            case 3:
                            	 System.out.println("***Program Exited! Thank you!***");
                                flag = false;
                                break;
                            default:
                                System.out.println ( "***NOT VALID OPTION***" );
                                break;
                        }
                    }
                } catch ( Exception e ) {
                    System.out.println ( "Please select a valid option!\n" );
                }
            }
        } catch ( Exception e ) {
            System.out.println ( e );
        }
    	
////		JFrame frame = new JFrame();
////		frame.setTitle("Student Form");
////		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////		
////		JLabel heading = new JLabel();
////		heading.setText("------->JAC 444 Workshop 5<--------");
////	
////		JButton addStudent, displayStudents;
////		addStudent = new JButton("Add Student");
////		displayStudents = new JButton("Display Student");
////		
////		JLabel label = new JLabel();
////		label.setText("Enter Student ID: ");
////		label.setBounds(10, 10, 100, 100);
////		
////		JTextField field = new JTextField();
////		field.setBounds(110, 50, 130, 30);
////		
////		frame.add(heading);
////		frame.add(label);
////		frame.add(field);
////		frame.add(addStudent);
////		frame.add(displayStudents);
////		
////		frame.setLayout(new FlowLayout());
////		frame.setSize(455, 279);
////		frame.setVisible(true);
//		
//    	JFrame frame =new JFrame("Student Form"); 
//
//    	JLabel label = new JLabel();		
//		label.setText("Enter Name :");
//		label.setBounds(10, 10, 100, 100);
//
//		JLabel label1 = new JLabel();
//		label1.setBounds(10, 110, 200, 100);
//
//		JTextField textfield= new JTextField();
//		textfield.setBounds(110, 50, 130, 30);
//
//		frame.add(label1);
//		frame.add(textfield);
//		frame.add(label);
//		frame.setSize(455, 279);
//		frame.setLayout(null);    
//		frame.setVisible(true);    
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   


    }
}
