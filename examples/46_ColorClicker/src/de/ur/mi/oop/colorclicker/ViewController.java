package de.ur.mi.oop.colorclicker;


public class ViewController {
	
	private Circle[] circles;
	
	public void setCircles(Circle[] circles) {
		this.circles = circles;
	}
	
	public void handleClick(int mouseX, int mouseY) {
		for(int i=0; i < circles.length; i++) {
			circles[i].onMouseClick(mouseX, mouseY);
		}
	}
	
	public void draw() {
		drawCircles();
	}
	
	private void drawCircles() {
		for(int i=0; i < circles.length; i++) {
			circles[i].draw();
		}
	}

}
