import acm.program.ConsoleProgram;


/*
 * This program reads two integer values and prints their sum.
 */
@SuppressWarnings("serial")
public class Add2Integers extends ConsoleProgram {
	
	public void run() {
		println("Dieses Programm addiert zwei Zahlen.");
		// Prompting the user to enter the first value
		int addend1 = readInt("Gib die erste Zahl ein: ");
		// Prompting the user to enter the second value
		int addend2 = readInt("Gib die zweite Zahl ein: ");
		//Calculating and printing the sum
		int sum = addend1 + addend2;
		println("Das Ergebnis ist: " + sum);
	}

}
