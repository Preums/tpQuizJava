package quiz;

import java.util.ArrayList;

public class Question {

	private String questionName;
	private ArrayList<Answer> answers;
	
	public Question() {
	}
	
	public Question(String questionName, ArrayList<Answer> answers) {
		super();
		this.questionName = questionName;
		this.answers = answers;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}	
	
}
