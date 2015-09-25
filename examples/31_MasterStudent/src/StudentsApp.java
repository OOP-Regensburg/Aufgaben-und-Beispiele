import acm.program.ConsoleProgram;

/**
 * 
 * @author Alexander Bazo
 * @version 1.0
 * 
 * A simple Application to demonstrate the usage of the Student-class
 *
 */
@SuppressWarnings("serial")
public class StudentsApp extends ConsoleProgram {

	private static final int MAX_STUDENTS = 3;
	private Student[] students;

	public void run() {
		addStudents();
		printStudents();
	}

	/**
	 * This method creates two Students and one MasterStudent-Objects and stores
	 * them into the students array. As MasterStudent is a subclass of Student we 
	 * can store its instances in variables of Student-type (Downcast) 
	 */
	private void addStudents() {
		students = new Student[MAX_STUDENTS];
		students[0] = new Student("A Student", 1.0);
		students[1] = new Student("B Student", 2.0);
		students[2] = new MasterStudent("C Student", 3.0);
	}
	
	private void printStudents() {
		for (int i = 0; i < students.length; i++) {
			println(students[i]);
		}
	}


}
