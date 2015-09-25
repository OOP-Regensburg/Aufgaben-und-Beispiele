import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.world.Color;

public class IfCases extends BouncerApp {
	
	/**
	 * Bouncer moves 15 fields to the right. After each move, he checks if the field in front of him is clear. 
	 * If this is the case, he paints the field he is currently standing on in green. If not, he paints it red.
	 * Pre-condition: Bouncer stands at position (0,14)
	 * Post-condition: Bouncer stands at position (14,14)
	 */
	@Override
	public void bounce() {
		loadLocalMap("Empty");
		for(int i=0; i<15;i++) {
			bouncer.move();
			if(bouncer.canMoveForward()) {
				bouncer.paintField(Color.GREEN);
			} else {
				bouncer.paintField(Color.RED);
			}
		}
		
	}

}

