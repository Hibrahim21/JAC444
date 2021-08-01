import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses = new ArrayList<String>();
	
	public Student() {
		this.stdID = 0;
		this.firstName= " ";
		this.lastName= " ";
	}
	public Student (int stdID, String firstName, String lastName, ArrayList<String> courses) throws StdException {
		if (stdID < 0 || firstName == " " || lastName == " " || courses.isEmpty()) {
			throw new StdException("Invalid data was entered for student");
		} 
		else {
			this.stdID = stdID;
			this.firstName = firstName;
			this.lastName = lastName;
			
			for (String i : courses) {
				this.courses.add(i);
			}
		}
	}

	
	public int getStdID() {
		return this.stdID;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public ArrayList<String> getCourses() {
		return this.courses;
	}

	public String getSingleCourse(String courseName) throws StdException {
		if (courseName.equals(" ")) {
			throw new StdException("Input a valid course name that is not empty");
		} 
		else {
			for (String i : this.courses) {
				if (i.equals(courseName)) {
					return i;

				}
			}
			throw new StdException("Student does not have specified course");
		}
	}


	public void setStdID(int stdID) throws StdException {
		if (stdID < 0) {
			throw new StdException("Invalid student ID member");
		} 
		else {
			this.stdID = stdID;
		}
	}

	public void setFirstName(String firstName) throws StdException {
		if (firstName == " ") {
			throw new StdException("Invalid First Name ");
		} 
		else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) throws StdException {
		if (lastName == " ") {
			throw new StdException("Invalid Last Name");
		} 
		else {
			this.lastName = lastName;
		}
	}

	public void setCourses(ArrayList<String> courses) throws StdException {
		if (courses.isEmpty()) {
			throw new StdException("List of Courses is empty");
		} 
		else {
			for (String i : courses) {
				this.courses.add(i);
			}
		}
	}

	public void setSingleCourse(String courseName) throws StdException{
		if(courseName.equals(" ")) {
			throw new StdException("Invalid course to add");
		}
		else {
			this.courses.add(courseName);
			
		}
	}
}
