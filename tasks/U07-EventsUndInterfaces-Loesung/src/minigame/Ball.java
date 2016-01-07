package minigame;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;

import java.awt.event.MouseEvent;

/*
 * This class uses Composition and delegates client-requests to the
 * Ellipse object, which is held as an instance variable
 */

public class Ball {

	private static int BALL_DIAM = 40;
	private static Color BALL_COLOR = Color.BLACK;

	private int speedXIncrease = 1;
	private int speedYIncrease = 1;
	private int speedXAxis = 1;
	private int speedYAxis = 1;

	private Ellipse ball;

	public Ball(int xPos, int yPos) {
		ball = new Ellipse(xPos, yPos, BALL_DIAM, BALL_DIAM, BALL_COLOR);
	}

	public void move() {
		ball.move(speedXIncrease * speedXAxis, speedYIncrease * speedYAxis);
	}

	public void checkWallCollision(int width, int height) {
		if (ball.getLeftBorder() <= 0) {
			speedXAxis *= -1;
		} else if (ball.getRightBorder() >= width) {
			speedXAxis *= -1;
		} else if (ball.getTopBorder() <= 0) {
			speedYAxis *= -1;
		} else if (ball.getBottomBorder() >= height) {
			speedYAxis *= -1;
		}

	}

	public boolean checkMouseHit(MouseEvent e) {
		addSpeed();
		if (e.getX() >= ball.getLeftBorder()
				&& e.getX() <= ball.getRightBorder()) {
			if (e.getY() >= ball.getTopBorder()
					&& e.getY() <= ball.getBottomBorder()) {
				return true;
			}
		}
		return false;
	}

	public void draw() {
		ball.draw();
	}

	private void addSpeed() {
		speedXIncrease++;
		speedYIncrease++;
	}
}