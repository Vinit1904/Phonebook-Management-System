<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.cdac.dto.User"%>
 <%@page import="com.cdac.dto.Contact"%>
<%@page import="java.util.List"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/contactlist.css" rel="stylesheet">
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
       	 </div><br>

	<h2 ><u>Contact List</u></h2><br>
	<% 
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//HTTP 1.1
    response.setHeader("Pragma","no-cache"); //HTTP 1.0
    response.setDateHeader ("Expires", 0);
	%>
		
   		 <div class="serc">
        <form action="contact_search.htm" method="get">
            <table>
                <td>Search By : -</td>
                <td>
                    <input type="text" name="searchVal" placeholder="Type Name here "
                        class="form-control border border-dark ">

                </td>

                <td>

                    <input type="submit" class="btn btn-primary btn-block  " value="Search">
                </td>
                 <td>
                 	 <a href="contact_list.htm" class="btn btn-success btn-block ">Refresh</a> 
                </td>
            </table>
        </form>
        <br>

        Sort By : -
        <a href="ascending_sort_by_name.htm" class="btn btn-success">Ascending Sort</a>

        <a href="descending_sort_by_name.htm" class="btn btn-danger">Descending Sort</a>


    </div>
   		


	<table class="content-table">
  <thead>
    <tr>
    
      <th>Name</th>
      <th>Number1</th>
      <th>Number2</th>
      <th>City</th>
      <th>Email</th>
      <th>Label</th>
      <th>Delete</th>
      <th>Update</th>
    </tr>
  </thead>
		
		
		<% 
		List<Contact> cList=(List<Contact>)request.getAttribute("contactList");
		for(Contact ct:cList){
		%>
		
		<tr>
			<td>
				<%=ct.getName()%>
			</td>
			
			<td>
				<%=ct.getPrimaryNum()%>
				
			</td>
			
			
			<td>
				<%=ct.getSecondaryNum()%>				
			</td>
			
			
			<td>
				<%=ct.getCity()%>				
			</td>
			
			
			<td>
				<%=ct.getEmailId()%>				
			</td>
			
				
			<td>
				<%=ct.getLabel()%>				
			</td>
			
			<td>
				<a href="contact_delete.htm?contactId=<%=ct.getContactId()%>">Delete</a>
			</td>
			<td>
				<a href="contact_update_form.htm?contactId=<%=ct.getContactId()%>">Update</a>
			</td>			
	
		</tr>
		<% }%>
		
				
		
	</table>
	
	
	
</body>
</html>