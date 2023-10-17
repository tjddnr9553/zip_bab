<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>ZipBab</title>
    <%-- jquery --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <%-- bootstrap --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
            crossorigin="anonymous"></script>
    <%-- bootstrap icon --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <%-- favicon --%>
    <link rel="icon" href="<c:url value='/images/logo/favicon.png'/>">

    <link rel="stylesheet" href="<c:url value='/css/base.css'/>"/>
    <link rel="stylesheet" href="<c:url value='/css/index.css'/>"/>
</head>
<body>
<!-- 네비게이션 바 -->
<%@ include file="nav.jsp" %>

<!-- 메인화면 -->

<main id="wrapper-main">
    <c:if test="${view == null}">
        <div class="main-image-container">
            <img src="${pageContext.request.contextPath }/images/main/main.jpg" alt="Main image">
            <div class="main-text">
                <a class="nav-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=1">
                    <h1><strong>환영합니다!<br/>
                        <h3>ZipBab에서 맛있는 레시피를 발견하세요.</h3></strong></h1>
                </a>
            </div>
        </div>
    </c:if>
    <c:if test="${not empty view}">
        <jsp:include page="${view }"/>
    </c:if>
</main>

<!-- footer -->
<%@ include file="footer.jsp" %>


</body>
</html>