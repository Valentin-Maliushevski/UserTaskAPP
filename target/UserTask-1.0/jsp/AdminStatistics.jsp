<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>AdminStatistics</title>
  </head>

  <body>

       Количество активных пользователей - ${requestScope.ActiveUsers}
       Количество пользователей - ${requestScope.UsersCount}
       Количество сообщений - ${requestScope.MessagesCount}

  </body>
</html>