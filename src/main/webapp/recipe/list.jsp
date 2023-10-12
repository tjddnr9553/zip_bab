<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/list.css">
<title>Document</title>
</head>
<body>
<c:set var="currentPage" value="${param.pageNum != null ? param.pageNum : 1}" />
<div class="container">
 <br/><h2><p><strong>레시피 모음</p></strong></h2>
 <form action="${pageContext.request.contextPath}/recipe/getByTitle.do"><p>편리하고 다양한 즐거운 집밥
    <input type="text" name="title" placeholder="Search.." style="position:absolute; right:210px;"></p></form><br/>
        <div class="container mt-3">
            <div class="row">
                <c:forEach var="r" items="${list}">
                    <div class="col-md-2 mb-4">
                        <div class="card h-100" style="width:200px;">
                            <a href="${pageContext.request.contextPath}/recipe/detail.do?recipeId=${r.recipeId}">
                                <img class="card-img-top img-fluid" src="${r.completePicture}" alt="이미지 없음" style="width:250px;height:220px;" >
                            </a>
                            <div class="card-body">
                                <div class="col text-center">
                                <h6 class="card-title" style="text-align:center"><strong>${r.title}</strong></h6>
                                <a href="${pageContext.request.contextPath}/recipe/detail.do?recipeId=${r.recipeId}" class="btn btn-success btn-sm">레시피</a>&emsp;
                                <a href="${pageContext.request.contextPath}/bookmark/bookmark.do?recipeId=${r.recipeId}&pageNum=${currentPage}" class="btn btn-success btn-sm">북마크</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    <br/>

<!-- 페이징 처리 -->
    <ul class="pagination justify-content-center">
        <c:if test="${currentPage > 1}">
            <li class="page-item">
                <a class="page-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${currentPage - 1}">Previous</a>
            </li>
        </c:if>

    <c:if test="${currentPage > 0 && currentPage < 11}">
        <c:forEach var="p" begin="1" end="10">
            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${p }">${p }</a></li>
        </c:forEach>
    </c:if>
    <c:if test="${currentPage > 10 && currentPage < 21}">
            <c:forEach var="p" begin="11" end="20">
                <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${p }">${p }</a></li>
            </c:forEach>
        </c:if>
    <c:if test="${currentPage > 20 && currentPage < 31}">
        <c:forEach var="p" begin="21" end="30">
            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${p }">${p }</a></li>
        </c:forEach>
    </c:if>
    <c:if test="${currentPage > 30 && currentPage < 39}">
        <c:forEach var="p" begin="31" end="38">
            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${p }">${p }</a></li>
        </c:forEach>
    </c:if>

   <c:if test="${currentPage < 38}">
      <li class='page-item'>
          <a class='page-link' href='${pageContext.request.contextPath}/recipe/listByPage.do?pageNum=${currentPage + 1}'>Next</a>
      </li>
  </c:if>
</ul>
</div>
</body>
</html>