import acm.program.ConsoleProgram;

/*
 * This program reads a value and checks if it is equal, smaller or greater than a given threshold 
 */
@SuppressWarnings("serial")
public class NumCheck extends ConsoleProgram {

	// Threshold constants used for the comparision
	private static final int THRESHOLD = 42;

	public void run() {
		println("Dieses Programm ließt eine Zahl ein und kontrolliert ob der eingegbene Wert größer als "
				+ THRESHOLD + " ist.");
		// Reading the value
		int num = readInt("Geben Sie eine Zahl ein: ");

		// Check for equality
		if (num == THRESHOLD) {
			println("Der eingegeben Wert ist gleich " + THRESHOLD);
		// Check for 'smaller than'
		} else if (num < THRESHOLD) {
			println("Der eingegeben Wert ist kleiner als " + THRESHOLD);
		// If the value is neither equal nor smaller than the threshold ...
		} else {
			println("Der eingegeben Wert ist größer als " + THRESHOLD);
		}
	}
}
