<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
l
<!DOCTYPE HTML>
<html>
<head><title>Projection by TEMPLATED</title>
  <meta charset="utf-8">
  <meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/member/projection/assets/css/main.css">
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
<!-- Banner -->
<section id="banner">
  <div class="inner">

    <header>
      <div class="inner">
        <c:if test="${member.profile != null}">
          <div class="image round">
            <img class="profile"
                 src="${pageContext.request.contextPath }/images/profile/${member.profile}" alt="Pic 01"
                 width="150" height="150">
          </div>
        </c:if>
        <c:if test="${member.profile == null}">
          <div class="image round">
            <img class="profile" src="/images/profile/프사기본.jpg" alt="profile_img" width="150" alt="Pic 01"
                 height="150"></label>
          </div>
        </c:if>

        <header>
          </br><h3>${member.nickname }</h3><br>
        </header>

      </div>
    </header>

    <div class="flex ">
      <div>
        <h3>${followerCount}</h3>
        <p>팔로워</p>
      </div>

      <div>
        <h3>${followingCount}</h3>
        <p>팔로우</p>
      </div>
    </div>

    <footer>
      <c:if test="${sessionScope.loginId.loginId ne member.loginId }">
        <a onclick="follow()" class="button">팔로우</a>
      </c:if>
      <c:if test="${sessionScope.loginId.loginId eq member.loginId}">
      <a href="/member/edit.do?loginId=${sessionScope.loginId.loginId}"class="button">프로필편집</a>
      </c:if>
    </footer>

  </div>
</section><!-- Three -->

<footer id="footer">
  <div class="inner">

    <h3>프로필 편집</h3>

    <form action="#" method="post">
      <div class="field half first">
        <label for="loginId">아이디</label>
        <input name="loginId" id="loginId" type="text" placeholder="loginId"></div>
      <div class="field half first">
        <label for="password">비밀번호</label>
        <input name="password" id="password" type="email" placeholder="password"></div>
      <div class="field half first">
        <label for="nickname">닉네임</label>
        <input name="nickname" id="nickname" type="text" placeholder="nickname"></div>
      <div class="field half first">
        <label for="email">이메일</label>
        <input name="email" id="email" type="text" placeholder="email"></div>
      <div class="field half first">
        <label for="gender">성별</label>
        <input name="name" id="gender" type="text" placeholder="gender"></div>
      <ul class="actions">
        <li><input value="제출" class="button alt" type="submit"></li>
      </ul>
    </form>
  </div>
</footer>

<div class="copyright">
  Made with: <a href="https://templated.co/">Templated.co</a>
</div>

<!-- Scripts -->
<script type="text/javascript">
    const follow = () => {
        window.location.href = "/follow/add.do?followerId=${sessionScope.loginId.memberId}&followingId=${member.memberId}";
    }
</script>
<script src="assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/member/projection/assets/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/member/projection/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/member/projection/assets/js/main.js"></script>
</body>
</html>
