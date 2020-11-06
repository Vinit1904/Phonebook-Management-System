<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password Form</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/forgetpass.css" rel="stylesheet">
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
	
	
	<div class="forget">
          <br> 
      <form action="forgot_password.htm" method="post" >
            <h2 ><u>Forget Password</u></h2><br> 
            <h5 style="color: yellow; font-size: 15px;text-align: left">Enter your email here that you used on your account. We send the link on your email to reset your password</h5><br>
            
            <input type="text" name="emailId"placeholder="Enter your email"><br><br>
             <input type="submit" class="btn btn-warning" value="Reset" >
           
            <br>       <br>
            <div>
             <a href="index.jsp"  style="text-align: center "><u>Go back to Home page</u></a>
            </div>
            </form>
        </div>
	</form>
	
</body>
</html>