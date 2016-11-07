package de.ur.mi.oop.demos.javafx;

public class GradingHelper {

	private static final double[] WEIGHTS = {0.3, 0.3, 0.4};
	
	public static double getFinalGrade(double ... grades) {
		double result = 0;
		if(grades.length == WEIGHTS.length) {
			for(int i = 0; i < grades.length; i++) {
				result += grades[i] * WEIGHTS[i];
			}
		}
		return result;
	}
}
