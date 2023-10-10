<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ZipBab 🍚</title>
    <%-- bootstrap --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <%-- favicon --%>
    <link rel="icon" href="${pageContext.request.contextPath }/images/logo/favicon.png">

</head>
<body>
<div class="mx-auto mt-5" style="width: 300px">
    <div id="logo_box" class="mx-auto w-75">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <img src="${pageContext.request.contextPath }/images/logo/main_logo_h.png" alt="logo" class="img-fluid">
        </a>

    </div>
    <form action="${pageContext.request.contextPath }/member/login.do" method="POST">
        <div class="input-group flex-nowrap my-3">
            <span class="input-group-text">아이디</span>
            <input type="text" class="form-control" placeholder="loginId" name="loginId">
        </div>

        <div class="input-group flex-nowrap my-3">
            <span class="input-group-text">비밀번호</span>
            <input type="password" class="form-control" placeholder="password" name="password">
        </div>
        <div class="d-grid">
            <input type="submit" value="로그인" class="btn btn-primary">
        </div>
    </form>
</div>
</body>
</html>