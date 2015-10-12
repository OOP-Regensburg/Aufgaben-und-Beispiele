import de.ur.mi.bouncer.apps.BouncerApp;

public class FirstRoom extends BouncerApp {

	/**
	 * Bouncer climbs up on to an obstacles to a colored field and paints it green
	 * Pre-condition: Bouncer stands two fields away from an obstacle
	 * Post-condition: Bouncer stands on the green field
	 */
	@Override
	public void bounce() {
		loadMap("FirstRoom");
	}
	

}