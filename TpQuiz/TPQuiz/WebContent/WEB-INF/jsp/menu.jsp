<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String permission = (String) request.getAttribute("permission"); %>
<ul class="menu">
	<% if(permission!=null && (permission.equals("student") || permission.equals("teacher")|| permission.equals("admin"))) { %>
	<a href="/TPQuiz/student"><li class="menu_item p1" >Espace étudiant</li></a>
	<% }
		if(permission!=null && (permission.equals("teacher")|| permission.equals("admin"))) {
	%>
	<a href="/TPQuiz/teacher"><li class="menu_item p1" >Espace formateur</li></a>
	<% }
		if (permission!=null && (permission.equals("admin"))) { %>
	<a href="/TPQuiz/admin"><li class="menu_item p1" >Espace administration</li></a>
	<% } %>
</ul>