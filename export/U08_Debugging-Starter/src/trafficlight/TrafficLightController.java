package trafficlight;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class TrafficLightController extends GraphicsApp implements KeyListener {

	private static final int HEIGHT = 500;
	private static final int WIDTH = 500;
    private static final int FRAME_RATE = 30;
    private static final int SMOOTH_LEVEL = 8;
	private static final Color BG_COLOR = Color.WHITE;

	private TrafficLight trafficLight;

	public void setup() {
		setupCanvas();
		setupTrafficLight();
	}

	private void setupCanvas() {
		size(WIDTH, HEIGHT);
		frameRate(FRAME_RATE);
		smooth(SMOOTH_LEVEL);
	}

	private void setupTrafficLight() {
		trafficLight = new TrafficLight(WIDTH);
	}

	public void draw() {
		background(BG_COLOR);
		trafficLight.draw();
	}


	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_R:
			trafficLight.switchToRed();
			break;
		case KeyEvent.VK_G:
			trafficLight.switchToGreen();
			break;
		case KeyEvent.VK_Y:
			trafficLight.switchToYellow();
            break;
		case KeyEvent.VK_O:
			trafficLight.switchOff();
			break;
		}
	}
}
