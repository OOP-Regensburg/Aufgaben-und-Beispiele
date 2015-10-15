import acm.program.ConsoleProgram;


public class Constants extends ConsoleProgram {
	
	/* Defines how often the message is displayed */ 
	private static final int MESSAGE_NUM = 5;
	
	
	public void run() {
		/* Prints a message on the screen. How often the message is displayed 
		 * depends on the value set in MESSAGE_NUM.
		 */
		for(int i = 0; i < MESSAGE_NUM; i++) {
			println("Hello World!");
		}
	}

}
