package ur.mi.oop.heapvisualizer;


import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Label;
import de.ur.mi.graphics.Rect;

public class HeapVisualizer {
	private static final int MB = 1024*1024;
	
	private static final Color HEAP_COLOR = new Color(30, 30, 30, 150);
	private static final Color USED_HEAP_COLOR = new Color(120, 0, 20, 150);
	private static final Color INFO_TEXT_COLOR = new Color(255, 255, 255, 255);
	private static final String DEFAULT_TEXT = "heap visualizer";
	private static final double HEIGHT_FACTOR = 0.05;
	private static final double LABEL_FACTOR = 0.7;
	private static final double FONT_FACTOR = 0.5;
	
	private int width;
	private int height;
	
	private Runtime runtime;
	private Rect totalHeapRect;
	private Rect usedHeapRect;
	private Label infoLabel;
	
	public HeapVisualizer(int appletWidth, int appletHeight) {
		initViszualizer(appletWidth, appletHeight);
		initRuntimeAccess();
	}
	
	private void initViszualizer(int appletWidth, int appletHeight) {
		this.width = appletWidth;
		this.height = (int) (appletHeight * HEIGHT_FACTOR);
		int y = appletHeight - this.height;
		
		totalHeapRect = new Rect(0, y, width, height, HEAP_COLOR);
		usedHeapRect = new Rect(0, y, width, height, USED_HEAP_COLOR);
		infoLabel = new Label(height, y+height*LABEL_FACTOR, DEFAULT_TEXT, INFO_TEXT_COLOR);
		infoLabel.setFontSize(height*FONT_FACTOR);
	}
	
	private void initRuntimeAccess() {
		runtime = Runtime.getRuntime();
	}
	
	public void draw() {
		drawHeapVisualization();
		drawInfoText();
	}
	
	private void drawHeapVisualization() {
		usedHeapRect.setSize((int) (getUsedMemory()/getAvailableMemory() * width), height);
		totalHeapRect.draw();
		usedHeapRect.draw();
	}
	
	private void drawInfoText() {
		String infoText = getUsedMemory() + "MB of " + getAvailableMemory() + "MB (max: " + getMaximumMemory() + "MB)";
		infoLabel.setText(infoText);
		infoLabel.draw();
	}
	
	// Used memory in current heap
	private double getUsedMemory() {
		return ((runtime.totalMemory() - runtime.freeMemory()) / MB);
	}
	
	// Size of current heap
	private double getAvailableMemory() {
		return (runtime.totalMemory()/MB);
	}
	
	// Maximal heap size
	private double getMaximumMemory() {
		return (runtime.maxMemory()/MB);
	}
}
