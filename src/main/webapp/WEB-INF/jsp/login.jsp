<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- per form -->
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Sofia'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="/css/special.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="/css/util.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">
<!--===============================================================================================-->
<link rel="stylesheet" href="/css/default.css">
<link rel="stylesheet" href="/css/extra.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HOME</title>
</head>
<body>
	<!-- HEADER -->
	<div id="header-wrapper">
		<div id="header" class="container">
			<%
				if (session.getAttribute("responsabileLoggato") != null) {
			%>
			<div id="logo">
				<h1>
					<a href="#">Benvenuto ${responsabile.email }</a>
				</h1>
			</div>
			<%
				}
			%>
			<div id="menu">

				<ul>
					<li><a href="/index">Homepage</a></li>
					<%
						if (session.getAttribute("responsabileLoggato") == null) {
					%>
					<li class="active"><a href="/login">Login</a></li>
					<%
						} else {
					%>
					<li><a href="/logout">Logout</a></li>
					<%
						}
					%>
					<li><a href="/registrazioneAllievo">Nuovo allievo</a></li>
					<li><a href="/cercaAllievo">Cerca allievo</a></li>
					<li><a href="/iscriviAllievo">Iscrizione attivita'</a></li>
					<li><a href="/nuovaAttivita">Nuova attivita'</a></li>
					<li><a href="/scegliCentro">Controlla attività</a></li>
				</ul>
			</div>
		</div>
		<div id="banner" class="container">
			<div class="title">
				<h2>SIGECA</h2>
				<span class="byline">Sistema per la Gestione di Centri e
					Attività</span>
			</div>
		</div>
	</div>

	<div id="wrapper">
		<div id="three-column" class="container">

			<div id="special">
				<div class='login'>
					<h2>Login</h2>
					<input name='email' placeholder='E-Mail Address' type='text'>
					<input id='pw' name='password' placeholder='Password' type='password'>

					<input class='animated' type='submit' value='Register'>
				</div>
			</div>


			<!--	<form name="f" action="/login" method="post">
			<div>
				<label>Email : <input type="text" name="username" /></label>
			</div>
			<br>
			<div>
				<label>Password: <input type="password" name="password" /></label>
			</div>
			<br>
			<div>
				<br>
				<input type="submit" value="Entra" class="enter_button" />
			</div>
		</form>	   -->
			<br> <span>Oppure effettua il login con </span> <br> <br>
			<c:forEach var="url" items="${urls}">
				<div id="login-google">
					<a href="${url.value}"><img src="/images/search.png" /></a>
				</div>
			</c:forEach>

		</div>
	</div>

	<!-- FOOTER -->
	<div id="copyright" class="container">
		<p>Sito realizzato come progetto per Sistemi informativi sul web
			2017/2018 - Davide Bersani e Andrea Apicella</p>
	</div>

</body>
</html>