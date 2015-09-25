import acm.program.ConsoleProgram;

/*
 * This program reads integers until the user enters '0' and 
 * then prints the total sum of the entered values.
 */

@SuppressWarnings("serial")
public class SentinelAdder extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	public void run() {
		int total = 0;
		
		while(true) {
			int num = readInt("Next value (enter 0 to quit): ");
			if(num == SENTINEL) {
				break;
			} 
			
			total += num;	
		}
		
		println("Result: " + total);
	}

}
