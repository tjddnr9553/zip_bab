<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 정보 수정</h3>
<form action="<c:url value='/member/edit.do'/>" method="post">
ID : <input type="text" name="id" value="${m.id }" readonly><br/>
PWD: <input type="password" name="pwd" value="${m.pwd }"><br/>
name: <input type="text" name="name" value="${m.name }" readonly><br/>
email: <input type="email" name="email" value="${m.email }" readonly><br/>
가입유형: <span id="type" data-type="${m.type }"></span><br />
<input type="submit" value="수정">
<a href="<c:url value='/index.jsp'/>">취소</a>

<script type="text/javascript" src="<c:url value='/member/js/edit.js'/>"></script>
</form>
</body>
</html>