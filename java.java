<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h2>Add New Student</h2>
    <form action="AddStudentServlet" method="post">
        <label>Name:</label>  
        <input type="text" name="name" required><br><br>

        <label>Age:</label>  
        <input type="number" name="age" required><br><br>

        <label>Course:</label>  
        <input type="text" name="course" required><br><br>

        <input type="submit" value="Add Student">
    </form>
    <br>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
