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
						<h1>Benvenuto <a href="#">${responsabileLoggato.email }</a></h1>
					</div>
			<% } %>
			<div id="menu">
			
				<ul>
					<li><a href="">Homepage</a></li>
					<% if(session.getAttribute("responsabileLoggato") == null) { %>
						<li><a href="login">Login</a></li>
					<% }else { %>
						<li><a href="logout">Logout</a></li>
					<%} %>
					<li class="active"><a href="registrazioneAllievo">1CASO D'USO</a></li>
					<li><a href="secondCase">2CASO D'USO</a></li>
					<li><a href="thirthCase">3CASO D'USO</a></li>
					<li><a href="fourthCase">4CASO D'USO</a></li>
					<li><a href="fivethCase">5CASO D'USO</a></li>
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
				<h2>Registrazione completata</h2>
				<span class="byline">Complimenti la registrazione è stata effettuata con successo.</span>
				<ul>
					<li>Nome: ${allievo.nome}</li>
					<li>Cognome: ${allievo.cognome}</li>
					<li>Email: ${allievo.email}</li>
					<li>Telefono: ${allievo.telefono}</li>
					<li>Data di Nascita: ${allievo.dataNascita}</li>
					<li>Luogo di Nascita: ${allievo.luogoNascita}</li>
				</ul>
			</div>
		</div>
	</div>
	
	<!-- FOOTER -->
	<div id="copyright" class="container">
		<p>Sito realizzato come progetto per Sistemi informativi sul web 2017/2018 - Davide Bersani e Andrea Apicella</p>
	</div>
	
	</body>
</html>