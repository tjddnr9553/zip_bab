<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/review/edit.do" method="POST">
    <input type="hidden" value="${review.recipeId}" name="recipeId">
    <input type="hidden" value="${review.reviewId}" name="reviewId">
    <textarea name="content" id="content" cols="30" rows="10" placeholder="후기를 입력해주세요.">${review.content}</textarea>
    <input type="submit" value="제출">
</form>
</body>
</html>
