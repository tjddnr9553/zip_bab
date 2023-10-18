<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="text-center">
  <h3>${subTitle}</h3>
</div>
<div class="mt-2 ms-2">
  <c:forEach var="m" items="${list}">
    <a href="${pageContext.request.contextPath}/member/mypage.do?loginId=${m.loginId}">
    <div class="card card-sm mb-3" style="max-width: 540px;">
      <div class="row g-0 align-items-center">
        <div class="col-4" style="width:5rem; height:5rem;">
          <c:if test="${empty m.profile || m.profile eq ''}">
            <img src="/images/profile/프사기본.jpg" alt="프로필사진" class="img-fluid rounded-start">
          </c:if>
          <c:if test="${not empty m.profile}">
            <img src="<c:url value="/images/profile/${m.profile}"/>" alt="프로필사진" class="img-fluid rounded-start">
          </c:if>
        </div>
        <div class="col-8" style="width:5rem; height:5rem;">
          <div class="card-body text-center">
            <h5 class="card-title">${m.nickname}</h5>
          </div>
        </div>
      </div>
    </div>
    </a>
  </c:forEach>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
