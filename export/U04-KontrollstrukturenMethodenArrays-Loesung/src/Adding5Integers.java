

import acm.program.ConsoleProgram;

/*
 * File: Adding5Integers.java
 * 
 * This program stores five user-entered integers in an array and calculates their sum and average
 * 
 */


public class Adding5Integers extends ConsoleProgram {
	
	/* Maximal numbers of integers to read */
	private static final int MAX_NUMBERS = 5;
	/* Declaration of array to store integer values */

	public void run() {
		int sum = 0;
		double avg = 0;
		int[] integers = readNumbers(MAX_NUMBERS);
		sum = calculateSum(integers);
		avg = calculateAverage(integers);
		
		println("You entered " + MAX_NUMBERS + " integers. The sum is " + sum
				+ " and their average is " + avg);
	}

	/* This method reads x integers and stores them in the array */
	private int[] readNumbers(int numbersToRead) {
		int[] integers = new int[numbersToRead];
		
		/* Looping over each position of the array using its length as an upper limit  */
		for (int i = 0; i < integers.length; i++) {
			/* assign each array position with an user-entered value */
			integers[i] = readInt("Enter a integer (" + (i + 1) + " of "
					+ MAX_NUMBERS + "): ");
		}
		
		return integers;
	}

	/* This method calculates the sum of all numbers stored in a given array */
	private int calculateSum(int[] integers) {
		int sum = 0;
		/* Looping over each position of the array */
		for (int i = 0; i < integers.length; i++) {
			/* Adding the current positions value to the total sum */
			sum += integers[i];
		}
		/* returning the calculated sum */
		return sum;
	}

	/* This method calculates the average of all numbers stored in a given array */
	private double calculateAverage(int[] integers) {
		/* Using the calculateSum method to get the dividend */
		int sum = calculateSum(integers);
		/* Calculate the average by dividing the sum by the count of numbers in the array */
		double avg = ((double) sum) / integers.length;
		/* returning the calucalted value */
		return avg;
	}
}
