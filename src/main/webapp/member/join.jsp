<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body data-context-path="${pageContext.request.contextPath }">
<h3>회원가입</h3>
<form action="${pageContext.request.contextPath }/member/join.do" method="post" name="f">
<input type="hidden" name="flag" value="false"/>
username : <input type="text" name="username" onchange="c()"/>
<input type="button" value="중복체크" onclick="a()"><span id="res"></span>
<br/>
비밀번호: <input type="password" name="password"><br/>
nickname: <input type="text" name="nickname"><br/>
email: <input type="email" name="email"><br/>
birthday: <input type="date" name="birthday"><br/>
성별: <input type="radio" value="0" name="gender">여성
<input type="radio" value="1" name="gender">남성<br/>
<input type="button" value="가입" onclick="b()">
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/member/js/join.js"></script>
</body>
</html>