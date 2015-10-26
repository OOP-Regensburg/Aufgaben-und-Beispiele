package de.ur.mi.oop.colorclicker;

import de.ur.mi.graphics.Color;
import de.ur.mi.oop.colorclicker.Circle.ClickListener;
import de.ur.mi.util.RandomGenerator;

public class GameModel {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	public static final Color BACKGROUND_COLOR = new Color(240, 240, 240);
	public static final int DEFAULT_NUMBER_OF_CIRCLES = 64;
	public static final int DEFAULT_COLOR_DEVIATION = 50;
	public static final int DEVIATION_DECREASE = 5;
	public static final int LOST_DELAY_FRAMES = 60;

	private double numberOfRows;
	private int deviation = 0;
	private Color currentTargetColor;
	private Circle[] circles;

	public void startGame(ClickListener listener) {
		initNewGame(listener, DEFAULT_NUMBER_OF_CIRCLES, DEFAULT_COLOR_DEVIATION);
	}

	public void nextRound(ClickListener listener) {
		int newDeviation = deviation - DEVIATION_DECREASE;
		if(newDeviation <= DEVIATION_DECREASE) {
			newDeviation = DEVIATION_DECREASE;
		}
		initNewGame(listener, DEFAULT_NUMBER_OF_CIRCLES, newDeviation);
	}

	public Circle[] getCircles() {
		return circles;
	}

	public double getNumberOfRows() {
		return numberOfRows;
	}

	public Color getCurrentTargetColor() {
		return currentTargetColor;
	}

	private void initNewGame(ClickListener listener, int numberOfCircles,
			int deviation){
		numberOfRows = Math.sqrt(numberOfCircles);
		this.deviation = deviation;
		initCircles(listener, numberOfRows, deviation);
	}

	private void initCircles(ClickListener listener, double numberOfRows,
			int deviation) {
		double radius = (WIDTH / numberOfRows) / 2;
		double xPos = radius;
		double yPos = radius;
		Color baseColor = getRandomColor();
		currentTargetColor = getColorDeviation(baseColor, deviation);
		circles = new Circle[(int) (numberOfRows * numberOfRows)];
		int targetIndex = RandomGenerator.getInstance().nextInt(0,
				circles.length - 1);

		for (int x = 0; x < numberOfRows; x++) {
			for (int y = 0; y < numberOfRows; y++) {
				int index = (int) (x * numberOfRows + y);
				xPos = radius + x * (2 * radius);
				yPos = radius + y * (2 * radius);
				circles[index] = new Circle(listener, xPos, yPos, radius * 0.9,
						baseColor);
			}
		}

		circles[targetIndex].setColor(currentTargetColor);
	}

	private Color getRandomColor() {
		int r = (255 + RandomGenerator.getInstance().nextInt(0, 255)) / 2;
		int g = (255 + RandomGenerator.getInstance().nextInt(0, 255)) / 2;
		int b = (255 + RandomGenerator.getInstance().nextInt(0, 255)) / 2;
		return new Color(r, g, b);
	}

	private Color getColorDeviation(Color baseColor, int deviation) {
		int r = baseColor.getRed() - deviation;
		int g = baseColor.getGreen() - deviation;
		int b = baseColor.getBlue() - deviation;
		return new Color(r, g, b);
	}

}
