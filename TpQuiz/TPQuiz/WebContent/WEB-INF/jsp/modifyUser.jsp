<%@page import="sun.nio.ch.SelChImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="login.Student" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/quiz.css">
		<title>Modify user Page</title>
	</head>
	<body>
		<%@ include file="banner.jsp" %>
		<div class="main row full_width">
			<nav class="col p1 m1">
				<%@ include file="menu.jsp" %>
			</nav>
				<%
					String function = (String) request.getAttribute("function");
					Student selectedStudent = new Student();
					User selectedUser = new User();
					if (function.equals("student")) {
						selectedStudent = (Student) request.getAttribute("selectedUser");
					} else {;
						selectedUser = (User) request.getAttribute("selectedUser");
					}
				%>
			<main class="main_col p1 m1">	
			<h2>Vous vous appretez à modifier un utilisateur</h2>
			<form action="modifyUser" method="post">
				<% if(function.equals("student")) { %>
					<label for="modify_firstname">Prénom<br></label>
					<input type=text" name="firstname" id="modify_firstname" value="<% out.print(selectedStudent.getFirstname()); %>">
					<br>
					<label for="modify_lastname">Nom<br></label>
					<input type=text" name="lastname" id="modify_lastname" value="<% out.print(selectedStudent.getLastname()); %>">
					<br>
					<label for="modify_email">Email<br></label>
					<input type=email name="email" id="modify_email" value="<% out.print(selectedStudent.getEmail()); %>">
					<br>
					<label for="modify_function">Fonction<br></label>
					<select name="function" id="modify_function" value="">
						<option value="student" selected>Etudiant</option>
						<option value="teacher">Professeur</option>
						<option value="admin">Administrateur</option>
					</select>
					<br>
					<label for="modify_admission_score">Score d'admission<br></label>
					<input type=text" name="admission_score" id="modify_Admission_score" value="<% out.print(selectedStudent.getAdmission_score()); %>">
					<br>
					<label for="modify_completed_courses">Quiz complétés<br></label>
					<input type=text" name="completed_courses" id="modify_completed_courses" value="<% out.print(selectedStudent.getCompleted_courses()); %>">
					<br>
					<label for="modify_corrected_courses">Cours corrigés<br></label>
					<input type=text" name="corrected_courses" id="modify_corrected_courses" value="<% out.print(selectedStudent.getCorrected_courses()); %>">
					<br>
					<label for="modify_graduate">Diplomé<br></label>
					<select name="graduate" id="modify_graduate">
						<option value=1 <% out.print( selectedStudent.isGraduate()?" selected = selected":""); %>>OUI</option>
						<option value=0 <% out.print( !selectedStudent.isGraduate()?" selected = selected":""); %>>NON</option>
					</select>
					<input type="hidden" name="id" value="<% out.print(selectedStudent.getId()); %>">
					<br>
				<% } else { %>
					<label for="modify_firstname">Prénom<br></label>
					<input type=text" name="firstname" id="modify_firstname" value="<% out.print(selectedUser.getFirstname()); %>">
					<br>
					<label for="modify_lastname">Nom<br></label>
					<input type=text" name="lastname" id="modify_lastname" value="<% out.print(selectedUser.getLastname()); %>">
					<br>
					<label for="modify_email">Email<br></label>
					<input type=email name="email" id="modify_femail" value="<% out.print(selectedUser.getEmail()); %>">
					<br>
					<label for="modify_function">Fonction<br></label>
					<select name="function" id="modify_function">
						<option value="teacher" <% out.print( selectedUser.getFunction().equals("teacher")?" selected = selected":""); %>>Professeur</option>
						<option value="admin" <% out.print( selectedUser.getFunction().equals("admin")?" selected = selected":""); %>>Administrateur</option>
					</select>
					<br>
					<input type="hidden" name="id" value="<% out.print(selectedUser.getId()); %>">
				<% } %>
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