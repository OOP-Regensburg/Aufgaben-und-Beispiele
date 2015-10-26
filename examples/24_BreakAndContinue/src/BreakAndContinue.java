import acm.program.ConsoleProgram;

/*
 * A simple example to show the different behavior 
 * of the break and continue statements 
 */
@SuppressWarnings("serial")
public class BreakAndContinue extends ConsoleProgram {

	private static final int MAX_ITERATIONS = 10;
	private static final int SENTINEL = 5;

	public void run() {
		doFullLoop();
		continueOnEven();
		breakOnSentinel();
	}

	private void doFullLoop() {
		println("Full loop");
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			println(i);
		}
	}

	private void continueOnEven() {
		println("Continue on even");
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			if(i % 2 == 0) {
				continue;
			}
			println(i);
		}
	}

	private void breakOnSentinel() {
		println("Break on sentinel");
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			if(i == SENTINEL) {
				break;
			}
			println(i);
		}
	}

}
