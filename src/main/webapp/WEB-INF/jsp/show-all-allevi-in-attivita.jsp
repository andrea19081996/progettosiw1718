<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>HOME</title>
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
					<li><a href="/cercaAllievo">Cerca allievo</a></li>
					<li><a href="/iscriviAllievo">Iscrizione attivita'</a></li>
					<li><a href="/nuovaAttivita">Nuova attivita</a></li>
					<li class="active"><a href="/scegliCentro">Controlla attività</a></li>
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
				<h2> Totale Iscritti ${totale} </h2>
				<span class="byline">Elenco Allievi iscritti all'attività selezionata.</span>
				
				<br><br>
				
				<div class="table100 ver3 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Id</th>
									<th class="cell100 column2">Nome</th>
									<th class="cell100 column3">Cognome</th>
									<th class="cell100 column4">Email</th>
									<th class="cell100 column5">Data Di Nascita</th>
									
<!-- se vogliamo mettere colonna 6 modificare %  -->

								</tr>
							</thead>
						</table>
					</div>
					
					<div class="table100-body js-pscroll">
						<table>
							<tbody>
								<c:forEach var="temp" items="${allievi}" >
									<tr class="row100 body">
										<td class="cell100 column1">${temp.id}</td>
										<td class="cell100 column2">${temp.nome}</td>
										<td class="cell100 column3">${temp.cognome}</td>
										<td class="cell100 column4">${temp.email}</td>
										<td class="cell100 column5">${temp.dataNascita}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
					
			<!--	<table>
				
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Email</th>
						<th>Data Di Nascita</th>
						<th>Luogo Di Nascita</th>
					</tr>
					<br><br>
					<c:forEach var="temp" items="${allievi}" >
						<tr>
							<td><span>${temp.id}</span></td>
							<td><span>${temp.nome}</span></td>
							<td><span>${temp.cognome}</span></td>
							<td><span>${temp.email}</span></td>
							<td><span>${temp.dataNascita}</span></td>
							<td><span>${temp.luogoNascita}</span></td>
						</tr>
						<br>
					</c:forEach>
				
				</table>   -->
			</div>
		</div>
	</div>
	
	<!-- FOOTER -->
	<div id="copyright" class="container">
		<p>Sito realizzato come progetto per Sistemi informativi sul web 2017/2018 - Davide Bersani e Andrea Apicella</p>
	</div>
	
	</body>
</html>