import acm.program.*;

/*
 * This program reads a number from the user and calculates
 * a Hailstone  sequence
 */

@SuppressWarnings("serial")
public class HailstonePuzzle extends ConsoleProgram {

	/* Sentinel at which execution stops */
	private static final int STOP_SENTINEL = 1;

	/* Messages to print during execution */
	private static final String UNEVEN_MESSAGE = " ist ungerade, also multipliziere ich mit 3 und addiere 1: ";
	private static final String EVEN_MESSAGE = " ist gerade, also halbiere ich: ";

	public void run() {
		int hailStoneNum = readInt("Zahl eingeben: ");

		int steps = 0;
		while (hailStoneNum > STOP_SENTINEL) {
			int oldHailStoneNum = hailStoneNum;
			if (hailStoneNum % 2 == 0) {
				hailStoneNum = hailStoneNum / 2;
				println(oldHailStoneNum + EVEN_MESSAGE + hailStoneNum);
			} else {
				hailStoneNum = (3 * hailStoneNum) + 1;
				println(oldHailStoneNum + UNEVEN_MESSAGE + hailStoneNum);
			}
			steps++;
		}
		println("Ich habe " + steps + " Schritt(e) benoetigt, um "
				+ hailStoneNum + " zu erreichen.");
	}

}
