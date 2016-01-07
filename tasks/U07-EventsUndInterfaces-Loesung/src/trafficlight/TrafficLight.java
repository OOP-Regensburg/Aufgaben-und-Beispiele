package trafficlight;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphics.Rect;

public class TrafficLight {

	/* private constants */
	private static final Color TRAFFIC_LIGHT_BACKGROUND = Color.BLACK;
	private static final Color TRAFFIC_LIGHT_DEFAULT = Color.GRAY;
	private static final Color TRAFFIC_LIGHT_RED = Color.RED;
	private static final Color TRAFFIC_LIGHT_GREEN = Color.GREEN;
	private static final Color TRAFFIC_LIGHT_YELLOW = Color.YELLOW;
	private static final int TRAFFIC_LIGHT_DIAM = 100;

	/* instance vars */
	private Ellipse redLight;
	private Ellipse yellowLight;
	private Ellipse greenLight;
	private Rect trafficLightFrame;
	private Rect trafficLightPost;

	public TrafficLight(int width) {
		redLight = new Ellipse(width / 2, 120, TRAFFIC_LIGHT_DIAM,
				TRAFFIC_LIGHT_DIAM, TRAFFIC_LIGHT_DEFAULT);
		yellowLight = new Ellipse(width / 2, 240, TRAFFIC_LIGHT_DIAM,
				TRAFFIC_LIGHT_DIAM, TRAFFIC_LIGHT_DEFAULT);
		greenLight = new Ellipse(width / 2, 360, TRAFFIC_LIGHT_DIAM,
				TRAFFIC_LIGHT_DIAM, TRAFFIC_LIGHT_DEFAULT);
		trafficLightFrame = new Rect(width / 2 - 120, 50, 240, 380,
				TRAFFIC_LIGHT_BACKGROUND);
		trafficLightPost = new Rect(width / 2 - 30, 50, 60, 480,
				TRAFFIC_LIGHT_BACKGROUND);

	}

	public void draw() {
		drawTrafficLightBackground();
		drawTrafficLights();
	}

	// the background of the traffic light (frame and post)
	private void drawTrafficLightBackground() {
		trafficLightFrame.draw();
		trafficLightPost.draw();
	}

	// all the traffic lights are drawn
	private void drawTrafficLights() {
		redLight.draw();
		greenLight.draw();
		yellowLight.draw();
	}

	// Changes to red traffic light
	public void turnRed() {
		redLight.setColor(TRAFFIC_LIGHT_RED);
		greenLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		yellowLight.setColor(TRAFFIC_LIGHT_DEFAULT);
	}

	// Changes to green traffic light
	public void turnGreen() {
		redLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		greenLight.setColor(TRAFFIC_LIGHT_GREEN);
		yellowLight.setColor(TRAFFIC_LIGHT_DEFAULT);
	}

	// Changes to yellow traffic light
	public void turnYellow() {
		redLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		greenLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		yellowLight.setColor(TRAFFIC_LIGHT_YELLOW);
	}

	// changes to off
	public void turnOff() {
		redLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		greenLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		yellowLight.setColor(TRAFFIC_LIGHT_DEFAULT);
	}

}
