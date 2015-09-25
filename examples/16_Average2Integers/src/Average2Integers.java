import acm.program.ConsoleProgram;

/*
 * This program read two values and calcuates the average
 */
@SuppressWarnings("serial")
public class Average2Integers extends ConsoleProgram {

	public void run() {
		println("Dieses Programm berechnet den Durchschnitt zweier Zahlen.");
		// Prompting the user to enter the first value
		int addend1 = readInt("Gib die erste Zahl ein: ");
		// Prompting the user to enter the second value
		int addend2 = readInt("Gib die zweite Zahl ein: ");
		// Calculating the sum
		int sum = addend1 + addend2;
		
		// Calculating the average without casting
		double average = sum / 2;
		println("Resultat ohne Cast der Summe: " + average);

		// Calculating the average without explicit casting
		average = ((double) sum) / 2;
		println("Resultat mit Cast der Summe: " + average);
		
	}
}
