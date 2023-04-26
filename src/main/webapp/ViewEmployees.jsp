<%@page import="com.employee_management_system.dto.Admin"%>
<%@page import="com.employee_management_system.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee-Management-System</title>
</head>
<style>
body{
display: flex;
flex-direction: column;
align-items: center;

}
table, th, td {
	border-color: white;
	background-color: lightgrey;
	border-collapse: collapse;
}
table, th, td:hover {
	border-color: white;
	background-color:coral;
	border-collapse: collapse;
	text-align: center;
}

h1:hover{
background-color: black;
color: white;

}
div {
margin-left:100px;
margin-top:30px;
	position: fixed;
	width: 100%;

}
.home{
	text-decoration: none;
	color:red;
	font-size:x-large;
	}
.home:hover {
	color: green;
	font-size:xx-large;
}
a{
text-decoration: none;
color:black;
}
</style>


<body>
<%Admin admin=(Admin) session.getAttribute("Admin");  
if(admin!=null){
List<Employee> employees =(List) request.getAttribute("EmployeesList");%>
 
<h1>Employee's List</h1>
<table border="none" cellpadding="10px" cellspacing="0" >

<tr>
  
<th>Employee_Id</th>
<th>Employee_Name</th>
<th>Employee_Email</th>
<th>Employee_Contact</th>
<th>Employee_Designation</th>
<th>Employee_Salary</th>
<th>Company_Name</th>
<th>Update_Employee</th>
<th>Delete_Employee</th>

</tr>

<%for(Employee employee:employees) {%>
<tr>

 <td><%=employee.getEmployeeId()%></td>
<td><%=employee.getEmployeeName() %></td>
<td><%=employee.getEmployeeEmail() %></td>
<td><%=employee.getEmployeeContact() %></td>
<td><%=employee.getEmployeeDesignation() %></td>
<td><%=employee.getEmployeeSalary() %></td>
<td><%=employee.getCompanyName() %></td>
<td><a href="UpdateEmployee?EmployeeId=<%=employee.getEmployeeId()%>">Update</a></td>
<td><a href="DeleteEmployee?EmployeeId=<%=employee.getEmployeeId()%>">Delete</a></td>
</tr>

<% } %>

</table>
<div><a class="home" href="DashBoard.jsp">Home</a></div>
<%}else{
	response.sendRedirect("AdminLogin.jsp");
	}%>

</body>
</html>