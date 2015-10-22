import acm.program.*;

/*
 * This program reads a list of numbers from the user
 * and displays the largest and smallest numbers.
 */

@SuppressWarnings("serial")
public class FindRange extends ConsoleProgram {

	/* Sentinel at which execution stops */
	private static final int SENTINEL = 0;

	public void run() {
		println("Ich finde die groesste und kleinste Zahl, die Du eingibst.");

		int currentNum = readInt("? ");

		int smallestNum = currentNum;
		int largestNum = currentNum;

		while (currentNum != SENTINEL) {
			if (currentNum > largestNum) {
				largestNum = currentNum;
			}
			if (currentNum < smallestNum) {
				smallestNum = currentNum;
			}
			currentNum = readInt("? ");
		}

		if ((smallestNum != 0) && (largestNum != 0)) {
			println("Die groesste Zahl ist: " + largestNum);
			println("Die kleinste Zahl ist: " + smallestNum);
		} else {
			println("Zahl eingeben, nicht 0!");
		}

	}

}
