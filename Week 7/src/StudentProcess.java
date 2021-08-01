import java.util.*;
import java.util.stream.Collectors;
public class StudentProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students = {
				new Student("Jack", "Smith", 50.0, "IT"),
				new Student("Aaron", "Johnson", 76.0, "IT"),
				new Student("Maaria", "White", 35.8, "Business"),
				new Student("John", "White", 47.0, "Media"),
				new Student("Laney", "White", 62.0, "IT"),
				new Student("Jack", "Jones", 32.9, "Business"),
				new Student("Wesley", "Jones", 42.89, "Media")};

		List<Student> studentList = Arrays.asList(students);
		System.out.println("Task: 1\n");
		System.out.println("Complete Student list:");
		studentList.stream()
		.forEach(System.out::println);


		System.out.println("\nTask: 2\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		studentList.stream()
		.filter(i -> i.getGrade() >= 50 && i.getGrade() <= 100)
		.sorted(Comparator.comparing(Student::getGrade))
		.forEach(System.out::println);

		System.out.println("\nTask: 3\n");
		System.out.println("First Student who got 50.0-100.0: ");
		studentList.stream()
		.findFirst()
		.ifPresent(System.out::println);

		System.out.println("\nTask: 4\n");
		System.out.println("Students in ascending order by last name then first: ");
		studentList.stream().sorted(Comparator.comparing(Student::getLastName)
				.thenComparing(Comparator.comparing(Student::getFirstName)))
		.forEach(System.out::println);

		System.out.println(" \nStudents in Descending order by last name then first: ");
		studentList.stream().sorted(Comparator.comparing(Student::getLastName)
				.thenComparing(Comparator.comparing(Student::getFirstName)).reversed())
		.forEach(System.out::println);

		System.out.println("\nTask: 5\n");
		System.out.println("Unique Student last names ");
		studentList.stream().sorted(Comparator.comparing(Student::getLastName))
		.map(Student::getLastName)
		.distinct().forEach(System.out::println);


		System.out.println("\nTASK: 5\n");
		studentList
		.stream()
		.sorted(Comparator.comparing(Student::getLastName))
		.map(Student::getLastName)
		.distinct()
		.forEach(System.out::println);

		System.out.println("\nTASK: 6\n");
		System.out.println("Student names in order by last name then first name: ");
		studentList
		.stream()
		.sorted(Comparator.comparing(Student::getLastName)
				.thenComparing(Comparator.comparing(Student::getFirstName)))
		.map(Student::getName)
		.forEach(System.out::println);

		System.out.println("\nTask: 7\n");
		System.out.println("Students by department:  ");
		Map<String,List<Student>> studentarray=studentList.stream().
				collect(Collectors.groupingBy(Student::getDepartment));

		studentarray.forEach((key,value)->{
			System.out.println(key);
			value.forEach(print->System.out.println("    "+print));});

		System.out.println("\nTask: 8\n");
		System.out.println("Count of Students by department: ");
		Map<String,Long> newstudentCount =
				studentList.stream().collect(Collectors.groupingBy(Student::getDepartment,TreeMap::new, Collectors.counting()));
		newstudentCount.forEach((key,val)->System.out.println(key + " has " + val+" Student(s) "));

		System.out.println("\nTask: 9\n");
		double SumGrades=studentList
				.stream().mapToDouble(Student::getGrade).sum();
		System.out.println("Sum of Students' grades: "+ SumGrades);

		System.out.println("\nTask: 10\n");
		double average =studentList
				.stream().mapToDouble(Student::getGrade).average().orElse(0);
		System.out.printf("%s: %.2f%n", "Average of Students' grades: ", average);
	}

}
