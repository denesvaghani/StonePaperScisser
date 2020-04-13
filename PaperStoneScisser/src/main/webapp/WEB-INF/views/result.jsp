<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result of Game</title>
</head>
<body>
	<%@ page import="game.model.StonePaperScisser.Game,game.controller.GameLogic"%>
	<%
	
		Game[] guesses = (Game[]) request.getAttribute("guess");
		int[][] result = (int[][]) request.getAttribute("result");
		
		
	%>
	<center>
		<br>
		<%
			int totalPlayer = result[0].length;
		%>
		<table>
			<tr>
				<%
					for (int i = 0; i < totalPlayer; i++) {
				%>
				<td style="width: 80px"><center>
						&nbsp;&nbsp;&nbsp; <b>Player <%=i + 1%></b>
					</center></td>

				<%
					}
				%>
			</tr>
			<tr>
				<%
					for (int i = 0; i < totalPlayer; i++) {
				%>
				<td style="hight: 80px; width: 80px"><center>
						&nbsp;&nbsp;&nbsp;
						<%
							if (guesses[i] == Game.SCISSORS) {
						%>
						<img alt="Scissor"
							src="C:\Users\ADMIN\eclipse-workspace\PaperStoneScisser\src\main\webapp\WEB-INF\imgs\scisser.png"
							height="49px" width="49px">
						<%
							} else if (guesses[i] == Game.ROCK) {
						%>
						<img alt="Rock"
							src="C:\Users\ADMIN\eclipse-workspace\PaperStoneScisser\src\main\webapp\WEB-INF\imgs\rock.png"
							height="49px" width="49px">
						<%
							} else {
						%>
						<img alt="Paper"
							src="C:\Users\ADMIN\eclipse-workspace\PaperStoneScisser\src\main\webapp\WEB-INF\imgs\paper.png"
							height="49px" width="49px">
						<%
							}
						%>
					</center></td>

				<%
					}
				%>
			</tr>
		</table>
		<br> <br>
		<table style="border: 1px solide black">
			<%
				for (int i = 0; i <= totalPlayer; i++) {

					if (i == 0) {
			%>
			<th></th>
			<%
				continue;
					} else {
			%>
			<th>&nbsp;&nbsp;&nbsp;Player <%=i%>
			</th>
			<%
				}
				}
			%>
			<%
				for (int j = 1; j <= totalPlayer; j++) {
			%>
			<tr>
				<%
					for (int k = 0; k <= totalPlayer; k++) {
							if (k == 0) {
				%>
				<td>&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<b>Player <%=j%></b></td>
				<%
					} else if (k == j) {
				%>
				<td>&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; <%="-"%></td>
				<%
					} else {
				%>
				<td>&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; <%=result[j - 1][k - 1]%></td>
				<%
					}
						}
				%>
			
			<tr>
				<%
					}
				%>
			
		</table>
		<br> <br> Iteratations
		<% out.print(request.getAttribute("iteration"));%>
		out of <%= GameLogic.getTotalLimit() %>
	</center>
	<br>
	<br>
	<br>
	<br>
	<center>
		<table>
			<tr>
				<td>
					<form action="iterate" method="post">
						<input type="submit" value="Next Iteration" />
					</form>
				</td>
				<td>
					<form action="index.jsp" method="post">
						<input type="submit" value="Exit" />
					</form>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>