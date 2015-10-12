import de.ur.mi.bouncer.apps.BouncerApp;

public class DasErsteHindernis extends BouncerApp {

    /**
     * Bouncer moves from left to right and climbs over an obstacles
     * Pre-condition: Bouncer stands on the left side of the obstacles, facing east
     * Post-condition: Bouncer stands on the right side of the obstacles, facing east
     */
	@Override
	public void bounce() {
		loadMap("Obstacles");
		moveToObstacle();
		climbOverObstacle();
		moveToWall();
	}

    /**
     * Bouncer moves to the obstacle
     * Pre-condition: Bouncer stands on the left side of the obstacles, facing east
     * Post-condition: Bouncer stands in front of the obstacle, facing east
     */
    private void moveToObstacle() {
		bouncer.move();
		bouncer.move();
	}

    /**
     * Bouncer moves to the east end of the wall
     * Pre-condition: Bouncer stands behind the obstacle, facing east
     * Post-condition: Bouncer stands at the east end of the map, facing east
     */
    private void moveToWall() {
        bouncer.move();
        bouncer.move();
        bouncer.move();
        bouncer.move();
        bouncer.move();
	}

    /**
     * Bouncer climbs over the obstacle
     * Pre-condition: Bouncer stands in front of the obstacle, facing east
     * Post-condition: Bouncer stands behind the obstacle, facing east
     */
    private void climbOverObstacle() {
		climbUp();
		climbDown();
	}

    /**
     * Bouncer climbs up the obstacle
     * Pre-condition: Bouncer stands in front of the obstacle, facing east
     * Post-condition: Bouncer stands on top of the obstacle, facing east
     */
    private void climbUp() {
        bouncer.turnLeft();
        bouncer.move();
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.move();
        bouncer.turnLeft();
        bouncer.move();
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.move();
	}

    /**
     * Bouncer climbs down the obstacle
     * Pre-condition: Bouncer stands on top of the obstacle, facing east
     * Post-condition: Bouncer stands behind the obstacle, facing east
     */
    private void climbDown() {
        bouncer.move();
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.move();
        bouncer.turnLeft();
        bouncer.move();
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.turnLeft();
        bouncer.move();
        bouncer.turnLeft();
	}

}
