<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.cdac.dto.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin_Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/admin_home.css" rel="stylesheet">
<style type="text/css">
body
{
   
     background-image:linear-gradient(rgba(0,0,0,0.1),rgba(0,0,0,0.1)), url('${pageContext.request.contextPath}/resources/images/5.jpg');
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

                <a class="btn btn-outline-warning mr-3">Welcome <%=(session.getAttribute("user")!=null) ? ((User)session.getAttribute("user")).getFirstName()+" Admin": "!!!!!!!!" %> </a>
                <a href="logout.htm"  class="btn btn-outline-warning mr-3">Logout</a>
                
            </div>
       	 </div>
	<% 
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0);
	%>
	
	 <section class="services" id="ourwork">
            <div class="container1">  <br>
                <div class="heading">
                    <h2 ><u>Features</u></h2>
                </div>
                <br>
                <div class="mainbox">
                <div class="box1">
                        <div class="content">
                            <h3><u>USER LIST</u></h3>
                           <img src="${pageContext.request.contextPath}/resources/images/profile.png">
                            <p>Wanna to check who are users. Click here!! </p>
                          <a href="prep_user_list.htm" ><input type="button" value="Show User"></a><br>
                        </div>
                    </div>
                    <div class="box1">
                        <div class="content">
                            <h3><u>USER LOG</u></h3>
                            <img src="${pageContext.request.contextPath}/resources/images/list1.png">
                            <p>Check Login and Logout time of all user. Click here </p>
                           <a href="user_log_list.htm"><input type="button" value="Use Log"></a><br>
                           
                        </div>
                    </div>
                </div>
            </div>
        </section>
	

</body>
</html>