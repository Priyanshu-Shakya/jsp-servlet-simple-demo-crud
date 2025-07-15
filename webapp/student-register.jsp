<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration</title>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: url('images/register.jpg') no-repeat center center/cover;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-container {
        background: rgba(255, 255, 255, 0.2);
        backdrop-filter: blur(10px);
        padding: 40px;
        border-radius: 16px;
        width: 350px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.3);
    }

    .form-container h3 {
        text-align: center;
        color: #007bff;
        margin-bottom: 20px;
        font-size: 24px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-top: 10px;
        color: #333;
    }

    input[type="text"],
    input[type="password"],
    input[type="email"],
    input[type="tel"],
    input[type="date"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: none;
        border-radius: 8px;
        background-color: #f5f5f5;
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
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
        background-color: #218838;
    }
</style>
</head>
<body>

    <div class="form-container">
        <h3>WELCOME TO REGISTRATION PAGE</h3>
        <form action="registerStudent" method="post">
            <label>STUDENT-ID:</label>
            <input type="text" placeholder="Enter Student Id" name="id">

            <label>STUDENT-NAME:</label>
            <input type="text" placeholder="Enter Student Name" name="name">

            <label>STUDENT-PASSWORD:</label>
            <input type="password" placeholder="Enter Student Password" name="password">

            <label>STUDENT-EMAIL:</label>
            <input type="email" placeholder="Enter Student Email" name="email">

            <label>STUDENT-PHONENO.:</label>
            <input type="tel" placeholder="Enter Student PhoneNo." name="phoneNumber">

            <label>STUDENT-DOB:</label>
            <input type="date" name="dob">

            <label>STUDENT-GENDER:</label>
            <div class="gender-group">
                <input type="radio" value="MALE" name="gender" id="male">
                <label for="male">MALE</label>

                <input type="radio" value="FE-MALE" name="gender" id="female">
                <label for="female">FEMALE</label>
            </div>

            <input type="submit" value="Register">
        </form>
    </div>

</body>
</html>
