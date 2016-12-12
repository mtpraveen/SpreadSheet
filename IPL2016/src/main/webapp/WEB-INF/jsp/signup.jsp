<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <h2><center>IPL2016</center></h2><br>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <center>
<div style="border: 1px solid #ccc;border-color:white;padding:5px;margin-bottom:20px;">
 
  <center><a href="${pageContext.request.contextPath}/indexPage">Home</a>
 
  | &nbsp;
  
   <a href="${pageContext.request.contextPath}/loginPage">Login</a>
  

  
  </center>
  
</div>
   
    <body bgcolor="LightBlue">
    <form:form method="post" action="saveUser" commandName="user">
            <center>
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2"><center>Registration</center></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" value="" required="required" placeholder="Name" /></td>
                    </tr>
                    
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" required="required" placeholder="Email"/></td>
                    </tr>
                    
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" required="required" placeholder="Password"/></td>
                    </tr>
                    <tr>
                        <td>Mobile Number</td>
                        <td><input type="number" name="mobile" value="" required="required" placeholder="Mobile"/></td>
                    </tr>
                    <tr>
                        <td>City</td>
                        <td><input type="text" name="city" value="" required="required"/ placeholder="City"></td>
                    </tr>
                    <tr>
                        <td>Country</td>
                        <td><input type="text" name="country" value="" required="required"/ placeholder="Country"></td>
                    </tr>
                    <tr>
                       
                        <td><input type="reset" value="Reset" /></td>
                         <td><input type="submit" value="Submit" /></td>
                    </tr>
                     <!-- <tr>
                        <td colspan="2">Already registered!! <a href="login.jsp">Login Here</a></td>
                    </tr> --> 
                </tbody>
            </table>
            </center>
        </form:form>
    </body>
</html>
