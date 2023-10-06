<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<c:url value='/review/create.do'/>" method="POST">
    <input type="hidden" value="1" name="memberId">
    <input type="hidden" value="1" name="recipeId">
    <textarea name="content" id="content" cols="30" rows="10" placeholder="후기를 입력해주세요."></textarea>
    <input type="submit" value="제출">
</form>
</body>
</html>
