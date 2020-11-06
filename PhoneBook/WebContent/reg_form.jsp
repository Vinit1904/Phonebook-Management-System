<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/Register.css" rel="stylesheet">
<style type="text/css">
body
{
    color: white;
     background-image:linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.3)), url('${pageContext.request.contextPath}/resources/images/5.jpg');
    background-size: cover;   
}

</style>
</head>
<body>
	
    <div class="signup">
     <spr:form action="reg_form.htm" method="post" commandName="user" >
            <h2><u>Sign Up</u></h2>
           <spr:input path="firstName"  placeholder="Enter Firstname"/>
           <font color="red" ><spr:errors path="firstName" ></spr:errors></font>
			<br>
          <spr:input path="lastName"  placeholder="Enter Lastname"/>
          <font color="red" ><spr:errors path="lastName" ></spr:errors></font>
<br>
            <spr:input path="emailId"  placeholder="Enter email"/>
            <font color="red" ><spr:errors path="emailId" ></spr:errors></font>
<br>
            <spr:password path="userPass"  placeholder="Enter Password"/>
            <font color="red" ><spr:errors path="userPass" ></spr:errors></font>
<br>
           
           <font color="red" ><spr:errors path="confirmPass" ></spr:errors></font>
           <spr:password path="confirmPass"  placeholder="Enter Confirm password"/>
<br>
			 <br>
           
            <input type="submit"   value="Register" class="btn btn-warning">
                    <br><br>
             <div class="col-md-12 text-center">
                      	<a href="prep_log_form.htm" class="btn btn-success">Login</a>
                      	<a href="index.jsp" class="btn btn-danger"">Back</a> 

                        
                    </div>
	
          
        </spr:form>
    </div>
	
	
</body>
</html>