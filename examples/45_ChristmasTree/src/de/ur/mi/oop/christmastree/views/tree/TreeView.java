package de.ur.mi.oop.christmastree.views.tree;

import java.util.ArrayList;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Image;
import de.ur.mi.oop.christmastree.config.Assets;
import de.ur.mi.oop.christmastree.config.Config;
import de.ur.mi.oop.christmastree.views.View;
import de.ur.mi.oop.christmastree.views.ornaments.Ornament;
import de.ur.mi.oop.christmastree.views.ornaments.OrnamentType;
import de.ur.mi.oop.christmastree.views.showcase.ShowcaseActionListener;


public class TreeView extends View implements ShowcaseActionListener {
	
	private Image christmasTree;
	private ArrayList<Ornament> ornaments;
	private OrnamentType currentType = OrnamentType.BALL_BLUE;

	public TreeView(double xPos, double yPos, int width, int height,
			Color backgroundColor) {
		super(xPos, yPos, width, height, backgroundColor);
		initComponents();
	}
	
	private void initComponents() {
		ornaments = new ArrayList<Ornament>();
		initTree();
	}
	
	private void initTree() {
		christmasTree = Assets.TREE;
		christmasTree.scale(getHeight()/christmasTree.getHeight());
		double xPosTree = getWidth()/2 - christmasTree.getWidth()/2;
		double yPosTree = getHeight() - christmasTree.getHeight();
		christmasTree.setPosition(xPosTree, yPosTree);
	}

	@Override
	public void draw() {
		super.draw();
		christmasTree.draw();
		drawOrnaments();
	}
	
	private void drawOrnaments() {
		for(Ornament ornament: ornaments) {
			ornament.draw();
		}
	}
	
	@Override
	protected void handleClick(double x, double y) {
		addOrnamentAtPosition(x, y);
	}
	
	private void addOrnamentAtPosition(double xPos, double yPos) {
		ornaments.add(new Ornament(currentType, xPos-Config.ORNAMENT_SIZE/2, yPos-Config.ORNAMENT_SIZE/2, Config.ORNAMENT_SIZE, Config.ORNAMENT_SIZE));
	}

	@Override
	public void onItemSelected(OrnamentType type) {
		currentType = type;
	}

}
