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
				int result = Integer.parseInt(request.getAttribute("result").toString());
				int total = Integer.parseInt(request.getAttribute("total").toString());
				boolean success = result>((float)total/2)?true:false;
				long quizId = Long.parseLong(request.getAttribute("quizId").toString());
			%>

			<main class="main_col p1 m1">	
				<p class="para p1 m1">	
					Votre résultat est <% out.print(result); %> sur <% out.print(total); %>
				</p>
			<h2 class="quiz_result p1 m1">
				<% if(success){ %>
				Félicitations avez réussis ce quiz
				<% }else { %> Dommage, essayez une autre fois <%} %> 
			</h2>
				<% if((quizId == 1) && success) {%>
				Vous pouvez vous inscrire <a href="registry?result=<% out.print(result); %>&total=<% out.print(total); %>">en suivant ce lien: ici</a>
				<% } %>
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