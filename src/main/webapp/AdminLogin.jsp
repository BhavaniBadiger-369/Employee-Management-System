<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee-Management-System</title>
</head>
<style>
html {
	overflow: hidden;
}
body {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 100vw;
	height: 90vh;
	font-family: 'Poppins', sans-serif;
 background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCW-Wg2QHcR_o2IAfmNyKzzxgxIZjaXd2qi01FzLTDww&s");


}
form {
	width: 40%;
	height: max-content;
	border: 3px solid #565656;
	border-radius: 20px;
	padding: 1rem;
}
input {
	width:90%;
	padding: .5em 1em;
	font-size: 1.3rem;
	font-weight: 500;
	border: 0;
	border-bottom: 3px solid #565656;
}
.btn {
	width: 30%;
	border: 3px solid #565656;
	border-radius: 50px;
	text-decoration: none;
	color: #303030;
	margin-top: 2rem;
	font-weight: 600;
}
.btn:hover {
	background-color:green;
	border: 3px solid salmon;
	color:white;
}
h2 {
	font-size: 2rem;
}
a{
text-decoration:none;
color:blue;
}
</style>
<body>

<form action="Login" method="post">

<h2>Admin Login</h2>
<input name="AdminEmail" type="email" placeholder="Enter Your Email:"> <br> <br>
<input name="AdminPassword" type="password" placeholder="Enter Your Password"> <br> <br>
<input type="submit" class="btn" value="Login">

<h3>Don't have an account?  <a href="AdminSignup.jsp">Please Signup</a></h3>


</form>
</body>
</html>