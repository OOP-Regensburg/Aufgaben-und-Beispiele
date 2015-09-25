import de.ur.mi.bouncer.apps.BouncerApp;

public class InfiniteLoop extends BouncerApp {

	
	@Override
	public void bounce() {
		loadLocalMap("Empty");
		moveToCenter();
		/*
		 * All fields surrounding Bouncer are free, therefore the
		 * condition - used in the while-loop - is always TRUE and 
		 * the loop can not terminate.
		 */
		while(bouncer.canMoveLeft()) {
			bouncer.turnLeft();
		}
	}
	
	/*
	 * Bouncer moves to the center of the map
	 * Pre-Condition: Bouncer is standing on (0,14), facing east
	 * Post-Condition: Bouncer ist standing on (7,7) facing north
	 */
	public void moveToCenter() {
		for(int i=0; i<7; i++) {
			bouncer.move();
		}
		bouncer.turnLeft();
		for(int i=0; i<7; i++) {
			bouncer.move();
		}
	}

}
