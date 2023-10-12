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
    <%-- favicon --%>
    <link rel="icon" href="<c:url value='/images/logo/favicon.png'/>">

    <link rel="stylesheet" href="<c:url value='/css/index.css'/>"/>
    <style>
 .main-image-container {
        position: relative;
        width: 100%;
        height: 100vh; /* 높이를 뷰포트의 높이로 설정 */
    }

    .main-image-container img {
        width: 100%;
        height: 100%;
        object-fit: cover; /* 이미지 비율 유지 */
        transition: filter 0.3s ease-in-out; /* 부드럽게 필터 효과 전환 */
    }

    .main-image-container img:hover {
      filter: blur(6px); /* 마우스 호버 시 블러 효과 적용 */
    }

    .main-text {
       position: absolute;
       top: 50%;
       left: 50%;
       transform-origin:center center;
       transform-style:preserve-3d;
       transform : translate(-50%, -50%);
       color:white;
       text-align:center;

   }

   .main-text h1,strong,p{
     transition : transform 0.5s ease-in-out;
   }

   .main-text:hover h1,strong,p{
     transform : scale(2.0);
   }
    </style>
</head>
<body>
<!-- 네비게이션 바 -->
<%@ include file="nav.jsp" %>

<!-- 메인화면 -->

<!-- <main id="wrapper-main"> -->
<c:if test="${view == null}">
      <div class="main-image-container">
            <img src="${pageContext.request.contextPath }/images/profile/main.jpg" alt="Main image">
            <div class="main-text">
           <a class="nav-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=1">
                <h1><strong>환영합니다!<br/><h3>ZipBab에서 맛있는 레시피를 발견하세요.</h3></strong></h1>
            </a>
            </div>
        </div>
</c:if>
    <%--    <a href="${pageContext.request.contextPath }/member/login.do">로그인</a>--%>
    <%--  <a href="${pageContext.request.contextPath}/member/join.do">회원가입</a><br/>--%>
    <%--    <a href="${pageContext.request.contextPath }/member/edit.do?id=${sessionScope.loginId}">내정보</a><br/>--%>
    <%--    <a href="${pageContext.request.contextPath }/member/out.do">로그아웃</a><br/>--%>
    <%--    <form action="${pageContext.request.contextPath }/member/out.do?id=${sessionScope.loginId}" method="post">--%>
    <%--        <button>탈퇴</button>--%>
    <%--    </form>--%>
    <c:if test="${view != null}">
        <jsp:include page="${view }"/>
    </c:if>
<!-- </main> -->

<!-- footer -->
<%@ include file="footer.jsp" %>


</body>
</html>