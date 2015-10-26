import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Label;
import de.ur.mi.graphics.Rect;


public class SearchInputView  {

	public static final Color BACKGROUND_COLOR = new Color(220,20,120,150);
	public static final Color FONT_COLOR = new Color(250,250,250,255);
	private static final String DEFAULT_TEXT = "Enter Name to search";
	
	private String inputString = "";
	private SearchInputChangedListener inputListener;
	private Rect labelBackground;
	private Label labelContent;
	
	public SearchInputView(int x, int y, int width, int height, SearchInputChangedListener inputListener) {
		this.inputListener = inputListener;
		initComponents(x,y,width,height);
	}
	
	private void initComponents(int x, int y, int width, int height) {
		labelBackground = new Rect(x, y, width, height, BACKGROUND_COLOR);
		labelContent = new Label(x+height/4, y+height/1.7, DEFAULT_TEXT, FONT_COLOR);
		labelContent.setFontSize(height/3);
	}

	public void draw() {
		labelBackground.draw();
		labelContent.draw();
	}
	
	public void addChar(char c) {
		inputString += c;
		labelContent.setText(inputString);
		inputListener.onSearchInputChanged(inputString);
	}
	
	public void clearInput() {
		inputString  = "";
		labelContent.setText(DEFAULT_TEXT);
		inputListener.onSearchInputChanged(inputString);
	}
}
