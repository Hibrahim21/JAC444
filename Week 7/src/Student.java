//import java.lang.*;
public class Student {
	private String firstName;
	private String lastName;
	private double grade;
	private String department;
	
	public Student(String fName, String lName, double Grade, String dept){
		setFirstName(fName);
		setLastName(lName);
		setGrade(Grade);
		setDepartment(dept);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getName() {
        return getFirstName() + ' ' + getLastName();
    }
	
	@Override
	public String toString() {
        return (
                getFirstName() +
                "\t" + getLastName() +
                "\t\t" + getGrade() +
                "\t" + getDepartment());
    }
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;

	        Student student = (Student) obj;

	        if (Double.compare(student.grade, grade) != 0) return false;
	        if (!firstName.equals(student.firstName)) return false;
	        if (!lastName.equals(student.lastName)) return false;
	        return department.equals(student.department);
	    }
}
	

