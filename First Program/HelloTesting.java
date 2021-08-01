
public class HelloTesting {
	String name;
	int id;
	double grades;
	
	// Constructor
	public HelloTesting(String stdName, int stdId, double stdGrades) {
		name = stdName;
		id = stdId;
		grades = stdGrades;
	}
	
	
	
	
	// Getters & Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int newId) {
		if(newId > 0) {
		this.id = newId;
		}
	}

	public double getGrades() {
		return grades;
	}

	public void setGrades(double grades) {
		this.grades = grades;
	}

}
