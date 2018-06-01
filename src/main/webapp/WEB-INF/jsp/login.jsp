<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/css/default.css" >
<link rel="stylesheet" href="/resources/css/extra.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME</title>
</head>
<body>
	<!-- HEADER -->
	<div id="header-wrapper">
		<div id="header" class="container">
			<% if(session.getAttribute("responsabileLoggato") != null) { %>
				<div id="logo">
						<h1>Benvenuto<a href="#">${responsabileLoggato.email}</a></h1>
					</div>
			<% } %>
			<div id="menu">
			
				<ul>
					<li><a href="/index">Homepage</a></li>
					<% if(session.getAttribute("responsabileLoggato") == null) { %>
						<li class="active"><a href="/login">Login</a></li>
					<% }else { %>
						<li><a href="/logout">Logout</a></li>
					<%} %>
					<li><a href="/registrazioneAllievo">Nuovo allievo</a></li>
					<li><a href="/cercaAllievo">Cerca allievo</a></li>
					<li><a href="/iscriviAllievo">Iscrizione attivita'</a></li>
					<li><a href="/fourthCase">4CASO D'USO</a></li>
					<li><a href="/fivethCase">5CASO D'USO</a></li>
				</ul>
			</div>
		</div>
		<div id="banner" class="container">
			<div class="title">
				<h2>SIGECA</h2>
				<span class="byline">Sistema per la Gestione di Centri e Attività</span>
			</div>
		</div>
	</div>
	
	<div id="wrapper">
		<div id="three-column" class="container">
			<div class="title">
				<h2>Login</h2>
				<span class="byline">In questa pagina verranno descritti i casi d'uso e un collegamento per il login.</span>
			</div>
			<br>
			
			<form:form action="makeLogin" modelAttribute="responsabile" class="login-form">
				<!--  messo dentro error-message per spostarlo insieme agli input -->
				<span class="error-message">${error}</span>
				
				<!-- mettere email e pass allineate -->
				
				Email: <form:input path="email" />
				
				<br><br>
				
				Password: <form:password path="password" />
				
				<br><br>
				
				<!-- Modificare css come pulsante blu -->
				
				<!--  per far venire come pulsante in alto agg js per mandare comando di login -->
				<input type="submit" value="Login" class="enter_button"/>
			</form:form>	
		</div>
	</div>
	
	<!-- FOOTER -->
	<div id="copyright" class="container">
		<p>Sito realizzato come progetto per Sistemi informativi sul web 2017/2018 - Davide Bersani e Andrea Apicella</p>
	</div>
	
	</body>
</html>