<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Game Finish</title>
</head>
<body>
	<center>
		<br> <br>
		<%@page import="game.controller.GameLogic"%>
		<h2>You Iterated <%= GameLogic.getTotalLimit() %> times, so Game is Finished</h2>
		<br> <br>
	</center>
</body>
</html>