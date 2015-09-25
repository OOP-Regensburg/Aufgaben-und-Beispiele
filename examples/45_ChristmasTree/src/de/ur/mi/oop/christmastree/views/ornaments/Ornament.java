package de.ur.mi.oop.christmastree.views.ornaments;

import de.ur.mi.graphics.Image;
import de.ur.mi.oop.christmastree.config.Assets;

public class Ornament {
	
	protected OrnamentType type;
	protected double xPos;
	protected double yPos;
	protected double width;
	protected double height;
	
	public Ornament(OrnamentType type, double xPos, double yPos, double width, double height) {
		this.type = type;
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}
	
	public void draw() {
		Image ball = getImage(type);
		ball.scale(width/ball.getWidth(),height/ball.getHeight());
		ball.setPosition(xPos, yPos);
		ball.draw();
	}
	
	public OrnamentType getType() {
		return type;
	}

	protected Image getImage(OrnamentType type) {
		switch(type) {
		case BALL_BLUE:
			return Assets.BALL_BLUE;
		case BALL_GOLD:
			return Assets.BALL_GOLD;
		case BALL_RED:
			return Assets.BALL_RED;
		default:
			return null;
		}
	}
	

}
