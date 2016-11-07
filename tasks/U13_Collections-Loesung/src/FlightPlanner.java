import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Alexander Bazo on 15/01/16.
 */
public class FlightPlanner extends ConsoleProgram {

    private HashMap<String, ArrayList<String>> flightDatabase = new HashMap<String, ArrayList<String>>();
    private static final String FLIGHTS_FILE_NAME = "/data/assets/flights.txt";

    public void run() {
        println("Let's plan a round trip: ");
        readFlightData();

        println("Here is a list of all the destinations in our database: ");
        printDestinationList(flightDatabase);

        String startCity = readLine("Enter the starting city: ");
        ArrayList<String> roundTrip = new ArrayList<String>();
        roundTrip.add(startCity);

        String currentCity = startCity;

        while (true) {
            printDestinationsForCurrentCity(currentCity);
            String nextDestinationCity = readNextDestination(currentCity);
            roundTrip.add(nextDestinationCity);
            if (nextDestinationCity.equals(startCity)) {
                break;
            }
            currentCity = nextDestinationCity;
        }
        printRoundTrip(roundTrip);
    }

    /**
     * Read flight data from file and store result in flight database
     *
     */
    private void readFlightData() {
        FlightDestinationsReader frD = new FlightDestinationsReader(FLIGHTS_FILE_NAME);
        flightDatabase = frD.getFlightInfo();
    }

    /**
     * Print a list of destinations for a given city from the database
     *
     * @param currentCity
     */
    private void printDestinationsForCurrentCity(String currentCity) {
        ArrayList<String> destinationCitiesForOrigin = flightDatabase.get(currentCity);
        for (String destinationCity : destinationCitiesForOrigin) {
            println(destinationCity);
        }
    }

    /**
     * Get the next destination from the user and verify that the destination the user chooses is valid with respect
     * to the database.
     * @param currentCity
     * @return The next city the user wants to fly to
     */
    private String readNextDestination(String currentCity) {
        String nextCity = null;
        ArrayList<String> destinationsForCity = flightDatabase.get(currentCity);
        while (true) {
            nextCity = readLine("Where do you want to go from " + currentCity
                    + "? ");
            if (destinationsForCity.contains(nextCity)) {
                break;
            }
            println("From " + currentCity + " you cannot fly directly to "
                    + nextCity);
        }
        return nextCity;
    }

    /**
     * Print a list of all possible destinations in the database
     * @param destinations
     */
    private void printDestinationList(HashMap<String, ArrayList<String>> flights) {
        Set<String> originCities = flights.keySet();
        for (String orgCity : originCities) {
            println(orgCity);
        }
    }

    /**
     * Print the complete round trip
     * @param roundTrip
     */
    private void printRoundTrip(ArrayList<String> roundTrip) {
        println("The route you have chosen is: ");
        for (int i = 0; i < roundTrip.size(); i++) {
            print(roundTrip.get(i));
            if (i < roundTrip.size() - 1) {
                print(" -> ");
            }
        }
    }

    /**
     * DEBUG ONLY - Prints all origins and destinations from the database.
     * Only used to verify that database is correctly read from file.
     */
    @SuppressWarnings("unused")
    private void printAllOriginsAndDestinations() {
        Set<String> keys = flightDatabase.keySet();
        for (String originCity : keys) {
            ArrayList<String> destinationCities = flightDatabase.get(originCity);
            println("Origin City: " + originCity);
            for (String destinationCity : destinationCities) {
                println("Destination City: " + destinationCity);
            }
        }
    }
}
