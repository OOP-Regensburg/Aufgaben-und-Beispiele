package de.ur.mi.oop.christmastree;

import java.util.ArrayList;

import processing.event.MouseEvent;
import de.ur.mi.graphicsapp.GraphicsApp;
import de.ur.mi.oop.christmastree.config.Assets;
import de.ur.mi.oop.christmastree.config.Config;
import de.ur.mi.oop.christmastree.views.View;
import de.ur.mi.oop.christmastree.views.showcase.ShowcaseView;
import de.ur.mi.oop.christmastree.views.tree.TreeView;
import de.ur.mi.sound.Sound;

/**
 * ChristmasTreeApp is a simple Java application that allows the user to decorate a virtual christmas tree. The application 
 * uses the GraphicsApp framework. 
 * 
 * Following assets are used:
 * (Tree) http://fc02.deviantart.net/fs70/i/2012/333/b/2/pony_christmas_tree_credit_free_vector_by_poniesfromheaven-d5mjc97.png
 * (Ornaments) http://cp.c-ij.com/en/contents/3159/ornament-ball/downloads/ornament-ball_e_a4.pdf
 * (Sound) http://incompetech.com/music/royalty-free/mp3-royaltyfree/Jingle%20Bells%203.mp3
 * 
 * @author Alexander Bazo
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class ChristmasTreeApp extends GraphicsApp {
	
	private ArrayList<View> views;
	
	public void setup() {
		initApplication();
		initViews();
		initSound();
	}
	
	private void initApplication() {
		size(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
	}
	
	private void initViews() {
		TreeView treeView = new TreeView(0,0,(int) (Config.SCREEN_WIDTH*0.8),Config.SCREEN_HEIGHT,Config.TREE_BACKGROUND_COLOR);
		ShowcaseView showcaseView = new ShowcaseView(treeView, treeView.getWidth(),0,(int) (Config.SCREEN_WIDTH*0.2),Config.SCREEN_HEIGHT,Config.SHOWCASE_BACKGROUND_COLOR);
		
		views = new ArrayList<View>();
		views.add(treeView);
		views.add(showcaseView);
	}
	
	private void initSound() {
		Sound bgMusic = Assets.BACKGROUND_MUSIC;
		bgMusic.loop();
	}
	
	public void draw() {
		background(Config.BACKGROUND_COLOR);
		drawViews();
	}
	
	private void drawViews() {
		for(View view: views) {
			view.draw();
		}
	}
	
	private void broadcastClickEvent(double x, double y) {
		for(View view: views) {
			view.onClick(x, y);
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		broadcastClickEvent(event.getX(), event.getY());
		super.mouseClicked(event);
	}

}
