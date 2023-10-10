<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3>프로필 수정</h3>
<form action="${pageContext.request.contextPath }/member/edit.do" method="post">
아이디: <input type="text" name="loginId" value="${m.loginId }"readonly><br/>
비밀번호: <input type="password" name="password" value="${m.password }"readonly><br/>
닉네임: <input type="text" name="nickname" value="${m.nickname }" ><br/>
이메일: <input type="email" name="email" value="${m.email }" readonly><br/>
생년월일: <input type="date" name="birthday" value="${m.birthday }" readonly><br/>
<input type="submit" value="수정">
<a href="<c:url value='/index.jsp'/>">취소</a>
<!--<script type="text/javascript" src="<c:url value='/member/js/edit.js'/>"></script>-->
</form>
</body>
</html>