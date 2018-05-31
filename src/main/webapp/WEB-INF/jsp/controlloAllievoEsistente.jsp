<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/css/default.css" >
<link rel="stylesheet" href="/resources/css/extra.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Controlla Allievo</title>
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
					<li ><a href="index">Homepage</a></li>
					<% if(session.getAttribute("responsabileLoggato") == null) { %>
						<li><a href="login">Login</a></li>
					<% }else { %>
						<li><a href="logout">Logout</a></li>
					<%} %>
					<li><a href="firstCase">1CASO D'USO</a></li>
					<li class="active"><a href="cercaAllievo">2CASO D'USO</a></li>
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
				<h2>Controllo Allievo</h2>
				<span class="byline">Inserisci l'email di un allievo per controllare se già è registrato al sistema.</span>
			</div>
		</div>
		<div class="content">
			<form action="controllaAllievo" method="get">
					
					<!-- mettere email e pass allineate -->
					
					Email: <input type="text" name="email" />
					
					<!-- Modificare css come pulsante blu -->
					
					<!--  per far venire come pulsante in alto agg js per mandare comando di login -->
					<input type="submit" value="Cerca" class="enter_button"/>
				</form>	
			
				
				<span class="error-message">${messaggioErrore}</span>
				
				<br><br>
				<span class="simple_text">${messaggio} <br><br>${allievoCercato }</span>
			</div>
	</div>
	
	<!-- FOOTER -->
	<div id="copyright" class="container">
		<p>Sito realizzato come progetto per Sistemi informativi sul web 2017/2018 - Davide Bersani e Andrea Apicella</p>
	</div>
	
	</body>
</html>