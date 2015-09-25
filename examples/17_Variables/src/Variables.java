import acm.program.ConsoleProgram;

/*
 * This program is an example on how to declare and manipulate variables
 */
@SuppressWarnings("serial")
public class Variables extends ConsoleProgram {

	public void run() {
		// Declaring a double variable and initializing it with the value 4.2
		double myDouble = 4.2;
		// Declaring a int variable and initializing it with the value 42
		int myInt = 42;
		// Declaring a int variable without initializing it
		int anotherInt;
		// Asssign a certain value (24) to the variable anotherInt
		anotherInt = 24;
		// Asssign a certain value (1337) to the variable myInt
		myInt = 1337;
		// Evaluating an expression (1337+42) and assigning its result to myInt
		myInt = 1337 + 42;
		// Assign the current value of myInt to anotherInt
		anotherInt = myInt;
		// Asssign a certain value (101) to the variable myInt
		myInt = 101;
	}

}
