package trafficlight;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class TrafficLightController extends GraphicsApp implements KeyListener {

	private static final int HEIGHT = 500;
	private static final int WIDTH = 400;
	private static final Color BG_COLOR = Color.WHITE;

	/* KeyCodes */
	private static final int KEY_R = 82;
	private static final int KEY_G = 71;
	private static final int KEY_Y = 89;
	private static final int KEY_O = 79;

	private TrafficLight trafficLight;

	public void setup() {
		setupCanvas();
		trafficLight = new TrafficLight(WIDTH);
		trafficLight.draw();
	}

	private void drawBackground() {
		background(BG_COLOR);
	}

	private void setupCanvas() {
		size(WIDTH, HEIGHT);
		frameRate(20);
		smooth();
		drawBackground();
	}

	/*
	 * This method is called whenever a user presses a key. The passed-in
	 * KeyEvent e contains information about the pressed key. cf. here:
	 * http://docs.oracle.com/javase/1.4.2/docs/api/java/awt/event/KeyEvent.html
	 */
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KEY_R:
			trafficLight.turnRed();
			break;
		case KEY_G:
			trafficLight.turnGreen();
			break;
		case KEY_Y:
			trafficLight.turnYellow();
			break;
		case KEY_O:
			trafficLight.turnOff();
			break;
		}
		trafficLight.draw();
	}
}
