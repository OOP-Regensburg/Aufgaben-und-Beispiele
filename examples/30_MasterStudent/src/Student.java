/**
 * 
 * @author Alexander Bazo
 * @version 1.0
 * 
 * A class representing a Student
 *
 */
public class Student {

	/* Static counter, shared among all instances */
	private static int studentCounter = 1;
	
	/**
	 * Members: Used to describe the state and properties of a student
	 */
	private String name;
	private double grade;
	private int id;
	private int lp;
	
	/**
	 * The constructor. Use new Student(name,grade) to create a new student instance
	 * @param name Name of the new student
	 * @param grade (Average) Grade of the new student
	 */
	public Student(String name, double grade) {
		/* Using this to point to the instance members and to distinguish from the parameters */
		this.name = name;
		this.grade = grade;
		id = studentCounter;
		/* Each new instance increments the shared variable - therefore the value always holds
		 * the current number of created student objects. */
		studentCounter++;
	}
	
	/**
	 * @return The name of the student
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return The (avergage) grade of the student
	 */
	public double getGrade() {
		return grade;
	}
	
	/**
	 * @return The current number of created student objects
	 */
	public int getCurrenStudentCount() {
		return studentCounter;
	}
	
	/**
	 * @return The id of the student
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return The number of LPs for the student
	 */
	public int getLP() {
		return lp;
	}
	
	/**
	 * 
	 * @param lp Number of LPs to add to the students LP-counter
	 */
	public void addLP(int lp) {
		this.lp += lp;
	}
	
	/**
	 * @return  A string representation of the student (id, name and grade)
	 */
	@Override
	public String toString() {
		return ("#" + getId() + ": " + getName() + " (" + getGrade() + ", " + getLP() + "LP)");
	}
	
	
}
