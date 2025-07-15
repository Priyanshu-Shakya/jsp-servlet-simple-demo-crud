<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Factorial Example</title>
</head>
<body>

    <!-- Scriptlet Tag -->
    <%
    int i = 1;
    while (i <= 10) {
        if (i % 3 == 0) {
        	
    %>
    <!-- Expression Tag -->
    <h4><%= i %></h4>
    <h5 style="color: green;"><%= checkEvenNumber(i) %></h5>
    <%
        }
        i++;
    }
    %>

    <!-- Declaration Tag for Even Number Check -->
    <%! 
    public String checkEvenNumber(int num) {
        return (num % 2 == 0) ? "Even Number" : "Not an Even Number";
    }
    %>
    

    <!-- Declaration Tag for Factorial -->
    <%! 
    public int findFactorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
    %>
    <h5 style="color: blue;">Factorial of 7 is: <%= findFactorial(7) %></h5>

</body>
</html>
