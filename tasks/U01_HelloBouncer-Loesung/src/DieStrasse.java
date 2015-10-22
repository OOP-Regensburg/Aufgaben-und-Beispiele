import de.ur.mi.bouncer.apps.BouncerApp;
import de.ur.mi.bouncer.world.FieldColor;

public class DieStrasse extends BouncerApp {

    /**
     * Bouncer moves from the left to the right side of the map and repairs broken fields on the street
     * Pre-condition: Bouncer stands on the left side of the map, facing east
     * Post-condition: Bouncer stands on the right side of the map, facing east
     */
	@Override
	public void bounce() {
		loadMap("Strasse");
		checkStreet();
	}

    /**
     * Bouncer taverses the street and repairs broken fields
     * Pre-condition: Bouncer stands on the first field of the street, facing east
     * Post-condition: Bouncer stands on the last field of the street, facing east
     */
	private void checkStreet() {
		while(bouncer.canMoveForward()) {
			checkField();
			bouncer.move();
		}
	}

    /**
     * Bouncer checks the color of the field he is currently standing on and if necessary repairs it
     * Pre-condition: Bouncer stands on a field
     * Post-condition: Bouncer stands on on a green field
     */
    private void checkField() {
		if(bouncer.isOnFieldWithColor(FieldColor.RED)) {
			repairField();
		}
	}

    /**
     * Bouncer repairs the field he is currently standing on
     * Pre-condition: Bouncer stands on a red field
     * Post-condition: Bouncer stands on a green field
     */
    private void repairField() {
		bouncer.paintField(FieldColor.GREEN);
	}


}
