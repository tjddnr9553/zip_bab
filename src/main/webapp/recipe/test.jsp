<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h3>테스트 페이지</h3>
<a href="${pageContext.request.contextPath}/recipe/list.do">레시피 목록</a>
<c:forEach var="r" items="list">
<a>${r.recipe_id}<a>
</c:forEach>
</body>
</html>