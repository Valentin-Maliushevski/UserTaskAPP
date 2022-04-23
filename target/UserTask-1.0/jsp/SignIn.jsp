<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>SignIn</title>
  </head>

  <body>

  <form action=<%= request.getContextPath() + "/api/login"%> method="POST">
     <p> Login: <input type="text" name="login" />
     Password: <input type="text" name="password" /></p>
     <input type="submit" value="Submit"></p>
  </form>

  </body>
</html>