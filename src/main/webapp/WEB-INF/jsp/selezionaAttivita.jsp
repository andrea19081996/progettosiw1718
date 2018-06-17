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
<title>Seleziona attivita'</title>
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
					<li ><a href="/index">Homepage</a></li>
					<sec:authorize access="isAuthenticated()"> 
						<form action="/logout" method="post" class="logout">
						  <input type="submit" value="LOGOUT" class="logout"/>
						</form>
					</sec:authorize>
					<li><a href="/registrazioneAllievo">Nuovo allievo</a></li>
					<li><a href="/cercaAllievo">Cerca allievo</a></li>
					<li class="active"><a href="/iscriviAllievo">Iscrizione attivita'</a></li>
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
				<h2>Iscrizione attività</h2>
				<span class="byline">Seleziona un'attività.</span>
			</div>
			<span class="simple_text">
				E' stato selezionato l'allievo seguente:<br> 
				<strong>${allievoSelezionato.nome } ${allievoSelezionato.cognome }</strong> - Email: ${allievoSelezionato.email } <br><br>
				Posti disponibili per oggi: ${postiDisponibili }<br>
				Seleziona l'attività a cui iscrivere l'allievo:
				<c:if test="${listaAttivita.size() == 0 }">
					<span class="error">Attenzione! Non ci sono attività disponibili per oggi!</span>
				</c:if>
				<br><br>
				<table class="blueTable">
					<thead>
						<tr>
							<td>Nome</td>
							<td>Data</td>
							<td>Orario</td>
						</tr>
					</thead>
					<c:forEach var="a" items="${listaAttivita}">
						<tr>
							<td><a href="iscrivi/${a.id}">${a.nome}</a></td>
							<td>${a.data }</td>
							<td>${a.orario }</td>
						</tr>
					</c:forEach>
				</table>
			</span>
		</div>
	</div>
	
	<!-- FOOTER -->
	<div id="copyright" class="container">
		<p>Sito realizzato come progetto per Sistemi informativi sul web 2017/2018 - Davide Bersani e Andrea Apicella</p>
	</div>
	
	</body>
</html>