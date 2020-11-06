<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
<style type="text/css">
body
{
    font-family: Tahoma,Geneva,sans-serif;
    color: white;
     background-image:linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.3)), url('${pageContext.request.contextPath}/resources/images/5.jpg');
    background-size: cover;
    height:100vh;

}


</style>
</head>
<body>
 <div class="signin">
	<spr:form action="login.htm" method="post" commandName="user" >
            <h2 style="color: white"><u>Login Here</u></h2>
            <br>

           <spr:input path="emailId" placeholder="Enter email"/>
			<font color="red" ><spr:errors path="emailId" ></spr:errors></font>
           <spr:password path="userPass" placeholder="Enter Password"/>
           <font color="red" ><spr:errors path="userPass" ></spr:errors></font>         
            <br><br>
           
            <a href=""><input type="submit"   value="Login" class="btn btn-warning"></a>
                    <br>
                    <div id="container">
                <a href="forget_password.jsp" >Forget Password</a>
            </div><br>
             <div class="col-md-12 text-center">
                      	<a href="prep_reg_form.htm" class="btn btn-success">SignIn</a>

                        <a href="index.jsp" class="btn btn-danger  ">Back</a> 
                    </div>
	
	</spr:form>
	</div>
</body>
</html>