<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h2>Bienvenue sur le site</h2>
				<p class="para text p1 m1">	
					Afin d'acceder à votre espace d'instruction, vous devez réussir le quiz d'admission ou vous identifier à droite
				</p>
				<a href="testInProgress?quiz=1" alt="admission test">
					<p class="para question_link p1 m1">
					Passez le test dès maintenant
					</p>
				</a>
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