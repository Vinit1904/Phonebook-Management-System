<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.cdac.dto.User"%>
<%@page import="java.util.List"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/profil.css" rel="stylesheet">

<style type="text/css">
body
{
     background-image: url('${pageContext.request.contextPath}/resources/images/mob.jpg');
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
                <a href="home.jsp" class="btn btn-outline-warning mr-3 ">Back</a> 
            </div>
       	 </div>
		
		<h2 ><u>User Profile</u></h2><br>
		    <% 
            User ur=(User)request.getAttribute("user");
            
            %> 
		<% 
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
	    response.setHeader("Pragma","no-cache"); //HTTP 1.0
	    response.setDateHeader ("Expires", 0);
		%>
			
		   		 <div class="serc">

        			Update Profile : -
        			<a href="profile.htm" class="btn btn-success">Update Profile</a>
        			
    			</div>
    			<br><br>

    <div class="row  justify-content-center align-items-center " style="height: 300px;  margin-top: 70px;">
        <div class="col-3"></div>
        <div class="col-4">

            <table class="content-table">

            
                <tr>
                    <td>
                        First Name:
                    </td>
                    <td>
                        <%=ur.getFirstName()%>
                    </td>
                <tr>

                <tr>
                    <td>
                        Last Name:
                    </td>

                    <td>
                        <%=ur.getLastName()%>
                    </td>
                <tr>


                <tr>
                    <td>
                        EmailId
                    </td>

                    <td>
                        <%=ur.getEmailId()%>
                    </td>
                </tr>


                <tr>

                    <td>
                        Password
                    </td>

                    <td>
                        <%=ur.getUserPass()%>
                    </td>
                </tr>


                <tr>
                    <td>
                        Confirm Password
                    </td>
                    <td>
                        <%=ur.getConfirmPass()%>
                    </td>
                </tr>


            </table>
        </div>
       
        <div class="col-2 ">
        
		
		<img alt="no pic" src="<%="images/"+ur.getProfilePic()%>" > 
             
        </div>
        <div class="col-1"></div>

    </div>
   <div class="ser">
    <form method="POST" action="upload_file.htm" enctype="multipart/form-data">
						<table align="center" >
							<tr>
								<td>
									 <div class="s1">Upload profile photo:</div> 
								</td>
								<td>
									<input type="file" name="file">  
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="submit" value="Upload">
								</td>
							</tr>
						</table>
					</form>
		</div>
</body>
</html>