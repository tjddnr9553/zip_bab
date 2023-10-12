<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Insert title here</title>
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

<h3>프로필 수정</h3>
<form action="${pageContext.request.contextPath }/member/edit.do" method="post" enctype="multipart/form-data">
    <c:if test="${m.profile != null}">

<div>
        <label for="imgUpload" class="box"><img class="profile" src="${pageContext.request.contextPath }/images/profile/${m.profile}" alt="profile_img" width="200px;"></label>
</div>
    </c:if>
    <c:if test="${m.profile == null}">
        <label for="imgUpload" class="box"><img class="profile" src="/images/profile/프사기본.jpg" alt="profile_img" width="200px;"></label>
    </c:if>
<input id="imgUpload" type="file" name="profile" class="d-none"><br/>
아이디: <input type="text" name="loginId" value="${m.loginId }"readonly><br/>
비밀번호: <input type="password" name="password" value="${m.password }"readonly><br/>
닉네임: <input type="text" name="nickname" value="${m.nickname }" ><br/>
이메일: <input type="email" name="email" value="${m.email }" readonly><br/>
생년월일: <input type="date" name="birthday" value="${m.birthday }" readonly><br/>
<input type="submit" value="수정" class="btn btn-primary">
<a href="<c:url value='/index.jsp'/>">취소</a>
<!--<script type="text/javascript" src="<c:url value='/member/js/edit.js'/>"></script>-->
</form>
</body>
</html>