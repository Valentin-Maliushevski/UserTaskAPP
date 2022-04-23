<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>UserChoicePage</title>
  </head>
  <body>

   <h2> Choose what you want </h2>

   <form action=<%= request.getContextPath() + "/ui/user/message"%> method="GET">
     <input type="submit" value="Write message"></p>
   </form>

   <form action=<%= request.getContextPath() + "/api/message"%> method="GET">
     <input type="submit" value="Get messages"></p>
   </form>

   <form action=<%= request.getContextPath() + "/api/admin/statistics"%> method="GET">
      <input type="submit" value="Get statistic (only for administrator)"></p>
    </form>

  </body>
</html>