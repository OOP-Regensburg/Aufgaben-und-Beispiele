import acm.program.ConsoleProgram;

/**
 * 
 * @author Alexander Bazo
 * @version 1.0
 * 
 * A simple Application to demonstrate the usage of the Student-class and
 * the behaviour of objects as parameters
 *
 */
@SuppressWarnings("serial")
public class StudentsApp extends ConsoleProgram {

	private static final int MAX_STUDENTS = 3;
	private Student[] students;

	public void run() {
		readStudents();
		printStudents();
		
		Student firstStudent = students[0];
		modifyStudent(firstStudent, 20);
		printStudents();
	}

	private void readStudents() {
		students = new Student[MAX_STUDENTS];

		for (int i = 0; i < students.length; i++) {
			students[i] = readStudent(i);
		}

	}
	
	private void printStudents() {
		for (int i = 0; i < students.length; i++) {
			printStudent(students[i]);
		}
	}
	
	private void modifyStudent(Student student, int lp) {
		println("Modifying Students LPs");
		student.addLP(lp);
	}

	private Student readStudent(int studentNumber) {
		println("Geben Sie die Informationen für Student "
				+ (studentNumber + 1) + " ein: ");
		String studentName = readLine("Name: ");
		double studentGrade = readDouble("Note: ");
		return new Student(studentName, studentGrade);
	}

	private void printStudent(Student student) {
		println("#" + student.getId() + ": " + student.getName() + " (" + student.getGrade() + "), " + student.getLP() + " LP");
	}

}
