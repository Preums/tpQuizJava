<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="quiz.Quiz, quiz.Question, quiz.Answer"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/quiz.css">
		<title>Test in progress</title>
	</head>
	<body>
		<%@ include file="banner.jsp" %>
		<div class="main row full_width">
			<nav class="col p1 m1">
				<%@ include file="menu.jsp" %>
			</nav>
			<%
				Quiz quiz = (Quiz) request.getAttribute("quiz");
				ArrayList<Question> questionList = quiz.getQuestions();
			%>

			<main class="main_col p1 m1">	
				<p class="para p1 m1">	
					Sélectionnez la réponse qui vous semble correct pour valider cette question
				</p>
			<h2 class="quiz_title p1 m1"><% out.println(quiz.getQuizName()); %></h2>
				<form method="post" action="resultPage?quiz=<%out.println(quiz.getIdQuiz());%>">
					<%	int index = 1;
						for (Question question : questionList) {
					%>
						<div class="question para p1 m1">
							<h3 class="question_title p1"><% out.println(question.getQuestionName()); %></h3>
							<div class="answer p1">
								<% ArrayList<Answer> answersList = question.getAnswers(); %>
								
								<% for(Answer answer : answersList) { %>
									<input class="answer_title p1" type="radio" name="answer<% out.print(index); %>" value="<% out.print(answer.getAnswerValue()); %>"><% out.print(answer.getAnswerTitle()); %><br>
								<% } %>
							</div>
						</div>
					<%
					index++;
					}%>
					<input type="hidden" name="index" value=<% out.println(index-1); %>>
					<input type="submit" value="Envoyer">
				</form>
			</main>
			
			<aside class="col p1 m1">
				<%@ include file="login.jsp" %>
			</aside>
		</div>
		
		<footer class="full_width">
			<%@ include file="logo.jsp" %>
		</footer>
		
	</body>
</html>