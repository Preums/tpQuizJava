<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="css/quiz.css">
		<title>Admin Page</title>
	</head>
	<body>
		<%@ include file="banner.jsp" %>
		<div class="main row full_width">
			<nav class="col p1 m1">
				<%@ include file="menu.jsp" %>
			</nav>				 
			<main class="main_col p1 m1">	
			<h2>Bienvenue sur votre espace d'administration</h2>
				<p class="para text p1 m1">	
					Vous pouvez consulter la liste des élèves en cliquant <a href="listing?user=student"><button>Ici</button></a>
				</p>
				<p class="para text p1 m1">	
					Vous pouvez consulter la liste des employés en cliquant <a href="listing?user=employee"><button>Ici</button></a>
				</p>
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