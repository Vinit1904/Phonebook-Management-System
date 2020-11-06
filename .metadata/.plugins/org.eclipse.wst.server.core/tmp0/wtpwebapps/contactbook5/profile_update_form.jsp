<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="com.cdac.dto.User"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Update</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/profileupdate.css" rel="stylesheet">
<style type="text/css">
body
{
    
     background-image:linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.3)), url('${pageContext.request.contextPath}/resources/images/5.jpg');
    background-size: cover;   
}

</style>
</head>
<body>
		<div class="row bg-dark justify-content-between align-items-center sticky-top" style="height: 60px;">
            <div class="col-3 text-light" style="font-size: 24px;">
                <img class="logo" src="${pageContext.request.contextPath}/resources/images/8.png" 
 
 				style="width: 150px;height: 40px;"/>
            </div>

            <div class="col-6 d-flex justify-content-end align-items-center">

                <a class="btn btn-outline-warning mr-3">Welcome <%=(session.getAttribute("user")!=null) ? ((User)session.getAttribute("user")).getFirstName() : "!!!!!!!!" %> </a>
                <a href="logout.htm"  class="btn btn-outline-warning mr-3">Logout</a>
              <a href="profile_show.htm"  class="btn btn-outline-warning mr-3" >Back</a>
              
            </div>
       	 </div>
       	
		
<% 
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0);
	%>
	<div class="signup">
	<spr:form action="update_user_profile.htm" method="post" commandName="user" >
	<h2><u>Update Profile</u></h2>

				<spr:hidden path="userId"/>	
			
				<spr:input path="firstName"/>
		
				<spr:input path="lastName"/>
		
			
				<spr:input path="emailId"/>
		
				<spr:input path="userPass"/>
	
			<spr:input path="confirmPass"/>
			<br>
				<spr:hidden path="roll"/>
				<div class="col-md-12 text-center">
                      	   <a href=""><input type="submit"  value="Update Profile"  class="btn btn-warning"></a>
                 </div>
				
		
	</spr:form>

</body>
</html>