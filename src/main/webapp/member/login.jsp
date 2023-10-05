<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 class="text-lg">로그인</h3>
<form action="${pageContext.request.contextPath }/member/login.do" method="POST">
ID: <input type="text" name="id"><br/>
PWD: <input type="password" name="pwd"><br/>
<input type="submit" value="로그인">
</form>
</body>
</html>