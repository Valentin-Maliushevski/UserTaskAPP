<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>MainPage</title>
  </head>

  <body>

   <h2>Welcome to main page </h2>

   <form action=<%= request.getContextPath() + "/ui/signUp"%> method="GET">
     <input type="submit" value="SignUp"></p>
   </form>

   <form action=<%= request.getContextPath() + "/ui/signIn"%> method="GET">
     <input type="submit" value="SignIn"></p>
   </form>

  </body>
</html>