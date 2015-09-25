package de.ur.mi.oop.colorclicker;

import processing.event.MouseEvent;
import de.ur.mi.graphicsapp.GraphicsApp;
import de.ur.mi.oop.colorclicker.Circle.ClickListener;

@SuppressWarnings("serial")
public class ColorClicker extends GraphicsApp implements ClickListener {

	private ViewController view;
	private GameModel model;
	private boolean lost = false;
	private int frameCountOnLost = 0;

	public void setup() {
		size(GameModel.WIDTH, GameModel.HEIGHT);
		initComponents();
		initFirstRound();
	}

	private void initComponents() {
		model = new GameModel();
		view = new ViewController();
	}

	private void initFirstRound() {
		model.startGame(this);
		view.setCircles(model.getCircles());
	}

	private void initNextRound() {
		model.nextRound(this);
		view.setCircles(model.getCircles());

	}

	public void draw() {
		background(GameModel.BACKGROUND_COLOR);

		if (lost) {
			if (frameCount - frameCountOnLost >= GameModel.LOST_DELAY_FRAMES) {
				lost = false;
			} else {
				return;
			}
		}
		view.draw();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		if (lost) {
			return;
		}
		view.handleClick(event.getX(), event.getY());
		super.mouseClicked(event);
	}

	@Override
	public void onCircleClicked(Circle circle) {
		if (lost) {
			return;
		}
		if (circle.getColor().equals(model.getCurrentTargetColor())) {
			initNextRound();
		} else {
			lost = true;
			frameCountOnLost = frameCount;
			initFirstRound();
		}

	}
}
