/*
 * A class representation for a master student. Variables and methods are inherited from
 * the base class Student.
 */
public class MasterStudent extends Student {

	/**
	 * The constructor. Use new MasterStudent(name,grade) to create a new master student instance.
	 * The constructor uses the constructor from its super class and sets the LPs to an inital 
	 * value of 180. 
	 * @param name Name of the new student
	 * @param grade (Average) Grade of the new student
	 */
	public MasterStudent(String name, double grade) {
		super(name, grade);
		addLP(180);
	}

	/**
	 * Overriding the inherited toString() implementation
	 * @return A string representation of the student (id, name and grade)
	 */
	@Override
	public String toString() {
		/* Explicit call of the inherited toString()-method 
		 * and concatenating its result with a class
		 */
		return super.toString() + "(MasterStudent)";
	}
}
