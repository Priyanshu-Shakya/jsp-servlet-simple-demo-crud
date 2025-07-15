<%@page
	import="com.infosys.servlet_simple_demo_crud.controller.LoginStudentController"%>
<%@page import="com.infosys.servlet_simple_demo_crud.dao.StudentDao"%>
<%@page import="com.infosys.servlet_simple_demo_crud.entity.Student"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-image: url('images/display.jpg');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	backdrop-filter: blur(3px);
	padding: 40px;
	color: #333;
}

h2 {
	text-align: center;
	color: #004080;
	margin-bottom: 30px;
}

table {
	width: 100%;
	border-collapse: collapse;
	background: rgba(255, 255, 255, 0.9);
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
}

th, td {
	padding: 12px 15px;
	text-align: center;
}

th {
	background-color: #ff8c00;
	color: white;
	font-size: 16px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #e0f7fa;
	transition: background 0.3s ease;
}

a {
	text-decoration: none;
	font-weight: bold;
	padding: 6px 12px;
	border-radius: 5px;
	transition: background-color 0.3s ease;
}

a:hover {
	opacity: 0.9;
}

.edit-btn {
	background-color: #28a745;
	color: white;
}

.delete-btn {
	background-color: #dc3545;
	color: white;
}

.logout-btn {
	display: inline-block;
	margin-top: 30px;
	padding: 10px 20px;
	background-color: #007BFF;
	color: white;
	border-radius: 5px;
	text-decoration: none;
	font-weight: bold;
	float: right;
}

.logout-btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>



	<!-- >>>Here I am Access ALL the DATA of Students from Single MAtched EmailID and Password Data to the UI not of the All USers<<  -->

	<%-- <%
	List<Student> students = new StudentDao().getAllStudentDao();

	// 	 List<Student> filterStudents=students.stream()
	// 	.filter(s->s.getEmail().equals(email))
	// 	.collect(Collectors.toList()); 

	String userSession = (String) session.getAttribute("userSession");

	if (userSession != null) {
	%>

		<%
	String msg = (String) session.getAttribute("msg");
	if (msg != null) {
	%>
	<h3 style='color: Green;'><%=msg%></h3>
	<%
	session.removeAttribute("msg"); // Optional: clear after displaying
	}
	%>


	<h2 style="text-align: center; color: navy;">Student Details</h2>
	<table border="2"
		style="background-image: url('images/display.jpg'); background-repeat: no-repeat; background-size: 100vw 100vh;">

		<tr>
			<th>ID:</th>
			<th>NAME:</th>
			<th>EMAIL:</th>
			<th>PHONE:</th>
			<th>DOB:</th>
			<th>GENDER:</th>
			<th colspan="2">ACTION</th>
		</tr>
		<%
		for (Student stu : students) {
		%>
		<tr>
			<td><%=stu.getId()%></td>
			<td><%=stu.getName()%></td>
			<td><%=stu.getEmail()%></td>
			<td><%=stu.getPhone()%></td>
			<td><%=stu.getDob()%></td>
			<td><%=stu.getGender()%></td>
			<td><a href="deleteStudent?id=<%=stu.getId()%>">DELETE</a></td>
			<td><a href="student-update.jsp?id=<%=stu.getId()%>">EDIT</a></td>
		</tr>
		<%
		}
		%>


	</table>
	<%
	} else {
	%>
	<%
	response.sendRedirect("student-login.jsp");
	%>
	<%
	}
	%>

	<a href="logoutController"
		style="display: inline-block; padding: 10px 20px; background-color: #007BFF; color: white; text-decoration: none; border-radius: 5px; font-weight: bold;">LOGOUT</a>
	placed before the
<body></body> --%>




	<!-- >>Here I am Access only MAtched Student EmailID and Password Data to the UI not of the All USers<<  -->





	<%
		
// 		Student stu=(Student)request.getAttribute("studentObject");

	 Student stu = (Student) session.getAttribute("studentObj");
	 String userSession = (String) session.getAttribute("userSession");

	if (userSession != null) {
		
		
		
		if(stu!=null){
	%>



	<%
	String msg = (String) session.getAttribute("msg");
	if (msg != null) {
	%>
	<h3 style='color: Green;'><%=msg%></h3>
	<%
	session.removeAttribute("msg"); // Optional: clear after displaying
	}
	%>

	<table border="2">

		<tr>
			<th>ID:</th>
			<th>NAME:</th>
			<th>EMAIL:</th>
			<th>PHONE:</th>
			<th>DOB:</th>
			<th>GENDER:</th>
			<th colspan="2">ACTION</th>
		</tr>

		<tr>
			<td><%=stu.getId()%></td>
			<td><%=stu.getName()%></td>
			<td><%=stu.getEmail()%></td>
			<td><%=stu.getPhone()%></td>
			<td><%=stu.getDob()%></td>
			<td><%=stu.getGender()%></td>
			<td><a href="deleteStudent?id=<%=stu.getId()%>">DELETE</a></td>
			<td><a href="student-update.jsp?id=<%=stu.getId()%>">EDIT</a></td>
		</tr>

	</table>

	<%
		}
		else {
			%>
	<p style="color: red; text-align: center;">No student data found!</p>
	<%
			}
		} else {
	%>
	<%
	response.sendRedirect("student-login.jsp");
	%>
	<%
	}
	%>
	<a href="logoutController"
		style="display: inline-block; padding: 10px 20px; background-color: #007BFF; color: white; text-decoration: none; border-radius: 5px; font-weight: bold;">LOGOUT</a>
	<!-- placed before the <body></body>  -->



</body>
</html>