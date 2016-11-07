package de.ur.mi.oop.demos.gradeCalculator;

public class GradingHelper {

	private static final double[] WEIGHTS = {0.2, 0.45, 0.35};
	
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
