<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <script type="text/javascript">
        const follow = () => {
            window.location.href = "/follow/add.do?followerId=${sessionScope.loginId.memberId}&followingId=${member.memberId}";
        }
        const editProfile = () => {
            window.location.href = "/member/edit.do?loginId=${sessionScope.loginId.loginId}";
        }
    </script>
</head>
<body>
<h3>마이페이지</h3>

<form action="${pageContext.request.contextPath }/member/edit.do" method="post" enctype="multipart/form-data">
    <c:if test="${member.profile != null}">
    <div>
        <img class="profile" src="${pageContext.request.contextPath }/images/profile/${member.profile}" alt="profile_img" width="200px;"></label>
    </div>
    </c:if>
    <c:if test="${member.profile == null}">
    <img class="profile" src="/images/profile/프사기본.jpg" alt="profile_img" width="200px;"></label>
    </c:if>
</form>

    이름: <input type="text" name="loginId" value="${member.nickname }" readonly><br/>
    팔로우: <input type="number" name="followerCount" value="${followerCount}" readonly><br/>
    팔로잉: <input type="number" name="followingCount" value="${followingCount}" readonly>

    <c:if test="${sessionScope.loginId.loginId ne member.loginId }">
    <input type="button" value="팔로우" onclick="follow()">
    </c:if>

    <c:if test="${sessionScope.loginId.loginId eq member.loginId}">
    <input type="button" value="프로필편집" onclick="editProfile()">
    </c:if>

</body>
</html>


