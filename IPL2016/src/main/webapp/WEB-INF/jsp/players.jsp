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
     <a href="${pageContext.request.contextPath}/addTeam">AddTeam</a>
  
  | &nbsp;
  <a href="${pageContext.request.contextPath}/teamList">ViewTeams</a>
  
  | &nbsp;
  <a href="${pageContext.request.contextPath}/logout">Logout</a>
     
  
  </center>
  
</div>
 <body bgcolor="LightBlue">
<style>
tr{
float:left;
padding-left:95px; 
}
</style>
<h4>IPL 2016 teams list</h4>
<table border="2" bordercolor="black" cellpadding="10px"
	cellspacing="10px" align="left">
	<c:forEach var="player" items="${playerInfo}">
		<tr>
			<td><a href="<c:url value="playerinfo"/>?playerName=${player.name}"><img src="${player.displayPicture}" width="150px" height="150px"/></a></td>
				</tr>
	</c:forEach>
</table>
</body>
</html>