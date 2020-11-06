
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@page import="java.util.List"%>   
<%@page import="com.cdac.dto.User"%>
<%@page import="com.cdac.dto.UserLogs"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Logs</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/userloglist.css" rel="stylesheet">
<style type="text/css">
body
{
     background-image: url('${pageContext.request.contextPath}/resources/images/adminlist.jpg');
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
                <a href="admin_home.jsp" class="btn btn-outline-warning mr-3 ">Back</a> 
            </div>
       	 </div>
	<h2 ><u>User Log List</u></h2>
	<% 
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0);
	%>
		
   		
	
		<table class="content-table">
  			<thead>
   				 <tr>
    
					<th>User Id</th>
     				 <th>Login Date Time</th>
      				<th>LogOut Date Time</th>
      				
      
    			</tr>
  			</thead>
		
		<% 
		List<UserLogs> uList=(List<UserLogs>)request.getAttribute("userLogsList");
		for(UserLogs ul:uList){
		%>
		
		
		<tr>
			<td>
				<%=ul.getUserId()%>
			</td>
			
			<td>
				<%=ul.getLogInDateTime()%>
				
			</td>
			
			
			<td>
				<%=ul.getLogOutDateTime()%>				
			</td>
						
	
		</tr>
		<% }%>
		
		
		
	</table>
	
</body>
</html>