package de.ur.mi.oop.demos.javafx;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class ViewController implements Initializable {
	private static final double DEFAULT_INPUT_VALUE = 5.0;
	
	@FXML private TextField firstGradeInput;
	@FXML private TextField secondGradeInput;
	@FXML private TextField thirdGradeInput;
	@FXML private Label finalGradeOutput;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
	}
	
	@FXML
	private void onTextFieldChanged(KeyEvent event) {
		calculateGrade();
	}
	
	private void calculateGrade() {
		double[] grades = getGradesFromInterface();
		double finalGrade = GradingHelper.getFinalGrade(grades);
		setFinalGradeInInterface(finalGrade);
	}
	
	private void setFinalGradeInInterface(double finalGrade) {
		finalGrade = Math.floor(finalGrade);
		finalGradeOutput.setText(String.valueOf(finalGrade));
	}
	
	private double[] getGradesFromInterface() {
		try {
			double firstGrade = Double.parseDouble(firstGradeInput.getText());
			double secondGrade = Double.parseDouble(secondGradeInput.getText());
			double thirdGrade = Double.parseDouble(thirdGradeInput.getText());
			return new double[]{firstGrade, secondGrade, thirdGrade};
		} catch (NumberFormatException e){
			return new double[]{DEFAULT_INPUT_VALUE, DEFAULT_INPUT_VALUE, DEFAULT_INPUT_VALUE};
		}
	}
}