<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--    pageEncoding="UTF-8"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--<meta charset="UTF-8">--%>
<%--    <title>Insert title here</title>--%>
<%--    <style>--%>
<%--        .box {--%>
<%--            width: 150px;--%>
<%--            height: 150px;--%>
<%--            border-radius: 70%;--%>
<%--            overflow: hidden;--%>
<%--        }--%>
<%--        .profile {--%>
<%--            width: 100%;--%>
<%--            height: 100%;--%>
<%--            object-fit: cover;--%>
<%--        }--%>

<%--    </style>--%>

<%--</head>--%>
<%--<body>--%>

<%--<h3>프로필 수정</h3>--%>
<%--<form action="${pageContext.request.contextPath }/member/edit.do" method="post" enctype="multipart/form-data">--%>
<%--    <c:if test="${m.profile != null}">--%>
<%--<div>--%>
<%--        <label for="imgUpload" class="box"><img class="profile" src="${pageContext.request.contextPath }/images/profile/${m.profile}" alt="profile_img" width="200px;"></label>--%>
<%--</div>--%>
<%--    </c:if>--%>
<%--    <c:if test="${m.profile == null}">--%>
<%--        <label for="imgUpload" class="box"><img class="profile" src="/images/profile/프사기본.jpg" alt="profile_img" width="200px;"></label>--%>
<%--    </c:if>--%>
<%--<input id="imgUpload" type="file" name="profile" class="d-none"><br/>--%>
<%--아이디: <input type="text" name="loginId" value="${m.loginId }"readonly><br/>--%>
<%--비밀번호: <input type="password" name="password" value="${m.password }"readonly><br/>--%>
<%--닉네임: <input type="text" name="nickname" value="${m.nickname }" ><br/>--%>
<%--이메일: <input type="email" name="email" value="${m.email }" readonly><br/>--%>
<%--생년월일: <input type="date" name="birthday" value="${m.birthday }" readonly><br/>--%>
<%--<input type="submit" value="수정" class="btn btn-primary">--%>
<%--<a href="<c:url value='/index.jsp'/>">취소</a>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/member/projection/assets/css/main.css">

  <style>
      .box {
          width: 150px;
          height: 150px;
          border-radius: 70%;
          overflow: hidden;
      }

      .profile {
          width: 100%;
          height: 100%;
          object-fit: cover;
      }
  </style>
</head>
<body>

<!-- Header -->
<header id="header">
  <div class="inner">
    <a href="index.html" class="logo"><strong>집밥</strong></a>
    <nav id="nav"><a href="index.html">Home</a>
      <a href="generic.html">Generic</a>
      <a href="elements.html">Elements</a>
    </nav>
    <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
  </div>
</header>

<footer id="footer">
  <div class="inner">

    <h3>프로필 편집</h3>
    <form action="${pageContext.request.contextPath }/member/edit.do" method="post" enctype="multipart/form-data">
      <c:if test="${m.profile != null}">
        <div>
          <label for="imgUpload" class="box"><img class="profile"
                                                  src="${pageContext.request.contextPath }/images/profile/${m.profile}"
                                                  alt="profile_img" width="200px;">
          </label>
        </div>
      </c:if>
      <c:if test="${m.profile == null}">
        <label for="imgUpload" class="box"><img class="profile" src="/images/profile/프사기본.jpg" alt="profile_img"
                                                width="200px;"></label>
      </c:if>
      <input id="imgUpload" type="file" name="profile" class="d-none"><br/>
      <div class="field half first">
        <label for="loginId">아이디</label>
        <input name="loginId" id="loginId" type="text" placeholder="loginId" value="${m.loginId }" readonly></div>
      <div class="field half first">
        <label for="password">비밀번호</label>
        <input name="password" id="password" type="email" placeholder="password" value="${m.password }" readonly></div>
      <div class="field half first">
        <label for="nickname">닉네임</label>
        <input name="nickname" id="nickname" type="text" placeholder="nickname" value="${m.nickname }"></div>
      <div class="field half first">
        <label for="email">이메일</label>
        <input name="email" id="email" type="text" placeholder="email" value="${m.email }" readonly></div>
      <div class="field half first">
        <label for="gender">성별</label>
        <input name="name" id="gender" type="text" placeholder="gender" value="${m.gender }" readonly></div>
      <div class="field half first">
        <label for="birthday">생년월일</label>
        <input name="name" id="birthday" type="text" placeholder="birthday" value="${m.birthday }" readonly></div>
      <ul class="actions">
        <li><input value="제출" class="button alt" type="submit"></li>
      </ul>
    </form>
  </div>
</footer>
</body>

<div class="copyright">
  Made with: <a href="https://templated.co/">Templated.co</a>
</div>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/member/projection/assets/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/member/projection/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/member/projection/assets/js/main.js"></script>
</body>
</html>