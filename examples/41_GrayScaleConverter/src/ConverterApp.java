import java.awt.event.KeyEvent;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Image;
import de.ur.mi.graphicsapp.GraphicsApp;

@SuppressWarnings("serial")
public class ConverterApp extends GraphicsApp {

	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private static final String IMAGE_SRC = "data/assets/marioworld.jpg";

	private Image image;
	private Image source;
	private boolean grayScaleEnabled = false;
	
	public void setup() {
		setupCanvas();
		setupImage();
	}


	private void setupCanvas() {
		size(WIDTH, HEIGHT);
	}

	private void setupImage() {
		image = new Image(0, 0, WIDTH, HEIGHT, IMAGE_SRC);
		source = new Image(0, 0, WIDTH, HEIGHT, IMAGE_SRC);
		image.draw();
	}

	private void switchGrayScaleMode() {
		if (grayScaleEnabled) {
			disableGrayScale();
		} else {
			enableGrayScale();
		}
	}
	
	private void disableGrayScale() {
		image.setPixelArray(source.getPixelArray());
		image.draw();
		grayScaleEnabled = false;
	}

	private void enableGrayScale() {
		int[][] pixels = source.getPixelArray();
		int pixelGridHeight = pixels.length;
		int pixelGridWidth = pixels[0].length;
		
		for(int row = 0; row < pixelGridHeight; row++) {
			for(int col = 0; col < pixelGridWidth; col++) {
				int pixelValue = pixels[row][col];
				Color color =  new Color(pixelValue);
				color = convertColorToGrayScale(color);
				pixels[row][col] = color.toInt();
			}
		}
		
		image.setPixelArray(pixels);
		image.draw();
		grayScaleEnabled = true;
	}

	private Color convertColorToGrayScale(Color color) {
		int grayScaleValue = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
		return new Color(grayScaleValue,grayScaleValue,grayScaleValue);
	}

	@Override
	public void keyPressed(KeyEvent event) {
		switchGrayScaleMode();
		super.keyPressed(event);
	}
}
