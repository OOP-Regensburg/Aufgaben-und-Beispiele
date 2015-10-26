import acm.program.ConsoleProgram;

/**
 * 
 * @author Alexander Bazo
 * A simple demo application, showing the use of interfaces
 *
 */
@SuppressWarnings("serial")
public class RPGGame extends ConsoleProgram {
	
	public void run() {
		Apple grannySmith = new Apple(this);
		PoisonousFungi flyAgaric = new PoisonousFungi(this);
		Stone granite = new Stone(this);
		
		eatStuff(grannySmith);
		eatStuff(flyAgaric);
		eatStuff(granite);
	}

	/**
	 * This method simulates eating a certain object. All objects that
	 * implement an interface can be handled as instanced of that interface. 
	 * Therefore we can use the interfaces name as a data type for the parameter.
	 * @param stuff A instance of Eatable
	 */
	private void eatStuff(Eatable stuff) {
		println("Eating a " + stuff.toString());
		stuff.eat();
	}

}
