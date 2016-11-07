import de.ur.mi.graphicsapp.GraphicsApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/*
* FlightDestinationsReader.java
* ------------------
* Reads in a file of cities and their corresponding flight destinations.
* 
*/

public class FlightDestinationsReader {
	private HashMap<String, ArrayList<String>> destinations = new HashMap<String, ArrayList<String>>();
	private String filePath;
	private String SEPARATOR = "->";

	public FlightDestinationsReader(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Opens flight destinations file and stores the flight information
	 * in a HashMap
	 */
	public HashMap<String, ArrayList<String>> getFlightInfo() {
		try {
			File file = GraphicsApp.loadFile(filePath);
			BufferedReader fileReader = new BufferedReader(new FileReader(
					file));
			while (true) {
				String line = fileReader.readLine();
				if (line == null) {
					break;
				}
				processDestinationLine(line);
			}
			fileReader.close();
		} catch (IOException e) {
			System.out.println(" Fehler : " + e.getLocalizedMessage());
		}
		return destinations;
	}

	/**
	 * Parse flight info file line by line and add destinations to the HashMap
	 * @param line A line from the destinations file
	 * @return The updated destinations HashMap
	 */
	private HashMap<String, ArrayList<String>> processDestinationLine(
			String line) {
		if (!line.equals("")) {
			String[] cities = line.split(SEPARATOR);
			
			String originCity = cities[0];
			String destinationCity = cities[1];
			addCitiesToDestinationList(originCity.trim(), destinationCity.trim());
		}
		return destinations;
	}
	
	/**
	 * Adds a city to the list of destinations for an original city
	 * @param originCity
	 * @param destinationCity
	 */
	private void addCitiesToDestinationList(String originCity,
			String destinationCity) {
		ArrayList<String> destinationsForTarget = destinations.get(originCity);
		if (destinationsForTarget == null) {
			ArrayList<String> newDestination = new ArrayList<String>();
			newDestination.add(destinationCity);
			destinations.put(originCity, newDestination);
		} else {
			if (!destinationsForTarget.contains(destinationCity)) {
				destinationsForTarget.add(destinationCity);
			}
		}

	}
}
