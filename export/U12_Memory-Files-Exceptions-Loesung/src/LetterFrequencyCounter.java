import de.ur.mi.graphicsapp.GraphicsApp;

import java.io.*;

public class LetterFrequencyCounter {

	private String filePath;
	private String content = "";

	private int eOccurrence;
	private int aOccurrence;
	private int tOccurrence;
	private int iOccurrence;
	private int oOccurrence;

	private int numberOfChars;

	public LetterFrequencyCounter(String filePath) {
		this.filePath = filePath;
	}


	public void readWithFileReader() {
		File file = GraphicsApp.loadFile(filePath);
		try {
			FileReader reader = new FileReader(file);
			int c = -1;
			while(true) {
				c = reader.read();
				if(c == -1) {
					break;
				}
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void readFile() {
		try {
			File file = GraphicsApp.loadFile(filePath);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			String fileContents = "";

			while (true) {
				line = reader.readLine();
				if (line == null)
					break;
				fileContents += line + "\n";
			}

			this.content = fileContents;
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * pre-condition: readFile has been called
	 */
	public void computeLetterFrequency() {
		reset();
		if (content == null) {
			return;
		}
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			c = Character.toLowerCase(c);
			if (c >= 'a' && c <= 'z') {
				numberOfChars++;
				countChar(c);
			}
		}
	}

	private void countChar(char c) {
		switch (c) {
		case ('e'):
			eOccurrence++;
			break;
		case ('a'):
			aOccurrence++;
			break;
		case ('t'):
			tOccurrence++;
			break;
		case ('i'):
			iOccurrence++;
			break;
		case ('o'):
			oOccurrence++;
			break;
		}
	}

	private void reset() {
		eOccurrence = 0;
		aOccurrence = 0;
		tOccurrence = 0;
		iOccurrence = 0;
		oOccurrence = 0;
		numberOfChars = 0;
	}

	private int getRelativeOccurrence(char c) {
		System.out.println(eOccurrence);
		switch (c) {
		case ('e'):
			return (100 * eOccurrence) / numberOfChars;
		case ('a'):
			return (100 * aOccurrence) / numberOfChars;
		case ('t'):
			return (100 * tOccurrence) / numberOfChars;
		case ('i'):
			return (100 * iOccurrence) / numberOfChars;
		case ('o'):
			return (100 * oOccurrence) / numberOfChars;
		default:
			return 0;
		}
	}
	
	/**
	 * pre-condition: computeLetterFrequency has been called
	 */
	public String getFormattedOutput(){
		String result = "------------------------------------------";
		result += 		"\nOccurrences of Letters in the File:";
		result += 		"\ne: "+getRelativeOccurrence('e')+"%";
		result += 		"\na: "+getRelativeOccurrence('a')+"%";
		result += 		"\nt: "+getRelativeOccurrence('t')+"%";
		result += 		"\ni: "+getRelativeOccurrence('i')+"%";
		result += 		"\no: "+getRelativeOccurrence('o')+"%";
		result += 		"\n------------------------------------------";
		return result;
	}
}
