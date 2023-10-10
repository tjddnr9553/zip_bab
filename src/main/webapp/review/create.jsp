<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="${pageContext.request.contextPath}/review/create.do" method="POST">
    <input type="hidden" value="${recipeId}" name="recipeId">
    <textarea name="content" id="content" cols="30" rows="10" placeholder="후기를 입력해주세요."></textarea>
    <input type="submit" value="후기 작성">
</form>
</body>
</html>