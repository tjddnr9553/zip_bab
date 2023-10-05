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
<input type="hidden" name="flag" value="false">
ID : <input type="text" name="id" onchange="c()">
<input type="button" value="중복체크" onclick="a()"><span id="res"></span>
<br/>
PWD: <input type="password" name="pwd"><br/>
name: <input type="text" name="name"><br/>
email: <input type="email" name="email"><br/>
유형: <input type="radio" name="type" value="1" checked/>구매자
<input type="radio" name="type" value="2"/>판매자<br/>
<!-- 성별: <input type="radio" value="f" name="gen">여성
<input type="radio" value="m" name="gen">남성<br/>
취미: <input type="checkbox" name="hobby" value="1">영화
<input type="checkbox" name="hobby" value="2">등산
<input type="checkbox" name="hobby" value="3">낚시
<input type="checkbox" name="hobby" value="4">클라이밍
<select name="sel">
<option value="1g">1학년</option>
<option value="2g">2학년</option>
<option value="3g">3학년</option>
<option value="4g">4학년</option>
</select><br/>
가입인사: <textarea name="msg" rows="3" cols="20"></textarea><br/>
생일: <input type="date" name="birth"><br/> -->
<input type="button" value="가입" onclick="b()">
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/member/js/join.js"></script>
</body>
</html>