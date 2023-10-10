<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>ZipBab 🍚</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/css/index.css'/>" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script><!-- jquery -->
</head>
<body>
<!-- 네비게이션 바 -->
<%@ include file="nav.jsp"%>

<!-- 메인화면 -->
<main id="wrapper-main">
    ${msg }
    <a href="${pageContext.request.contextPath }/member/login.do">로그인</a>
  <a href="${pageContext.request.contextPath}/member/join.do">회원가입</a><br/>
    <a href="${pageContext.request.contextPath }/member/edit.do?id=${sessionScope.loginId}">내정보</a><br/>
    <a href="${pageContext.request.contextPath }/member/out.do">로그아웃</a><br/>
    <form action="${pageContext.request.contextPath }/member/out.do?id=${sessionScope.loginId}" method="post">
        <button>탈퇴</button>
    </form>
    <c:if test="${view != null}">
        <jsp:include page="${view }"/>
    </c:if>
</main>

<!-- footer -->
<%@ include file="footer.jsp"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>