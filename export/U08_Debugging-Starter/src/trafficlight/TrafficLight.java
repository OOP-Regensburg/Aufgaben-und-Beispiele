package trafficlight;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Compound;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphics.Rect;

public class TrafficLight {

	private static final Color TRAFFIC_LIGHT_BACKGROUND = Color.BLACK;
	private static final Color TRAFFIC_LIGHT_DEFAULT = Color.GRAY;
	private static final Color TRAFFIC_LIGHT_RED = Color.RED;
	private static final Color TRAFFIC_LIGHT_GREEN = Color.GREEN;
	private static final Color TRAFFIC_LIGHT_YELLOW = Color.YELLOW;
	private static final int TRAFFIC_LIGHT_DIAM = 100;

	private Compound frame;
	private Ellipse redLight;
	private Ellipse yellowLight;
	private Ellipse greenLight;

	public TrafficLight(int canvasWidth) {
		initTrafficLightFrame(canvasWidth);
		initTrafficLight(canvasWidth);
	}

	private void initTrafficLightFrame(int canvasWidth) {
		frame = new Compound();

		Rect upperFrame = null;
		Rect lowerFrame = null;

		frame.add(upperFrame);
		frame.add(lowerFrame);
		upperFrame = new Rect(canvasWidth / 2 - 120, 50, 240, 380,
				TRAFFIC_LIGHT_BACKGROUND);
		lowerFrame = new Rect(canvasWidth / 2 - 30, 50, 60, 480,
				TRAFFIC_LIGHT_BACKGROUND);
	}

	private void initTrafficLight(int canvasWidth) {
		redLight = new Ellipse(canvasWidth / 2, 120, TRAFFIC_LIGHT_DIAM,
				TRAFFIC_LIGHT_DIAM, TRAFFIC_LIGHT_DEFAULT);
		yellowLight = new Ellipse(canvasWidth / 2, 240, TRAFFIC_LIGHT_DIAM,
				TRAFFIC_LIGHT_DIAM, TRAFFIC_LIGHT_DEFAULT);
		greenLight = new Ellipse(canvasWidth / 2, 360, TRAFFIC_LIGHT_DIAM,
				TRAFFIC_LIGHT_DIAM, TRAFFIC_LIGHT_DEFAULT);
	}

	public void draw() {
		frame.draw();
		drawTrafficLights();
	}

	private void drawTrafficLights() {
		redLight.draw();
		greenLight.draw();
		yellowLight.draw();
	}

	public void switchToRed() {
		redLight.setColor(TRAFFIC_LIGHT_RED);
		greenLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		yellowLight.setColor(TRAFFIC_LIGHT_DEFAULT);
	}

	public void switchToGreen() {
		redLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		greenLight.setColor(TRAFFIC_LIGHT_GREEN);
		yellowLight.setColor(TRAFFIC_LIGHT_DEFAULT);
	}

	public void switchToYellow() {
		redLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		greenLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		yellowLight.setColor(TRAFFIC_LIGHT_YELLOW);
	}

	public void switchOff() {
		redLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		greenLight.setColor(TRAFFIC_LIGHT_DEFAULT);
		yellowLight.setColor(TRAFFIC_LIGHT_DEFAULT);
	}

}
