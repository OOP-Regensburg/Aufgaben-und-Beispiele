import de.ur.mi.bouncer.apps.BouncerApp;

public class WhileLoop extends BouncerApp {
	
	/**
	 * Bouncer moves forward until he reaches a blocked field
	 * Pre-condition: -
	 * Post-condition: Bouncer stands in front of a blocked field
	 */
	@Override
	public void bounce() {
		loadMap("Empty");
		while(bouncer.canMoveForward()) {
			bouncer.move();
		}
		
	}

}

