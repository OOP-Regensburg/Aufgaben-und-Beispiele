import acm.program.ConsoleProgram;


/*
 * This program reads a value and checks if it is large than a given threshold and even
 */
@SuppressWarnings("serial")
public class LargeAndEven extends ConsoleProgram {

	// Threshold constants used for the comparision
	private static final int THRESHOLD = 42;

	public void run() {
		println("Dieses Programm ließt eine Zahl ein und kontrolliert ob der eingegbene Wert größer als "
				+ THRESHOLD + " ist und durch 2 teilbar ist.");
		// Reading the value
		int num = readInt("Geben Sie eine Zahl ein: ");

		// checking if the value is larger than the threshold
		boolean large = (num >= THRESHOLD);
		// checking if the value is even
		boolean even = ((num%2) == 0);
		
		// using the calculated booleans to print the result
		if (large && even) {
			println("Der eingegeben Wert ist größer als " + THRESHOLD + " und durch 2 teilbar.");
		} else {
			println("Der eingegeben Wert ist kleiner als " + THRESHOLD + " oder nicht durch 2 teilbar.");
		}
		
	}

}
