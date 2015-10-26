package de.ur.mi.oop.christmastree.views.ornaments;

import de.ur.mi.graphics.Image;
import de.ur.mi.graphics.Rect;
import de.ur.mi.oop.christmastree.config.Config;

public class OrnamentThumbnail extends Ornament {
	
	private boolean selected = false;

	public OrnamentThumbnail(OrnamentType type, double xPos, double yPos,
			double width, double height) {
		super(type, xPos, yPos, width, height);
	}
	
	@Override
	public void draw() {
		Image ball = getImage(type);
		ball.scale(width/ball.getWidth(),height/ball.getHeight());
		ball.setPosition(xPos, yPos);
		if(selected) {
			Rect background = new Rect(ball.getPosition(), (int) ball.getWidth(), (int) ball.getHeight(), Config.SELECTION_COLOR);
			background.draw();
		}
		ball.draw();
	}
	
	public boolean wasClicked(double x, double y) {
		Rect rect = new Rect(xPos, yPos, (int) width, (int) height, null);
		return rect.hitTest(x, y);
	}
	
	public void select() {
		selected = true;
	}
	
	public void deselect() {
		selected = false;
	}

}
