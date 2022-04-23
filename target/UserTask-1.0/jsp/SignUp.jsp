<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>SignUp</title>
  </head>

  <body>
    <form action=<%= request.getContextPath() + "/api/user"%> method="POST">
       <p>
         Login: <input type="text" name="login"/>
         <br>
         Password: <input type="text" name="password"/>
          <br>
         FIO: <input type="text" name="fio"/>
          <br>
         Birthday: <input type="text" name="birthday" placeholder="YYYY-MM-DD"/>
          <br>
         <input type="submit" value="Submit">
       </p>
    </form>

  </body>
</html>