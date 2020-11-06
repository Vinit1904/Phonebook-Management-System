<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet">
<style type="text/css">#sec1  {
    color: white;
    background-image:linear-gradient(rgba(0,0,0,0.3),rgba(0,0,0,0.3)), url('${pageContext.request.contextPath}/resources/images/call.jpg');
   
    background-repeat: no-repeat;
    background-size: cover;
    height: 100vh;
    position: center;
 
   
    
}</style>

</head>
<body>

	<div class="container-fluid">
        <!---------row1-->
        <div class="row bg-dark justify-content-between align-items-center sticky-top" style="height: 60px;">
            <div class="col-3 text-light" style="font-size: 24px;">
                <img class="logo" src="${pageContext.request.contextPath}/resources/images/8.png" 
 
 				style="width: 150px;height: 40px;"/>
            </div>

            <div class="col-6 d-flex justify-content-end align-items-center">

                <a href="prep_log_form.htm" class="btn btn-outline-warning mr-3">Login</a>
                <a href="prep_reg_form.htm" class="btn btn-outline-warning mr-3">Register</a>
            </div>
        </div>
        <!-------------row2-->
        <div class="row  " style="height:550px;">
            <div id="sec1" class="col-lg-12  ">
                <div class="col">
                    <h2>Be the Boss of</h2>
                    <h2>Your Phonebook</h2><br><br><br><br>
                    <h1 class="col1"><span></span> Contact</h1>
                </div>


            </div>
        </div>
</body>
</html>