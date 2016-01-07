import de.ur.mi.bouncer.apps.BouncerApp;

import java.awt.*;

public class Hurdles extends BouncerApp {

	/**
	 * Bouncer climbs over three hurdles
	 * Pre-condition: Bouncer stands in front of the first hurdle, facing east
	 * Post-condition: Bouncer stands behind the last hurdle, facing east
	 */
	@Override
	public void bounce() {
        setPositionForRecording();
        loadLocalMap("Hurdles");
		for(int i=0; i < 3; i++) {
            if (bouncer.canMoveForward()) {
                bouncer.move();
            } else {
                println("trying to jump over obstacle " + i);
                jumpOverHurdle();
            }
        }
	}
	
	/**
	 * Bouncer moves to the next free field by jumping over a hurdle
	 * Pre-condition: Bouncer stands in front of a hurdle, facing east
	 * Post-condition: Bouncer stands behind hurdle, facing east
	 */
	private void jumpOverHurdle() {
        println("in: jumpOverHurdle");
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
        println("in: ascendHurdle");
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
        println("in: descendHurdle");
		bouncer.move();
        while(bouncer.isFacingSouth() == false) {
            bouncer.turnLeft();
        }
		while(bouncer.canMoveForward()) {
			bouncer.move();
		}
		bouncer.turnLeft();
	}


    private void setPositionForRecording() {
        Container c = getParent();
        Window window = null;
        while (c.getParent()!=null) {
            c = c.getParent();
        }
        if (c instanceof Window) {
            window = (Window)c;
            window.setLocation(1394,130);
        } else {
            System.out.println(c);
        }
    }

}
