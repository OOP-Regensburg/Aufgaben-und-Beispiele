import acm.program.*;

/*
 * This program computes and displays the Fibonacci
 * series up to maximum value defined by the constant MAX_VALUE;
 */

@SuppressWarnings("serial")
public class Fibonacci extends ConsoleProgram {

	/* Defines the largest term to be displayed */
	private static final int MAX_VALUE = 500;

	public void run() {
		println("This program lists the Fibonacci sequence, for numbers smaller than "
				+ MAX_VALUE + ".");
		println(0);

		int fibOld = 0;
		int fibCurrent = 1;
		int nextFib = 1;

		while (nextFib < MAX_VALUE) {
			println(nextFib);
			nextFib = fibOld + fibCurrent;
			fibOld = fibCurrent;
			fibCurrent = nextFib;
		}
	}

}
