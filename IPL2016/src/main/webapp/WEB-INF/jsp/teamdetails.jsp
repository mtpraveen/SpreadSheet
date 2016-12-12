<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
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
  <a href="${pageContext.request.contextPath}/addPlayer">AddPlayers</a>
  
  | &nbsp;
  <a href="${pageContext.request.contextPath}/teamList">ViewTeams</a>
  
  | &nbsp;
  <a href="${pageContext.request.contextPath}/logout">Logout</a>
     
  
  </center>
  
</div>
   
    <body bgcolor="LightBlue">
<img src="https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTcJSq9-FmBpnnMSExHyMSEg4wtMaiezeRl8Hj2c4jtQCOK9QjjOA" alt="image not found" width="600" height="auto" />
</body>
</html>