package de.ur.mi.oop.demos.gradeCalculator;

public class GradeCalculator {
	private static final int MIN_ARGUMENTS = 3;

	public static void main(String[] args) {
		String x = "TEST";
		System.out.println(x = "Hello World");


		if(args.length < MIN_ARGUMENTS) {
			System.out.println("Invalid arguments. (Usage: java GradeCalculator grade1 grade2 grade3)");
		} else {
			double finalGrade = calculateGrade(args);
			System.out.println("Final grade: " + Math.ceil(finalGrade));
		}

		char c = 7;
		if(c = 3) {

		}
	}

	private static double calculateGrade(String[] args){
		double[] grades = new double[args.length];
		
		for(int i=0; i<grades.length; i++) {
			double grade = 5.0;
			try {
				grade = Double.parseDouble(args[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			grades[i] = grade;
		}
		
		return GradingHelper.getFinalGrade(grades);
	}

}
