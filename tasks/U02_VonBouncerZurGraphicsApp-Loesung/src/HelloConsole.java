import acm.program.ConsoleProgram;


public class HelloConsole extends ConsoleProgram {

	private static final int NUM_MESSAGE = 5;

	public void run() {
		for(int i = 0; i < NUM_MESSAGE; i++) {
			printHello();
		}
		printWorld();
	}

	private void printHello() {
		println("Hello");
	}

	private void printWorld() {
		println("World");
	}
}
