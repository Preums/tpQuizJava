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
		<title>Listing</title>
	</head>
	<body>
		<%@ include file="banner.jsp" %>
		<div class="main row full_width">
			<nav class="col p1 m1">
				<%@ include file="menu.jsp" %>
			</nav>
			<%
				ArrayList<User> listing = (ArrayList<User>) request.getAttribute("listing");
			%>

			<main class="main_col p1 m1 listUser">
				<table class="listing">
				<tr>
					<th>Prénom</th>
					<th>Nom</th>
					<th>Fonction</th>
					<th></th>
					<th></th>
				<th>
				<% for(User user: listing) { %>
				<tr>
					<td><% out.print(user.getFirstname()); %></td>
					<td><% out.print(user.getLastname()); %></td>
					<td><% out.print(user.getFunction()); %></td>
					<td><a href="modifyUser?user=<%out.print(user.getFunction());%>&id=<%out.print(user.getId());%>"><button>modifier</button></a></td>
					<td><a href="deleteUser?user=<%out.print(user.getFunction());%>&id=<%out.print(user.getId());%>"><button>supprimer</button></a></td>
				</tr>
				<% } %>
				</table>
				<a href="admin"><button>Retour à l'espace d'administration</button></a>
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