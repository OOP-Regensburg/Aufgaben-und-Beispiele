import acm.program.ConsoleProgram;

/**
 * @author Alexander Bazo
 * A class representing an stone. As the stone is eatable, we implement the
 * according interface and define a specific behavior for eating it.
 */
public class Stone implements Eatable {
	
	private ConsoleProgram context;
	
	public Stone(ConsoleProgram context) {
		this.context = context;
	}
	
	public String toString() {
		return "Stone";
	}

	@Override
	public void eat() {
		context.println("Teeth -32");
	}

}
