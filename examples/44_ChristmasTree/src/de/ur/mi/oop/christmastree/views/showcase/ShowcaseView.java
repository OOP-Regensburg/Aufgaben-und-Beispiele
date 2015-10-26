package de.ur.mi.oop.christmastree.views.showcase;

import java.util.ArrayList;

import de.ur.mi.graphics.Color;
import de.ur.mi.oop.christmastree.views.View;
import de.ur.mi.oop.christmastree.views.ornaments.Ornament;
import de.ur.mi.oop.christmastree.views.ornaments.OrnamentThumbnail;
import de.ur.mi.oop.christmastree.views.ornaments.OrnamentType;

public class ShowcaseView extends View {

	private ShowcaseActionListener actionListener;
	private ArrayList<OrnamentThumbnail> items;

	public ShowcaseView(ShowcaseActionListener actionListener, double xPos,
			double yPos, int width, int height, Color backgroundColor) {
		super(xPos, yPos, width, height, backgroundColor);
		this.actionListener = actionListener;
		initComponents();
	}

	private void initComponents() {
		double itemSize = getWidth() * 0.9;
		double itemMargin = getWidth() * 0.05;
		double xPos = getX() + itemMargin;

		items = new ArrayList<OrnamentThumbnail>();
		items.add(new OrnamentThumbnail(OrnamentType.BALL_BLUE, xPos,
				itemMargin, itemSize, itemSize));
		items.add(new OrnamentThumbnail(OrnamentType.BALL_GOLD, xPos, itemSize
				+ itemMargin, itemSize, itemSize));
		items.add(new OrnamentThumbnail(OrnamentType.BALL_RED, xPos, itemSize
				* 2 + itemMargin, itemSize, itemSize));
		items.get(0).select();
		actionListener.onItemSelected(items.get(0).getType());
	}

	@Override
	public void draw() {
		super.draw();
		drawItems();
	}

	private void drawItems() {
		for (Ornament item : items) {
			item.draw();
		}
	}

	@Override
	protected void handleClick(double x, double y) {
		for (OrnamentThumbnail item : items) {
			item.deselect();
			if (item.wasClicked(x, y)) {
				actionListener.onItemSelected(item.getType());
				item.select();
			}
		}
	}

}
