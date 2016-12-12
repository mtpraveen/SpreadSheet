<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<h2><center>IPL2016</center></h2><br>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <center>
<div style="border: 1px solid #ccc;border-color:white;padding:5px;margin-bottom:20px;">
 
  <center><a href="${pageContext.request.contextPath}/indexPage">Home</a>
 
  | &nbsp;
  <a href="${pageContext.request.contextPath}/signupPage">SignUp</a>
  
     | &nbsp;
     <a href="${pageContext.request.contextPath}/addTeam">AddPlayers</a>
  
  | &nbsp;
  <a href="${pageContext.request.contextPath}/teamList">ViewTeams</a>
  
  | &nbsp;
  <a href="${pageContext.request.contextPath}/logout">Logout</a>
     
  
  </center>
  
</div>
 <body bgcolor="LightBlue">
<style>
table
{
padding:20px;
align:center;
}
/*tr{
float:left;
padding-left:95px; 
}*/
</style>
<h2> ${msg} Player Information </h2>
<table border="2" bordercolor="black" cellpadding="10px" bgcolor="whiteSmoke" 
	cellspacing="10px" align="left">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>DisplayPicture</th>
		<th>Role</th>
		<th>BattingStyle</th>
		<th>BowlingStyle</th>
		<th>Nationality</th>
		<th>Dob</th>
        <th>TeamId</th>
	</tr>
	<c:forEach var="player" items="${playerDetails}">
		<tr>
			<td>${player.id}</td>
			<td>${player.name}</td>
			<td><img src="${player.displayPicture}" height="100" width="200" alt="image not found"/></td>
			<td>${player.role}</td>
			<td>${player.battingStyle}</td>
			
			<td>${player.bowlingStyle}</td>
			<td>${player.nationality}</td>
			<td>${player.dob}</td>
			<td>${player.teamId}</td>
			</tr>
	</c:forEach>
</table>
</body>
</html>