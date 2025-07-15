<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
    body {
        margin: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-image: url('images/login.jpg');
        background-repeat: no-repeat;
        background-size: cover;
        background-position: center;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .login-box {
        background: rgba(255, 255, 255, 0.15);
        backdrop-filter: blur(10px);
        padding: 40px;
        border-radius: 16px;
        box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
        text-align: center;
        width: 300px;
    }

    .login-box h1 {
        color: #28a745;
        margin-bottom: 30px;
        font-size: 26px;
    }

    label {
        font-weight: bold;
        color: #fff;
        display: block;
        margin: 10px 0 5px;
        text-align: left;
    }

    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: none;
        border-radius: 8px;
        background-color: #f0f0f0;
    }

    button {
        padding: 10px 20px;
        width: 100%;
        border: none;
        border-radius: 8px;
        background-color: #28a745;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color:  #218838;
    }
</style>
</head>
<body>

    <div class="login-box">
        <h1>Welcome to Login Page</h1>
        <form action="loginStudent" method="post">
            <label for="email">Student Email:</label>
            <input type="email" placeholder="Enter Student Email" name="loginEmail" id="email" required>

            <label for="password">Student Password:</label>
            <input type="password" placeholder="Enter Student Password" name="loginPassword" id="password" required>

            <button type="submit">Submit</button>
        </form>
    </div>

</body>
</html>
