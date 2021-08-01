import java.io.*;
import java.util.Scanner;

public class Write{
	private File file;

	public Write(File fileObject) throws WriteException {
		if (fileObject.getName().length() == 0) {
			throw new WriteException("Name of file is empty");
		} else {
			this.file = fileObject;
		}
	}
	
	public static void AddStudent(String fileName) {

		Student obj2 = new Student();
		File file;
		Write fileWrite;
		try {
			Input(obj2);
			file = new File(fileName);
			fileWrite = new Write(file);
			fileWrite.serializeObject(obj2);
		} catch (FileNotFoundException message) {
			System.out.println(message.getMessage());
		} catch (IOException message) {
			System.out.println(message.getMessage());
		} catch (WriteException message) {
			System.out.println(message.getMessage());
		} catch (StdException message) {
			System.out.println(message.getMessage());
		}
	}
	
	public void serializeObject(Student object) throws IOException   {
		
		FileOutputStream fos = new FileOutputStream(this.file.getName());
		ObjectOutputStream oos = new ObjectOutputStream(fos);	
		
		try {Scanner reader = new Scanner(System.in);

        boolean addStd = true;

        do {
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
                    student.setSingleCourse(course);
                }

            } while (addCourse);

            oos.writeObject(student);
            oos.flush();

            System.out.println("Would you like to enter another student? (y or n): ");
            String answer = reader.nextLine();

            while(!(answer.equalsIgnoreCase("y")) && !(answer.equalsIgnoreCase("n"))){
                System.out.println(answer + " is an invalid answer. Please enter y or n: ");
                answer = reader.nextLine();
            }

            if(answer.equalsIgnoreCase("n")){
                addStd = false;
            }

        }while(addStd);

        oos.flush();
        fos.close();
        reader.close();

    } catch (Throwable e) {
        System.err.println(e.getMessage());
    	}
	}
}

