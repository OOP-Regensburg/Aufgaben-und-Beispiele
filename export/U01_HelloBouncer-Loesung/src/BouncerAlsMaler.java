import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.world.FieldColor;

public class BouncerAlsMaler extends BouncerApp {

    /**
     * Bouncer moves into a room and paints the walls..
     * Pre-condition: Bouncer stands on the ground, facing east
     * Post-condition: Bouncer stands on the right side of the map, facing east. All fields in the room are painted red.
     */
    @Override
	public void bounce() {
		loadMap("Painter");
		enterRoom();
		paintRoom();
	}

    /**
     * Bouncer moves from his starting position to the doorway
     * Pre-condition: Bouncer stands on the ground, facing east
     * Post-condition: Bouncer stands on the ground (in the doorway), facing east
     */
	private void enterRoom() {
        while(bouncer.canMoveLeft()) {
            bouncer.move();
        }
	}

    /**
     * Bouncer paints tall fields in thre room.
     * Pre-condition: Bouncer stands on the ground (in the doorway), facing east
     * Post-condition: Bouncer stands on the right side of the map, facing east. All fields in the room are painted red.
     */
	private void paintRoom() {
        while(bouncer.canMoveForward()) {
            moveToNextLane();
            paintLane();
        }
	}

    /**
     * Bouncer paints all fields in the current lane (from ground to ceiling).
     * Pre-condition: Bouncer stands on the ground (in the room), facing east
     * Post-condition: Bouncer stands on the ground (in the room), facing east. All fields in the room are painted red.
     */
	private void paintLane() {
        bouncer.turnLeft();
        while(bouncer.canMoveForward()) {
            bouncer.paintField(FieldColor.RED);
            bouncer.move();
        }
        bouncer.paintField(FieldColor.RED);
        turnAround();
        while(bouncer.canMoveForward()) {
            bouncer.move();
        }
        bouncer.turnLeft();
	}

    /**
     * Bouncer moves to the next lane.
     * Pre-condition: Bouncer stands on the ground (in the room), facing east
     * Post-condition: Bouncer stands on the bottom field of the next lane, facing east
     */
	private void moveToNextLane() {
        bouncer.move();
	}

    /**
     * Bouncer turns around
     * Pre-condition: Bouncer stands on any field, facing in any direction
     * Post-condition: Bouncer stands on the same field, facing in the opposite direction
     */
	private void turnAround() {
        bouncer.turnLeft();
        bouncer.turnLeft();
	}

}
