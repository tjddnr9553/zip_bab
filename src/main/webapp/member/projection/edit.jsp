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

</head>
<body>

<footer id="footer">
  <div class="inner">

    <h3>개인 정보</h3>
    <form action="${pageContext.request.contextPath }/member/edit.do" method="post" enctype="multipart/form-data">
      <c:if test="${m.profile ne null}">
        <div class="image round">
          <label for="imgUpload">
            <img class="profile"
                 src="${pageContext.request.contextPath }/images/profile/${m.profile}" alt="profile_img"
                 width="150" height="150">
          </label>
        </div>
      </c:if>
      <c:if test="${m.profile eq null}">
        <div class="image round">
          <label for="imgUpload">
            <img class="profile" src="/images/profile/프사기본.jpg" alt="profile_img" width="150" height="150">
          </label>
        </div>
      </c:if>

      <input id="imgUpload" type="file" name="profile" class="d-none"><br><br>

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
        <c:if test="${m.gender eq 0}">
          <input name="gender" id="gender" type="text" placeholder="gender" value="여성" readonly>
        </c:if>
        <c:if test="${m.gender eq 1}">
          <input name="gender" id="gender" type="text" placeholder="gender" value="남성" readonly>
        </c:if>
      </div>
      <div class="field half first">
        <label for="birthday">생년월일</label>
        <input name="birthday" id="birthday" type="text" placeholder="birthday" value="${m.birthday }" readonly></div>
      <ul class="actions">
        <li><input value="제출" class="button alt" type="submit"></li>
      </ul>
    </form>
  </div>
</footer>
</body>

<!-- Scripts -->
<script src="${pageContext.request.contextPath}/member/projection/assets/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/member/projection/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/member/projection/assets/js/main.js"></script>
</body>
</html>