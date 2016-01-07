import acm.program.ConsoleProgram;

/*
 * This program calculates the factorial value for several numbers
 * from 0 to MAX_NUM
 */
@SuppressWarnings("serial")
public class FactorialExample extends ConsoleProgram {

	public static final int MAX_NUM = 4;

	public void run() {
		for (int i = 0; i < MAX_NUM; i++) {
			println(i + "! = " + factorial(i));
		}
	}

	private int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
