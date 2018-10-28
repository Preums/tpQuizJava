package quiz;

import java.util.ArrayList;

public class Quiz {
	private long idQuiz;
	private String quizName;
	private ArrayList<Answer> answers;
	private ArrayList<Question> questions;
	
	public Quiz() {
	}
	
	public Quiz(long idQuiz, String questionName, ArrayList<Answer> answers, ArrayList<Question> questions) {
		this.idQuiz = idQuiz;
		this.quizName = questionName;
		this.answers = answers;
		this.questions = questions;
	}
	
	public long getIdQuiz() {
		return idQuiz;
	}
	
	public String getQuizName() {
		return quizName;
	}
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public void setIdQuiz(long idQuiz) {
		this.idQuiz=idQuiz;
	}
	
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	public void setQuizName(String questionName) {
		this.quizName = questionName;
	}
	
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	
	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
	
}
