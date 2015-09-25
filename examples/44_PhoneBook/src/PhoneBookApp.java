import java.awt.event.KeyEvent;

import de.mi.ur.oop.phonebook.PhoneBook;
import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;

@SuppressWarnings("serial")
public class PhoneBookApp extends GraphicsApp {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 800;
	private static final Color BACKGROUND_COLOR = new Color(30,30,30);
	private static final int INPUT_VIEW_HEIGHT = 100;

	private PhoneBook phoneBook;
	private PhoneBookView phoneBookView;
	private SearchInputView inputView;

	public void setup() {
		initPhoneBook();
		initApplication();
		initComponents();
		drawComponents();
	}

	private void initPhoneBook() {
		phoneBook = new PhoneBook();
		phoneBook.fillWithDebugData();
	}

	private void initApplication() {
		size(WIDTH, HEIGHT);
	}

	private void initComponents() {
		phoneBookView = new PhoneBookView(0, INPUT_VIEW_HEIGHT, WIDTH, HEIGHT-INPUT_VIEW_HEIGHT, phoneBook);
		inputView = new SearchInputView(0, 0, WIDTH, INPUT_VIEW_HEIGHT, phoneBookView);
	}
	
	private void drawComponents() {
		background(BACKGROUND_COLOR);
		inputView.draw();
		phoneBookView.draw();
	}

	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			inputView.clearInput();
		} else {
			char input = event.getKeyChar();
			if(Character.isLetter(input) || Character.isWhitespace(input)) {
				inputView.addChar(input);
			}
		}
		drawComponents();
		super.keyPressed(event);
	}

}
