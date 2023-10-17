<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<c:forEach var="f" items="${list}">
   ${f.nickname}
</c:forEach>

<c:forEach var="f" items="${followingMembers}">
  ${f.nickname}
</c:forEach>

</body>
</html>
