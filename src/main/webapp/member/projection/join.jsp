<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head><title>Projection by TEMPLATED</title>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/member/projection/assets/css/main.css">--%>

<%--</head>--%>
<%--<body data-context-path="${pageContext.request.contextPath }">--%>
<%--<h3>회원가입</h3>--%>
<%--<form action="${pageContext.request.contextPath }/member/join.do" method="post" name="f">--%>
<%--    <input type="hidden" name="flag" value="false"/>--%>
<%--    아이디 : <input type="text" name="loginId" onchange="c()"/>--%>
<%--    <input type="button" value="중복체크" onclick="a()"><span id="res"></span>--%>
<%--    <br/>--%>
<%--    비밀번호: <input type="password" name="password"><br/>--%>
<%--    닉네임: <input type="text" name="nickname"><br/>--%>
<%--    이메일: <input type="email" name="email"><br/>--%>
<%--    생년월일: <input type="date" name="birthday"><br/>--%>
<%--    성별: <input type="radio" value="0" name="gender">여성--%>
<%--    <input type="radio" value="1" name="gender">남성<br/>--%>
<%--    <input type="button" value="가입" onclick="b()">--%>
<%--</form>--%>
<%--<script type="text/javascript" src="${pageContext.request.contextPath }/member/js/join.js"></script>--%>

<%--<script src="assets/js/jquery.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/member/projection/assets/js/skel.min.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/member/projection/assets/js/util.js"></script>--%>
<%--<script src="${pageContext.request.contextPath}/member/projection/assets/js/main.js"></script>--%>
<%--</body>--%>
<%--</body>--%>
<%--</html>--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Projection by TEMPLATED</title>
  <meta charset="UTF-8">
  <meta name="robots" content="index, follow, max-image-preview:large, max-snippet:-1, max-video-preview:-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/member/projection/assets/css/main.css">
</head>
<body data-context-path="${pageContext.request.contextPath }">
<footer id="footer">
  <div class="inner">
    <h3>회원가입</h3>
    <form action="${pageContext.request.contextPath }/member/join.do" method="post" name="f">

      <input type="hidden" name="flag" value="false"/>
      <div class="field half first">
        <label for="loginId">아이디</label>
        <div style="display: flex;">
          <input name="loginId" id="loginId" type="text" placeholder="loginId" onchange="c()" style="flex: 1;">
          <div style="margin-left: 10px;">
            <input value="중복체크" class="button alt" type="button" onclick="a()"><span id="res"></span>
          </div>
        </div>
      </div>

      <div class="field half first">
        <label for="password">비밀번호</label>
        <input name="password" id="password" type="password" placeholder="password"></div>
      <div class="field half first">
        <label for="nickname">닉네임</label>
        <input name="nickname" id="nickname" type="text" placeholder="nickname"></div>
      <div class="field half first">
        <label for="email">이메일</label>
        <input name="email" id="email" type="text" placeholder="email"></div>

      <div class="field half first">
        <label for="birthday">생년월일</label>
        <input name="birthday" id="birthday" type="date" placeholder="birthday"></div>



      <div class="field half first">
        <label>성별</label>
        <input name="gender" id="female" type="radio" value="0">
        <label for="female">여성</label>
        <input name="gender" id="male" type="radio" value="1">
        <label for="male">남성</label>
      </div>

<%--    <input type="button" value="가입" onclick="b()">--%>
      <ul class="actions">
        <li><input value="가입" class="button alt" type="button" onclick="b()"></li>
      </ul>
    </form>
  </div>
</footer>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/member/js/join.js"></script>

<script src="assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/member/projection/assets/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/member/projection/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/member/projection/assets/js/main.js"></script>
</html>