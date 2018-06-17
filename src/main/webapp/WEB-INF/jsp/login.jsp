<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/css/default.css" >
<link rel="stylesheet" href="/css/extra.css" >
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
					<li><a href="/nuovaAttivita">Nuova attivita'</a></li>
					<li><a href="/scegliAttivita">Controlla attività</a></li>
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
			
			<form name="f" action="/login" method="post">
			<div>
				<label>Email : <input type="text" name="username" /></label>
			</div>
			<br>
			<div>
				<label>Password: <input type="password" name="password" /></label>
			</div>
			<br>
			<div>
				<input type="submit" value="Entra" class="enter_button" />
			</div>
		</form>	
		</div>
	</div>
	
	<!-- FOOTER -->
	<div id="copyright" class="container">
		<p>Sito realizzato come progetto per Sistemi informativi sul web 2017/2018 - Davide Bersani e Andrea Apicella</p>
	</div>
	
	</body>
</html>