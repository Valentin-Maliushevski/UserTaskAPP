<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>UserMessage</title>
  </head>
  <body>

   <form action=<%= request.getContextPath() + "/api/message"%> method="POST">
     <p>
     Login other user: <input type="text" name="toUser" />
     <br>
     text: <input type="text" name="text" />
     <br>
     <input type="submit" value="Send message">
     </p>
   </form>

  </body>
</html>