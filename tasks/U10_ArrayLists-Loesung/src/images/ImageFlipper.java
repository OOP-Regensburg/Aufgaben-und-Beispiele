package images;

import java.awt.event.KeyEvent;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Image;
import de.ur.mi.graphicsapp.GraphicsApp;

@SuppressWarnings("serial")
public class ImageFlipper extends GraphicsApp {

	private Image sourceImage;
	private Image workingCopy;

	public void setup() {
		size(600, 500);
		sourceImage = new Image(0, 0, "../assets/sopranos.jpg");
		workingCopy = new Image(0, 0, "../assets/sopranos.jpg");
		workingCopy.draw();
	}

	public void keyPressed(KeyEvent event) {
		switch(event.getKeyCode()) {
		case KeyEvent.VK_F:
			workingCopy = flipImage(workingCopy);
			workingCopy.draw();
			break;
		case KeyEvent.VK_B:
			workingCopy = blurImage(workingCopy);
			workingCopy.draw();
			break;
		case KeyEvent.VK_R:
			workingCopy.setPixelArray(sourceImage.getPixelArray());
			workingCopy.draw();
			break;
		}
	}

	private Image flipImage(Image img) {
		int[][] pixels = img.getPixelArray();

		int numLineTotal = pixels.length;
		for (int lineNum = 0; lineNum < numLineTotal; lineNum++) {
			int[] flippedLine = flipLine(pixels[lineNum]);
			pixels[lineNum] = flippedLine;
		}
		img.setPixelArray(pixels);
		return img;
	}

	private Image blurImage(Image img) {
		int[][] sourcePixels = img.getPixelArray();
		int[][] targetPixels = new int[sourcePixels.length][sourcePixels[0].length];

		for(int y=0; y<sourcePixels.length; y++){
			for(int x=0; x<sourcePixels[y].length; x++){
				targetPixels[y][x] = blurPixel(x,y, sourcePixels);
			}
		}
		
		img.setPixelArray(targetPixels);
		
		return img;
	}

	private int blurPixel(int x, int y, int[][] sourcePixels) {
		Color[] colors = new Color[5];
		// color of pixel
		colors[0] = getColor(x,y,sourcePixels);
		// color of pixel to the right
		colors[1] = getColor(x+1,y,sourcePixels);
		// color of pixel at bottom
		colors[2] = getColor(x,y+1,sourcePixels);
		// color of pixel to the left
		colors[3] = getColor(x-1,y,sourcePixels);
		// color of pixel at top
		colors[4] = getColor(x,y-1,sourcePixels);
		
		Color result = mergeColors(colors);
		return result.toInt();
	}
	
	private Color mergeColors(Color[] colors) {
		int red = 0;
		int green = 0;
		int blue = 0;
		
		int colorCount = 0;
		
		for(int i=0; i<colors.length; i++){
			if(colors[i] != null){
				red += colors[i].getRed();
				green += colors[i].getGreen();
				blue += colors[i].getBlue();
				colorCount++;
			}
		}
		red = red / colorCount;
		green = green / colorCount;
		blue = blue/ colorCount;
		
		Color mergedColor = new Color(red, green, blue);
		
		return mergedColor;
	}

	private Color getColor(int x, int y, int[][]sourcePixels){
		if(y >= 0 && y < sourcePixels.length){
			if(x >= 0 && x < sourcePixels[y].length){
				return new Color(sourcePixels[y][x]);
			}
		}
		return null;
	}

	private int[] flipLine(int[] imageLine) {
		int[] flippedLine = new int[imageLine.length];
		for (int i = 0; i < imageLine.length; i++) {
			flippedLine[imageLine.length - 1 - i] = imageLine[i];
		}
		return flippedLine;
	}

}
