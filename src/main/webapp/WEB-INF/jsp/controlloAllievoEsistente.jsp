<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/css/util.css">
	<link rel="stylesheet" type="text/css" href="/css/main.css">
<!--===============================================================================================-->
<link rel="stylesheet" href="/css/default.css" >
<link rel="stylesheet" href="/css/extra.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Controlla Allievo</title>
</head>
<body>
	<!-- HEADER -->
	<div id="header-wrapper">
		<div id="header" class="container">
			<sec:authorize access="isAuthenticated()"> 
				<div id="logo">
						<h1>Benvenuto <a href="#"><sec:authentication property="principal.username" /></a></h1>
					</div>
			</sec:authorize>
			<div id="menu">
			
				<ul>
					<li><a href="/index">Homepage</a></li>
					<sec:authorize access="isAuthenticated()"> 
						<form action="/logout" method="post" class="logout">
						  <input type="submit" value="LOGOUT" class="logout"/>
						</form>
					</sec:authorize>
					<li><a href="/registrazioneAllievo">Nuovo allievo</a></li>
					<li class="active"><a href="/cercaAllievo">Cerca allievo</a></li>
					<li><a href="/iscriviAllievo">Iscrizione attivita'</a></li>
					<li><a href="/nuovaAttivita">Nuova attivita'</a></li>
					<li><a href="/scegliCentro">Controlla attività</a></li>
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
			
		
			<form action="controllaAllievo" method="get">
					
					<!-- mettere email e pass allineate -->
					
					Email: <input type="text" name="email" />
					
					<!-- Modificare css come pulsante blu -->
					
					<!--  per far venire come pulsante in alto agg js per mandare comando di login -->
					<input type="submit" value="Cerca" class="enter_button"/>
				</form>	
			
				
				<span class="error-message">${messaggioErrore}</span>
				
				<br><br>
				
				<span class="simple_text">${messaggio} 
				<br><br>
				<c:if test="${allievoCercato !=null}">
					<table class="blueTable">
						<thead>
							<tr>
								<td>Nome</td>
								<td>Cognome</td>
								<td>Email</td>
								<td>Telefono</td>
								<td>Data di nascita</td>
								<td>Luogo di nascita</td>
							</tr>
						</thead>
						<tr>
							<td>${allievoCercato.nome }</td>
							<td>${allievoCercato.cognome }</td>
							<td>${allievoCercato.email }</td>
							<td>${allievoCercato.telefono }</td>
							<td>${allievoCercato.dataNascita }</td>
							<td>${allievoCercato.luogoNascita }</td>
						</tr> 
					</table>
				</c:if>
				</span>
			</div>
		</div>
	</div>
	
	<!-- FOOTER -->
	<div id="copyright" class="container">
		<p>Sito realizzato come progetto per Sistemi informativi sul web 2017/2018 - Davide Bersani e Andrea Apicella</p>
	</div>
	
	</body>
</html>