package database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import quiz.Answer;
import quiz.Question;
import quiz.Quiz;

public class QuizDb {

	
	public QuizDb() {
	}
	
	public HashMap getQuizList(boolean published) {
		
		HashMap<Integer, String> result = new HashMap<>();
		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			
			String sqlRequest = "SELECT id_test, title From tests WHERE published = ? AND title <> 'admission'";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest);
			int publishedValue = published?1:0;
			preparedSelect.setInt(1,publishedValue);
			ResultSet preparedResult = preparedSelect.executeQuery();
			while(preparedResult.next()) {
				result.put(preparedResult.getInt(1),preparedResult.getString(2));
			}

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
		return result;
	}
	
	public Quiz quiz(String id) {
		
		Quiz result = new Quiz();
		try {
			DataSource connect = new DataSource();
			Connection con = connect.dataSourceConnexion();
			String currentQuestionTitle = new String();
			ArrayList<Question> questions = new ArrayList<Question>();
			ArrayList<Answer> answers = new ArrayList<Answer>();
			String sqlRequest = "SELECT tests.id_test, tests.title, questions.title, answers.answer, answers.success FROM tests INNER JOIN questions USING(id_test) INNER JOIN answers USING (id_question) WHERE tests.id_test=?";
			PreparedStatement preparedSelect = con.prepareStatement(sqlRequest,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			preparedSelect.setString(1,id);
			ResultSet preparedResult = preparedSelect.executeQuery();
			
			Question currentQuestion = new Question();

			while(preparedResult.next()) {

				Answer currentAnswer = new Answer();
				
				if(preparedResult.isFirst()) {
					result.setIdQuiz(preparedResult.getLong(1));
					result.setQuizName(preparedResult.getString(2));
					currentQuestionTitle = preparedResult.getString(3);
					currentQuestion.setQuestionName(currentQuestionTitle);
				}
				
				if(!currentQuestionTitle.equals(preparedResult.getString(3))) {
					ArrayList<Answer> pushedAnswer = new ArrayList<Answer>();
					pushedAnswer = (ArrayList<Answer>) answers.clone();
					currentQuestion.setAnswers(pushedAnswer);
					Question pushedQuestion = new Question();
					pushedQuestion.setQuestionName(currentQuestion.getQuestionName());
					pushedQuestion.setAnswers(currentQuestion.getAnswers());
					questions.add(pushedQuestion);
					answers.removeAll(answers);
					currentQuestionTitle = preparedResult.getString(3);
					currentQuestion.setQuestionName(currentQuestionTitle);
				}
				
				currentAnswer.setAnswerTitle(preparedResult.getString(4));
				currentAnswer.setAnswerValue(preparedResult.getByte(5));
				answers.add(currentAnswer);
				
				if(preparedResult.isLast()) {
					currentQuestion.setQuestionName(currentQuestionTitle);
					currentQuestion.setAnswers(answers);
					questions.add(currentQuestion);
					result.setQuestions(questions);			
				}
			}

			con.close();
			
		} catch (Exception e) {
			System.out.println("connexion unavailable, the error message is:\n"+e);
		}
		return result;
	}
}
