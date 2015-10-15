import acm.program.ConsoleProgram;


public class HelloWorld extends ConsoleProgram {

		public void run() {
			/*
			 * Prints "Hello World" on the console
			 */
			println("Hello world");
			/*
			 * The first part prints "2*2" on the console. 
			 * The '+'-operator adds another part to the output: 
			 * 	the result of the arithmetic operation 2+2 
			 */
			println("2*2=" + 2*2);
		}
}
