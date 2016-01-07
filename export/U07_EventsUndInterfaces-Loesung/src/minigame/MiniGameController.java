package minigame;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class MiniGameController extends GraphicsApp implements MouseListener {

	private static final int HEIGHT = 500;
	private static final int WIDTH = 600;
	private static final Color BG_COLOR = Color.WHITE;

	private Counter counter;
	private Ball ball;

	public void setup() {
		setupCanvas();
		setupGame();
	}

	private void setupGame() {
		counter = new Counter(10, 60);
		ball = new Ball(WIDTH / 2, HEIGHT / 2);
	}

	private void drawBackground() {
		background(BG_COLOR);
	}

	private void setupCanvas() {
		size(WIDTH, HEIGHT);
		frameRate(60);
		smooth();
		drawBackground();
	}

	public void draw() {
		drawBackground();
		ball.move();
		ball.draw();
		ball.checkWallCollision(WIDTH, HEIGHT);
		counter.draw();
	}

	public void mousePressed(MouseEvent e) {
		if (ball.checkMouseHit(e)) {
			counter.add();
		} else {
			counter.subtract();
		}
	}

}
