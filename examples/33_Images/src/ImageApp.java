import java.awt.event.KeyEvent;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Image;
import de.ur.mi.graphicsapp.GraphicsApp;

/**
 * A simple demo application showing the use of key input and image objects
 * 
 * @author Alexander Bazo
 *
 */
@SuppressWarnings("serial")
public class ImageApp extends GraphicsApp {

	private static final Color BACKGROUND_COLOR = Color.GRAY;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;

	private Image monsters;
	private double originalImageWidth;
	private double originalImageHeight;

	public void setup() {
		setupCanvas();
		setupComponents();
	}

	private void setupCanvas() {
		size(WIDTH, HEIGHT);
	}

	/**
	 * This method creates a image object by loading a file from the projects
	 * asset folder. Based on the images initial size, its position is modified
	 * to center the image in the canvas. The iamge object itself is stored in
	 * the monsters member.
	 */
	private void setupComponents() {
		monsters = new Image(0, 0, "data/assets/monsters.png");
		originalImageWidth = monsters.getWidth();
		originalImageHeight = monsters.getHeight();
		double xPos = (WIDTH - originalImageWidth) / 2;
		double yPos = (HEIGHT - originalImageHeight) / 2;
		monsters.setPosition(xPos, yPos);
	}

	public void draw() {
		background(BACKGROUND_COLOR);
		monsters.draw();
	}

	/**
	 * GraphicsApp implements an interface that allows handling of key input. We
	 * override the method (defined by the interface) to handle keyPress-Events
	 * in our own implementation of GraphicsApp (ImageApp).
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		/*
		 * While pressing a key, the user envokes a KeyEvent which is passed to
		 * our Application. The event is represented by the parameter of this
		 * callback function and includes certain information. We can get the
		 * numeric code of the pressed key and switch that value to determine
		 * which key was pressed.
		 */
		switch (e.getKeyCode()) {
		case KeyEvent.VK_0:
			monsters.setSize(originalImageWidth, originalImageHeight);
			break;
		case KeyEvent.VK_1:
			monsters.scale(0.1, 0.1);
			break;
		case KeyEvent.VK_2:
			monsters.scale(0.2, 0.2);
			break;
		case KeyEvent.VK_3:
			monsters.scale(0.3, 0.3);
			break;
		case KeyEvent.VK_4:
			monsters.scale(0.4, 0.4);
			break;
		case KeyEvent.VK_5:
			monsters.scale(0.5, 0.5);
			break;
		case KeyEvent.VK_6:
			monsters.scale(0.6, 0.6);
			break;
		case KeyEvent.VK_7:
			monsters.scale(0.7, 0.7);
			break;
		case KeyEvent.VK_8:
			monsters.scale(0.8, 0.8);
			break;
		case KeyEvent.VK_9:
			monsters.scale(0.9, 0.9);
			break;
		default:
			break;
		}
		super.keyPressed(e);
	}

}
