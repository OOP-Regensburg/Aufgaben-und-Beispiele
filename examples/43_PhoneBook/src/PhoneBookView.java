import java.util.ArrayList;

import de.mi.ur.oop.phonebook.Entry;
import de.mi.ur.oop.phonebook.PhoneBook;
import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Compound;
import de.ur.mi.graphics.Label;
import de.ur.mi.graphics.Rect;


public class PhoneBookView implements SearchInputChangedListener {
	public static final Color BACKGROUND_COLOR = new Color(30,30,30);
	public static final Color ENTRY_BACKGROUND_COLOR = new Color(255,255,255,10);
	public static final Color FONT_COLOR = new Color(250,250,250,255);
	public static final int ENTRY_HEIGHT = 90;
	public static final int ENTRY_MARGIN = 10;
	
	
	
	private PhoneBook book;
	private ArrayList<Entry> currentEntries;
	private Rect listBackground;
	
	public PhoneBookView(int x, int y, int width, int height, PhoneBook book) {
		this.book = book;
		this.currentEntries = book.getEntries();
		initComponents(x,y,width,height);
	}
	
	private void initComponents(int x, int y, int width, int height) {
		listBackground = new Rect(x, y, width, height, BACKGROUND_COLOR);
	}
	
	public void draw() {
		listBackground.draw();
		render(currentEntries);
	}

	@Override
	public void onSearchInputChanged(String inputString) {
		currentEntries = book.getEntries(inputString);
	}
	
	private void render(ArrayList<Entry> entries) {
		for(int i = 0; i < entries.size(); i++) {
			addEntry(entries.get(i), i);
		}
	}

	private void addEntry(Entry entry, int position) {
		double x = listBackground.getX();
		double y = listBackground.getY() + ENTRY_MARGIN + ((ENTRY_HEIGHT+ENTRY_MARGIN) * position);
		double width = listBackground.getWidth();
		double height = ENTRY_HEIGHT;
		String name = entry.getName();
		String number = entry.getAreaCode() + " " + entry.getNumber();
		
		Compound container = getEntryContainer(x, y, width, height, name, number);
		container.draw();

	}
	
	private Compound getEntryContainer(double x, double y, double width, double height, String name, String number) {
		Compound container = new Compound(x, y);
		
		Rect entryBackground = new Rect(x, y, (int) width, ENTRY_HEIGHT, ENTRY_BACKGROUND_COLOR);
		entryBackground.setBorderWeight(0);
		container.add(entryBackground);
		
		Label nameLabel = new Label(x+ENTRY_HEIGHT/5, y+ENTRY_HEIGHT/3, name, FONT_COLOR, ENTRY_HEIGHT/4);
		container.add(nameLabel);
		
		Label numberLabel = new Label(x+ENTRY_HEIGHT/5, y+ENTRY_HEIGHT/1.4, number, FONT_COLOR, ENTRY_HEIGHT/5);
		container.add(numberLabel);
		
		return container;
	}


	
}
