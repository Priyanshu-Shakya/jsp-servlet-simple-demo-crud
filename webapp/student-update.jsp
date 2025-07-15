<%@page import="java.sql.Connection"%>
<%@page import="com.infosys.servlet_simple_demo_crud.connection.StudentConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.infosys.servlet_simple_demo_crud.entity.Student"%>
<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: url('images/update.jpg') no-repeat center center/cover;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-container {
        background: rgba(255, 255, 255, 0.2);
        backdrop-filter: blur(12px);
        padding: 40px;
        width: 350px;
        border-radius: 16px;
        box-shadow: 0 8px 24px rgba(0, 0, 0, 0.4);
    }

    h3 {
        text-align: center;
        color: #007BFF;
        margin-bottom: 20px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-top: 12px;
        color: #333;
    }

    input[type="text"],
    input[type="password"],
    input[type="email"],
    input[type="tel"],
    input[type="date"] {
        width: 100%;
        padding: 10px;
        border: none;
        border-radius: 8px;
        background-color: #f5f5f5;
        margin-top: 5px;
        transition: all 0.3s ease-in-out;
    }

    input[type="text"]:focus,
    input[type="password"]:focus,
    input[type="email"]:focus,
    input[type="tel"]:focus,
    input[type="date"]:focus {
        outline: none;
        background-color: #e2f0ff;
        box-shadow: 0 0 5px rgba(0, 123, 255, 0.6);
    }

    .gender-group {
        margin-top: 10px;
        color: #333;
    }

    .gender-group input[type="radio"] {
        margin-left: 10px;
        margin-right: 5px;
        transform: scale(1.2);
    }

    input[type="submit"] {
        margin-top: 20px;
        width: 100%;
        padding: 12px;
        background-color: #28a745;
        color: white;
        border: none;
        border-radius: 8px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s ease-in-out;
    }

    input[type="submit"]:hover {
        background-color: #218838;
    }
</style>
</head>
<body>

<%!
    public Student getStudentByIdDao(int targetId) {
        Connection connection = StudentConnection.getStudentConnection();
        String query = "SELECT * FROM studentregis WHERE id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, targetId);
            ResultSet set = ps.executeQuery();
            if (set.next()) {
            	/* int id = set.getInt("id");
				String name = set.getString("name");
				String password=set.getString("password");
				String email = set.getString("email");
				long phoneNumber = set.getLong("phoneNumber");
				LocalDate dob = LocalDate.parse(set.getString("dob"));
				String gender=set.getString("gender");

				Student student=new Student(id, name, password, email, phoneNumber, dob, gender); */	
				
                Student student = new Student();
                student.setName(set.getString("name"));
                student.setPassword(set.getString("password"));
                student.setEmail(set.getString("email"));
                student.setPhone(set.getLong("phoneNumber"));
                student.setDob(set.getDate("dob").toLocalDate());
                student.setGender(set.getString("gender"));
                return student;
            } else {
                System.out.println("Student not found!");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
%>

<%
    int urlId = Integer.parseInt(request.getParameter("id"));
    Student student = getStudentByIdDao(urlId);
%>

<div class="form-container">
    <h3>UPDATE STUDENT DETAILS</h3>
    <form action="updateStudent" method="post">
        <label>STUDENT-ID:</label>
        <input type="text" name="id" value="<%=urlId%>" readonly style="background-color: #eee;">

        <label>STUDENT-NAME:</label>
        <input type="text" name="name" value="<%=student.getName()%>">

        <label>STUDENT-PASSWORD:</label>
        <input type="password" name="password" value="<%=student.getPassword()%>">

        <label>STUDENT-EMAIL:</label>
        <input type="email" name="email" value="<%=student.getEmail()%>">

        <label>STUDENT-PHONENO.:</label>
        <input type="tel" name="phoneNumber" value="<%=student.getPhone()%>">

        <label>STUDENT-DOB:</label>
        <input type="date" name="dob" value="<%=student.getDob()%>">

        <label>STUDENT-GENDER:</label>
        <div class="gender-group">
            <input type="radio" value="MALE" name="gender" <%= "MALE".equals(student.getGender()) ? "checked" : "" %>> MALE
            <input type="radio" value="FE-MALE" name="gender" <%= "FE-MALE".equals(student.getGender()) ? "checked" : "" %>> FEMALE
        </div>

        <input type="submit" value="UPDATE">
    </form>
</div>

</body>
</html>
