<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<style>
tr{
float:left;
padding-left:95px; 
}
</style>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <h2><center>IPL2016</center></h2><br>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <center>
<div style="border: 1px solid #ccc;border-color:white;padding:5px;margin-bottom:20px;">
 
  <center><a href="${pageContext.request.contextPath}/indexPage">Home</a>
 
  | &nbsp;
  
   <a href="${pageContext.request.contextPath}/addTeam">AddTeam</a>
  
  | &nbsp;
 <%--  <a href="${pageContext.request.contextPath}/teamList">ViewTeams</a>
  
  | &nbsp; --%>
  
 	 	<a href="${pageContext.request.contextPath}/signupPage">SignUp</a>
 	 	 | &nbsp;
 		<a href="${pageContext.request.contextPath}/logout">Logout</a>
     | &nbsp;
  </center>
  
</div>
   
    <body bgcolor="LightBlue">
    <center><h4>IPL Teams</h4>
<table border="2" bordercolor="black" cellpadding="10px"
	cellspacing="10px" align="left">
	<c:forEach var="team" items="${teamInfo}">
		<tr>
			<td><a href="<c:url value="teamDetails"/>?teamName=${team.name}"><img src="${team.logo}" width="150px" height="150px"/></a></td>
				
				</tr>
	</c:forEach>
</table>
</center>
</body>
</html>