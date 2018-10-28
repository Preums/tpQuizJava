package quiz;

import java.util.ArrayList;

public class Test {


	private String testName;
	private ArrayList<Question> testQuestions;
	private ArrayList<Answer> testAnswers;
	
	public Test() {	
	}
	
	public Test(String testName, ArrayList<Question> testQuestions, ArrayList<Answer> testAnswers) {
		this.testName = testName;
		this.testQuestions = testQuestions;
		this.testAnswers = testAnswers;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public ArrayList<Question> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(ArrayList<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}

	public ArrayList<Answer> getTestAnswers() {
		return testAnswers;
	}

	public void setTestAnswers(ArrayList<Answer> testAnswers) {
		this.testAnswers = testAnswers;
	}
}
