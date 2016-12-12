<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example</title>
    </head>
    <body bgcolor="LightBlue">
    <h2><center>IPL2016</center></h2><br>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <center>
<div style="border: 1px solid #ccc;border-color:white;padding:5px;margin-bottom:20px;">
 
  <center><a href="${pageContext.request.contextPath}/indexPage">Home</a>
 
  | &nbsp;
  
  <%--  <a href="/loginPage">Login</a>
  
  | &nbsp; --%>
  
  <a href="${pageContext.request.contextPath}/signupPage">SignUp</a>

  </center>
  
</div>
        <form method="post" action="login">
            <center>
            <table border="0" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="Email" required="required" placeholder="Email" value="" autofocus="autofocus"  /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="Password"  required="required" placeholder="Password" value=""  /></td>
                    </tr>
                    <tr>
                        
                        <td><input type="reset" value="Reset" /></td>  <td><input type="submit" value="Login" /></td>
                    </tr>
                     <!-- <tr>
                        <td colspan="2">New User <a href="signup.jsp">Register Here</a></td>
                    </tr>  -->
                </body>
            </table>
            </center>
        </form>
    </body>
</html>
