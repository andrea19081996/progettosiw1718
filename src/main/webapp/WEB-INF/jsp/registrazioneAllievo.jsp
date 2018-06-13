<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/css/default.css" >
<link rel="stylesheet" href="/css/extra.css" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrazione Allievo</title>
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
					<li class="active"><a href="/registrazioneAllievo">Nuovo allievo</a></li>
					<li><a href="/cercaAllievo">Cerca allievo</a></li>
					<li><a href="/iscriviAllievo">Iscrizione attivita'</a></li>
					<li><a href="/nuovaAttivita">Nuova attivita'</a></li>
					<li><a href="/fivethCase">5CASO D'USO</a></li>
				</ul>
				
			</div>
			
		</div>
		
		<div id="banner" class="container">
			<div class="title">
				<h2>Registrazione Allievo</h2>
				<span class="byline">Registra un nuovo allievo in un'attività nello spazio sotto.</span>
			</div>
		</div>
	</div>
	
		<div id="wrapper">
		<div id="three-column" class="container">
			<div class="title">
				<h2>Inserisci i dati del nuovo allievo</h2>
				<span class="byline">Nello spazio sottostante scrivi i dati dello studente</span>
			</div>
			<br>
			
			<form:form action="makeRegistration" modelAttribute="allievo" class="">
				* I campi contrassegnati da questo simbolo sono obbligatori.
				<br><br>
				Nome*: <form:input path="nome" />
				<span class="error"> <form:errors path="nome" /> </span>
				
				<br><br>
				
				Cognome*: <form:input path="cognome" />
				<span class="error"> <form:errors path="cognome" /> </span>
				
				<br><br>
				
				Email*: <form:input path="email" />
				<span class="error"> <form:errors path="email" /> </span>
				
				<br><br>
				
				Telefono*: <form:input path="telefono" />
				<span class="error"> <form:errors path="telefono" /> </span>
				
				<br><br>
				
				Data di nascita* : <form:input type="date" path="dataNascita" />
				<span class="error"> <form:errors path="dataNascita" /> </span>
				
				<br><br>
				
				Luogo di Nascita*: <form:input path="luogoNascita" />
				<span class="error"> <form:errors path="luogoNascita" /> </span>
								
				<br><br>
				
				<!-- Modificare css come pulsante blu -->
				<span class"error"> ${esiste} </span>
				
				<br><br>
				<!--  per far venire come pulsante in alto agg js per mandare comando di login -->
				<input type="submit" value="Registra" class=""/>
			</form:form>	
		</div>
	</div>
	
	<!-- FOOTER -->
	<div id="copyright" class="container">
		<p>Sito realizzato come progetto per Sistemi informativi sul web 2017/2018 - Davide Bersani e Andrea Apicella</p>
	</div>
	
	</body>
</html>