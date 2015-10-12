import de.ur.mi.bouncer.apps.BouncerApp;

public class Hurdles extends BouncerApp {

	/**
	 * Bouncer climbs over three hurdles
	 * Pre-condition: Bouncer stands in front of the first hurdle, facing east
	 * Post-condition: Bouncer stands behind the last hurdle, facing east
	 */
	@Override
	public void bounce() {
		loadMap("Hurdles");
		for(int i=0; i < 3; i++) {
			if(bouncer.canMoveForward()) {
				bouncer.move();
			} else {
				jumpOberHurdle();
			}
		}
	}
	
	/**
	 * Bouncer moves to the next free field by jumping over a hurdle
	 * Pre-condition: Bouncer stands in front of a hurdle, facing east
	 * Post-condition: Bouncer stands behind hurdle, facing east
	 */
	private void jumpOberHurdle() {
		ascendHurdle();
		bouncer.move();
		descendHurdle();
	}

	/**
	 * Bouncer climbs to the top of a hurdle
	 * Pre-condition: Bouncer stands in front of a hurdle, facing east
	 * Post-Condition: Bouncer stand on top of a hurlde, facing east
	 */
	private void ascendHurdle() {
		bouncer.turnLeft();
		while(bouncer.canNotMoveRight()) {
			bouncer.move();
		}
		bouncer.turnLeft();
		bouncer.turnLeft();
		bouncer.turnLeft();
	}
	
	/**
	 * Bouncer climbs down a hurdle
	 * Pre-condition: Bouncer stands on top of a hurdle, facing east
	 * Post-Condition: Bouncer stands behind a hurdle, facing east
	 */
	private void descendHurdle() {
		bouncer.move();
		bouncer.turnLeft();
		bouncer.turnLeft();
		bouncer.turnLeft();
		while(bouncer.canMoveForward()) {
			bouncer.move();
		}
		bouncer.turnLeft();
	}

}






