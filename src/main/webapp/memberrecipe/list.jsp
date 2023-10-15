<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/list.css">
    <title>Document</title>
</head>
<body>
<div class="container">
    <br/>
    <h2><p><strong>유저 레시피 모음</strong></p></h2>

    <form action="${pageContext.request.contextPath}/memberrecipe/list.do">
        <p>편리하고 다양한 즐거운 집밥<input type="text" name="title" placeholder="Search.."
                                 style="position:absolute; right:210px;"></p></form>
    <!-- 게시판의 리스트가 존재하는지 확인하는 경우 -->
    <c:if test="${not empty sessionScope.loginId}">
        <p>
            <button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/memberrecipe/create.do'">레시피 작성하기
            </button>
        </p>
    </c:if>

    <br/>
    <div class="container mt-3">
        <div class="row">
            <c:forEach var="r" items="${list}">
                <div class="col-md-2 mb-1">
                    <div class="card h-100" style="width:200px;">
                        <img class="card-img-top img-fluid" src="${pageContext.request.contextPath}/images/memberrecipe/${r.completePicture}" alt="이미지 없음"
                             style="width:250px;height:220px;">
                        <div class="card-body">
                            <h6 class="card-title">
                                <a href="${pageContext.request.contextPath}/memberrecipe/detail.do?memberRecipeId=${r.memberRecipeId}">${r.title}</a>
                            </h6>
                            <p class="card-text">${r.way}</p>
                            <c:if test="${sessionScope.loginId.memberId eq r.memberId}">
                                <button type="button" class="btn btn-primary"
                                        onclick="location.href='${pageContext.request.contextPath }/memberrecipe/delete.do?memberRecipeId='+${r.memberRecipeId}">
                                    삭제하기
                                </button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <br/>
</div>
</body>
</html>