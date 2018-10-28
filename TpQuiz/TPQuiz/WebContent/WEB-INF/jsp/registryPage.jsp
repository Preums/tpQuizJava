<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/quiz.css">
		<title>Inscription</title>
	</head>
	<body>
		<%@ include file="banner.jsp" %>
		<div class="main row full_width">
			<main class="main_col p1 m1 registry">
				<h2>Inscription</h2>
				<form action="registry" method="POST" >
					<label for="registry_firstname"> Votre prénom:<br></label>
					<input type="text" id="registry_firstname" name="firstname" placeholder="votre prenom">
					<br>
					<label for="registry_lastname"> Votre nom:<br></label>
					<input type="text" id="registry_lastname" name="lastname" placeholder="votre nom">
					<br>
					<label for="registry_email"> Votre adresse mail:<br></label>
					<input type="text" id="registry_email" name="email" placeholder="votre email">
					<br>
					<label for="registry_password"> Votre mot de passe:<br></label>
					<input type="password" id="registry_password"name="password" placeholder="votre mot de passe">
					<br>
					<label for="registry_confirm_password"> Confirmez votre mot de passe:<br></label>
					<input type="password" id="registry_confirm_password" name="confirm_password" placeholder="confirmez votre mot de passe">
					<br>
					<%
					String permission = (String) request.getAttribute("permission");
					Float purcentResult = (float) request.getAttribute("purcentResult");
					if (permission !=null && permission.equals("admin")) { %>
						<label for="registry_function"> Sélectionnez une fonction:<br></label>
						<select name="function" id="registry_function" >
							<option value="teacher" >professeur</option>
							<option value="admin" >administrateur</option>
						</select>
					<% } else { %>
						<input type="hidden" name="function" value="student">
						<input type="hidden" name="admission_score" value="<% out.print(purcentResult); %>">
					<% } %>
					<br>
					<input type="submit" value="Envoyez">
				</form>
			</main>
		</div>
		<footer class="full_width">
			<%@ include file="logo.jsp" %>
		</footer>
	</body>
</html>