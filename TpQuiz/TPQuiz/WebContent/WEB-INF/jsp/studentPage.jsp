<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/quiz.css">
		<title>Quiz Practice</title>
	</head>
	<body>
		<%@ include file="banner.jsp" %>
		<div class="main row full_width">
			<nav class="col p1 m1">
				<%@ include file="menu.jsp" %>
			</nav>
			 
			<main class="main_col p1 m1">	
			<h2>Bienvenue sur votre espace étudiant</h2>
				<p class="para text p1 m1">	
					Afin de poursuivre votre formation vous pouvez passer les quiz disponibles.
				</p>
				
				<%
				HashMap<Integer, String> quizAvailable = new HashMap<Integer, String>();
				quizAvailable = (HashMap<Integer,String>)request.getAttribute("quizAvailable");				
					for (Map.Entry quiz: quizAvailable.entrySet()) {
				%> <a href="testInProgress?quiz=<%out.print(quiz.getKey());%>" alt=""><p class="para question_link p1 m1"> <%
						out.println(quiz.getValue());
				%> </p></a><%
					}
				%>
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