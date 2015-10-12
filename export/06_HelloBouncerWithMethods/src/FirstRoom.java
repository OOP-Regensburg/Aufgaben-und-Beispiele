import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.world.FieldColor;

public class FirstRoom extends BouncerApp {

	/**
	 * Bouncer climbs up on to an obstacles to a colored field and paints it green
	 * Pre-condition: Bouncer stands two fields away from an obstacle
	 * Post-condition: Bouncer stands on the green field
	 */
	@Override
	public void bounce() {
		loadMap("FirstRoom");
		moveToObstacle();
		climbOnObstacle();
		moveToField();
		bouncer.paintField(FieldColor.GREEN);
	}

	private void moveToObstacle() {
		bouncer.move();
		bouncer.move();
	}
	
	private void climbOnObstacle() {
		bouncer.turnLeft();
		bouncer.move();
		bouncer.turnLeft();
		bouncer.turnLeft();
		bouncer.turnLeft();
		bouncer.move();
	}
	
	private void moveToField() {
		bouncer.move();
		bouncer.move();
	}

	
	

}