<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<style>
table
{
padding:20px;
}
</style>
 <h2><center>IPL2016</center></h2><br>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <center>
<div style="border: 1px solid #ccc;border-color:white;padding:5px;margin-bottom:20px;">
 
  <center><a href="${pageContext.request.contextPath}/indexPage">Home</a>
 
  | &nbsp;
  
   
 <%--  <a href="${pageContext.request.contextPath}/teamList">ViewTeams</a>
  
  | &nbsp; --%>
  
 	<a href="${pageContext.request.contextPath}/signupPage">SignUp</a>
 	 	 | &nbsp;
 	<a href="${pageContext.request.contextPath}/addTeam">AddTeam</a>
  
  | &nbsp;
  <a href="${pageContext.request.contextPath}/addPlayer">AddPlayers</a>
  
  | &nbsp;
 	 	 <a href="${pageContext.request.contextPath}/teamList">ViewTeams</a>
  
  | &nbsp;
 		<right><a href="${pageContext.request.contextPath}/logout">Logout</a>
     | &nbsp;</right>
  </center>
  
</div>
   
 <body bgcolor="LightBlue">
<h2> ${msg}</h2>
<table border="2" bordercolor="black" cellpadding="10px" bgcolor="whiteSmoke"
	cellspacing="10px" align="left">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Coach</th>
		<th>Owner</th>
		<th>Captain</th>
		<th>Logo</th>
		<th>HomeVenue</th>
		<th>ViewPlayers</th>

	</tr>
	<c:forEach var="team" items="${teamDetails}">
		<tr>
			<td>${team.id}</td>
			<td>${team.name}</td>
			<td>${team.coach}</td>
			<td>${team.owner}</td>
			<td>${team.captain}</td>
			<td><img src="${team.logo}" height="100" width="200" alt="image not found"/></td>
			<td>${team.homeVenue}</td>
			<td><a href="< c:url value="players"/>?teamId=${team.id}">ViewPlayers</a></td>
				
		</tr>
	</c:forEach>
</table>
</body>
</html>