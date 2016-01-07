import acm.program.ConsoleProgram;

/**
 * @author Alexander Bazo
 * A class representing an poisonous fungi (Giftpilz). As the fungi is eatable, we implement the
 * according interface and define a specific behavior for eating it.
 */
public class PoisonousFungi implements Eatable {
	
	private ConsoleProgram context;
	
	public PoisonousFungi(ConsoleProgram context) {
		this.context = context;
	}
	
	public String toString() {
		return "PoisonousFungi";
	}

	@Override
	public void eat() {
		context.println("LP -100");
	}

}
