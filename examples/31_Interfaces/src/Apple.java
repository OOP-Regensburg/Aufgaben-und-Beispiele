import acm.program.ConsoleProgram;

/**
 * @author Alexander Bazo
 * A class representing an apple. As the apple is eatable, we implement the
 * according interface and define a specific behavior for eating it.
 */
public class Apple implements Eatable {
	
	private ConsoleProgram context;
	
	public Apple(ConsoleProgram context) {
		this.context = context;
	}
	
	public String toString() {
		return "Apple";
	}

	@Override
	public void eat() {
		context.println("Stamina +100");
	}

}
