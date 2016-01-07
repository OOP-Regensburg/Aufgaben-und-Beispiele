package minigame;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Label;

public class Counter {

	private static Color TEXT_COLOR = Color.BLACK;

	private int points = 0;
	private Label counterLabel;

	public Counter(int xPos, int yPos) {
		counterLabel = new Label(xPos, yPos, "0", TEXT_COLOR);
		counterLabel.setFontSize(50);
	}

	public void add() {
		points += 10;
		counterLabel.setText("" + points);
	}

	public void subtract() {
		points -= 10;
		counterLabel.setText("" + points);
	}

	public void draw() {
		counterLabel.draw();
	}

}
