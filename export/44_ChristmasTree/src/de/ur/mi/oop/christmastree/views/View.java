package de.ur.mi.oop.christmastree.views;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Rect;
import de.ur.mi.sound.Sound;


public abstract class View {

	private Rect background;
	
	public View(double xPos, double yPos, int width, int height, Color backgroundColor) {
		background = new Rect(xPos, yPos, width, height, backgroundColor);
	}
	
	public double getWidth() {
		return background.getWidth();
	}
	
	public double getHeight() {
		return background.getHeight();
	}
	
	public double getX() {
		return background.getX();
	}
	
	public double getY() {
		return background.getY();
	}
	
	public void draw() {
		background.draw();
	}
	
	public void onClick(double x, double y) {
		if(background.hitTest(x, y)) {
			handleClick(x, y);
		}
	}
	
	protected abstract void handleClick(double x, double y);
}
