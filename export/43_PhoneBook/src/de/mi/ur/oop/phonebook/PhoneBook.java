package de.mi.ur.oop.phonebook;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

	private HashMap<String, Entry> book;

	public PhoneBook() {
		initBook();
	}

	private void initBook() {
		book = new HashMap<String, Entry>();
	}

	public Entry getEntry(String name) {
		return book.get(name);
	}

	public void addEntry(String name, String areaCode, String number) {
		book.put(name, new Entry(name, areaCode, number));
	}

	public ArrayList<Entry> getEntries() {
		ArrayList<Entry> entries = new ArrayList<Entry>();
		for (String name : book.keySet()) {
			entries.add(book.get(name));
		}
		return entries;
	}

	public ArrayList<Entry> getEntries(String nameFilter) {
		if(nameFilter.isEmpty()) {
			return getEntries();
		}
		
		ArrayList<Entry> entries = new ArrayList<Entry>();
		for (String name : book.keySet()) {
			if (name.contains(nameFilter)) {
				entries.add(book.get(name));
			}
		}
		return entries;
	}
	
	public void fillWithDebugData() {
		addEntry("Alexander Bazo", "0941", "943 4958");
		addEntry("Patricia Böhm", "0941", "943 5099");
		addEntry("Victoria Böhm", "0941", "943 5099");
		addEntry("Martin Brockelmann", "0941", "943 3524");
		addEntry("Manuel Burghardt", "0941", "943 5098");
		addEntry("Raphael Wimmer", "0941", "943 3170");
	}
}
