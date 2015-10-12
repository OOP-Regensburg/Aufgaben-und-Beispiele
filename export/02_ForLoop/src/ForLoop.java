import de.ur.mi.bouncer.apps.BouncerApp;

public class ForLoop extends BouncerApp {
	
	/**
	 * Bouncer moves 15 fields to the right
	 * Pre-condition: Bouncer stands at position (0,14)
	 * Post-condition: Bouncer stands at position (14,14)
	 */
	@Override
	public void bounce() {
		loadMap("Empty");
		for(int i=0; i<14;i++) {
			bouncer.move();
		}
		
	}

}

