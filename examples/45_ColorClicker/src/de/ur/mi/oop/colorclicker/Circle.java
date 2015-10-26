package de.ur.mi.oop.colorclicker;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;

public class Circle {
	
	@Override
	public String toString() {
		return "Circle [getColor()=" + getColor() + "]";
	}

	private Ellipse background;
	private ClickListener listener;
	
	public Circle(ClickListener listener, double x, double y, double radius, Color backgroundColor) {
		this.listener = listener;
		background = new Ellipse(x, y, (int) radius*2, (int) radius*2, backgroundColor);
		background.setBorderWeight(0);
		background.setBorderColor(Color.TRANSPARENT);
	}
	
	public void draw() {
		background.draw();
	}
	
	public void onMouseClick(double mouseX, double mouseY) {
		if(background.hitTest(mouseX, mouseY)) {
			listener.onCircleClicked(this);
		}
	}
	
	public Color getColor() {
		return background.getColor();
	}
	
	public void setColor(Color color) {
		background.setColor(color);
	}

	public interface ClickListener {
		public void onCircleClicked(Circle circle);
	}
}
