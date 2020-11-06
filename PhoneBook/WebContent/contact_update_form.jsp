<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.cdac.dto.User"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Contact Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/contactUpdate.css" rel="stylesheet">
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
                <a href="contact_list.htm"  class="btn btn-outline-warning mr-3">Back</a>
            </div>
       	 </div>
       	 <br>
		
<% 
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0);
	%>
		 
		<div class="signup">

	<spr:form action="contact_update.htm" method="post" commandName="contact" >
	 <h2><u>Update Contact</u></h2>
	
			
				<spr:hidden path="contactId"  />	
				<spr:input path="name"/>
				<spr:input path="city"/>
		
				<spr:input path="primaryNum"/>
		
				<spr:input path="secondaryNum"/>
			
				<spr:input path="emailId"/>
			
				<spr:select path="label">
				 <spr:option value="Label" label="label"/>    
        		<spr:option value="Work" label="Work"/>  
        		<spr:option value="Home" label="Home"/>  
       			 <spr:option value="Other" label="Other"/>  
          
        </spr:select>
				<br><br>
				<div class="col-md-12 text-center">
                      	   <a href=""><input type="submit"   value="Update" class="btn btn-warning"></a>

                        
                    </div>
		
				
	</spr:form>
</body>
</html>