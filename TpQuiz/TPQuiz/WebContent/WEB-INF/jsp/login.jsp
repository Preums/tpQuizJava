<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="login.User" %>
<% String user = (String) request.getAttribute("loggedUser"); %>
<% if (user != null) { %>
	<div class="para p1 m1" >
		<p><% out.println(user); %></p>
		<p>
			<a href="/TPQuiz/deconnect" alt="Déconnexion" ><button>Déconnexion</button></a>
		</p>
	</div>
	<% } else { %>
<form class="ident" method="post" action="LoginCtrl">
	<label>Identifiez vous:</label>
	<br>
	<label for="email">Email: 
	<br>
	<input type="email" name="email" placeholder="adresse email" required /></label>
	<br>
	<label for="password">Mot de passe: 
	<br>
	<input type="password" name="password" placeholder="mot de passe" required /></label>
	<br>
	<input type="submit" value="envoyer" />
</form>
<% } %>
	<p>
		<% if(user != null && user.equals("Identification invalide")) {
			out.println(user);
		}%>
	</p>