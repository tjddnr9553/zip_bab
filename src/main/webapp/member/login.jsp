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
아이디: <input type="text" name="loginId"><br/>
비밀번호: <input type="password" name="password"><br/>
<input type="submit" value="로그인">
</form>
</body>
</html>