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
<title>Registrazione Allievo</title>
</head>
<body>
	<!-- HEADER -->
	<div id="header-wrapper">
		<div id="header" class="container">
		
				<div id="logo">
							<h1>Benvenuto <a href="">Ragazzo</a></h1>
							
<%-- 						<h1>Benvenuto <a href="#">${responsabileLoggato.email }</a></h1> --%>
				</div>
					
			<div id="menu">
			
				<ul>
					<li><a href="/index">Homepage</a></li>
					<% if(session.getAttribute("responsabileLoggato") == null) { %>
						<li><a href="/login">Login</a></li>
					<% }else { %>
						<li><a href="/logout">Logout</a></li>
					<%} %>
					<li class="active"><a href="/registrazioneAllievo">Nuovo allievo</a></li>
					<li><a href="/cercaAllievo">Cerca allievo</a></li>
					<li><a href="/iscriviAllievo">Iscrizione attivita'</a></li>
					<li><a href="/fourthCase">4CASO D'USO</a></li>
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
				<h2>Login</h2>
				<span class="byline">In questa pagina verranno descritti i casi d'uso e un collegamento per il login.</span>
			</div>
			<br>
			
			<form:form action="makeRegistration" modelAttribute="allievo" class="">
				* I campi contrassegnati da questo simbolo sono obbligatori.
				Nome*: <form:input path="nome" />
				<form:errors path="nome" cssClass="error" />
				<span class="error">${name_error}</span>
				
				Cognome*: <form:input path="cognome" />
				<form:errors path="cognome" cssClass="error" />
				<span class="error">${cognome_error}</span>
				
				<br><br>
				
				Email*: <form:input path="email" />
				<form:errors path="email" cssClass="error" />
				<span class="error">${email_error}</span>
				
				Telefono*: <form:input path="telefono" />
				<form:errors path="telefono" cssClass="error" />
				<span class="error">${telefono_error}</span>
				
				<br><br>
				
				Data di nascita* (MM-GG-AAAA): <form:input path="dataNascita" />
	 			<form:errors path="dataNascita" cssClass="error" />
				<span class="error">${dataNascita_error}</span>
				
				Luogo di Nascita*: <form:input path="luogoNascita" />
				<form:errors path="luogoNascita" cssClass="error" />
				<span class="error">${luogoNascita_error}</span>
				
				<br><br>
				
				<!-- Modificare css come pulsante blu -->
				
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